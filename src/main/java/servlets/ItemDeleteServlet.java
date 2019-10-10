package servlets;

import service.ToDoListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/item/delete/*")
public class ItemDeleteServlet extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
        try {
            ToDoListService.deleteItem(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("home.jsp");
    }
}
