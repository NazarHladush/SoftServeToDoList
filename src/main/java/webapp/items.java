package webapp;

import DAO.implementation.ToDoListDAOImpl;
import com.google.gson.Gson;
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
import java.util.Comparator;

@WebServlet("/items")
public class items extends HttpServlet {
    ToDoListDAOImpl toDoListDAO = new ToDoListDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("id");
        ArrayList<ToDoList> toDoLists = null;
        try {
            toDoLists = (ArrayList<ToDoList>) toDoListDAO.findByUserId(userId);
            toDoLists.sort(Comparator.comparing(ToDoList::getTime));
            String jsonInString = new Gson().toJson(toDoLists);
            resp.getWriter().append(jsonInString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
