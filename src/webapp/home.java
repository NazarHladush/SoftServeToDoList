package webapp;

import mysqlapp.ToDoList;
import mysqlapp.ToDoListDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/home")
public class home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("id");

        ToDoList toDoList = new ToDoList(title, description, action);

        ToDoListDB.insert(toDoList, userId);

        response.sendRedirect(request.getContextPath() + "/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("user"));
        ArrayList<ToDoList> toDoLists = ToDoListDB.selectAll((int)session.getAttribute("id"));
        request.setAttribute("todolists", toDoLists);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
