package controller;

import DAO.implementation.UserDAOImpl;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = DigestUtils.md5Hex(request.getParameter("password"));

        User user = new User(request.getParameter("loginname"), password, request.getParameter("firstName"), request.getParameter("secondName"));

        UserDAOImpl userDAO = new UserDAOImpl();

        try {
            userDAO.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SoftServe_war_exploded/login");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
