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
import java.util.ArrayList;

@WebServlet("/home")
public class home extends HttpServlet {
        ToDoListDAOImpl toDoListDAO = new ToDoListDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        System.out.println(request.getParameter("datetime"));
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("id");
        ToDoList toDoList = new ToDoList(title, description, action, userId);
        try {
            toDoListDAO.create(toDoList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("id");
        ArrayList<ToDoList> toDoLists = null;
        try {
            toDoLists = (ArrayList<ToDoList>) toDoListDAO.findByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("todolists", toDoLists);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
