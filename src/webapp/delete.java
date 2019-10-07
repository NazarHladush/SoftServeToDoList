package webapp;

import DAO.implementation.ToDoListDAOImpl;
import DAO.implementation.UserDAOImpl;
import model.ToDoList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/home/delete/*")
public class delete extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
        ToDoListDAOImpl toDoList = new ToDoListDAOImpl();
        try {
            toDoList.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("home.jsp");
    }
}
