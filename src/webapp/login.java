package webapp;

import exeption.IncorrectLoginData;
import model.User;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uEmail = request.getParameter("loginname");
        String uPassword = request.getParameter("password");

        try {
            User user = Service.login(uEmail, uPassword);
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            response.sendRedirect(request.getContextPath() + "/home");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IncorrectLoginData incorrectLoginData) {
            request.setAttribute("error", "Login or Password incorrect! Try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
