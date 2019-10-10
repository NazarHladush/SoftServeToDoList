package servlets;

import DAO.implementation.ToDoListDAOImpl;
import model.ToDoList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet("/item/update")
public class ItemUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ToDoListDAOImpl toDoListDAO = new ToDoListDAOImpl();
        int userId = (int) req.getSession().getAttribute("id");
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String action = req.getParameter("action");
        LocalDateTime time = LocalDateTime.parse(req.getParameter("datetime"));

        try {
            toDoListDAO.update(new ToDoList(id, title, description, action, time, userId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
