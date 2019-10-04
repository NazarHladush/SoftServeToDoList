package webapp;

import DAO.implementation.UserDAOImpl;
import exeption.EmailAlreadyExists;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        String email = request.getParameter("loginname");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");

        User user = new User(email, password, firstName, secondName);



        try {
            Service.registration(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EmailAlreadyExists e) {
            request.setAttribute("error", "This email already exists");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
        response.sendRedirect("/SoftServe_war_exploded/login");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
