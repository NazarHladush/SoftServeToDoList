package controller;

import DAO.implementation.UserDAOImpl;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uEmail = request.getParameter("loginname");
        String uPassword = request.getParameter("password");

        String md5Pass = DigestUtils.md5Hex(uPassword);
        UserDAOImpl userDAO = new UserDAOImpl();

        User user = null;
        try {
            user = userDAO.selectByEmailAndPassword(uEmail,md5Pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null){
            request.setAttribute("error", "Login or Password incorrect! Try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }

        HttpSession session = request.getSession();
        System.out.println(session.getId());
        System.out.println(Collections.list(session.getAttributeNames()).toString());
        session.setAttribute("id", user.getId());
        session.setAttribute("user", user.getEmail());
        response.sendRedirect(request.getContextPath()+"/home");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
