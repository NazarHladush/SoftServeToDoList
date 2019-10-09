package webapp;

import DAO.implementation.ToDoListDAOImpl;
import model.ToDoList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

@WebServlet("/home")
public class home extends HttpServlet {
        ToDoListDAOImpl toDoListDAO = new ToDoListDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        LocalDateTime time = LocalDateTime.parse(request.getParameter("datetime"));
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("id");
        ToDoList toDoList = new ToDoList(title, description, action, time, userId);
        try {
            toDoListDAO.create(toDoList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home2.jsp").forward(request, response);
    }

}
