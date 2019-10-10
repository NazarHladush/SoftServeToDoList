package service;

import DAO.implementation.ToDoListDAOImpl;
import com.google.gson.Gson;
import model.ToDoList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

public class ToDoListService {
    static ToDoListDAOImpl toDoListDAO = new ToDoListDAOImpl();

    public static void createItem(ToDoList toDoList) throws SQLException {
        toDoListDAO.create(toDoList);
    }

    public static void deleteItem(int id) throws SQLException {
        toDoListDAO.delete(id);
    }

    public static void updateItem(ToDoList toDoList) throws SQLException {
        toDoListDAO.update(toDoList);
    }

    public static String getSortedItems(int id) throws SQLException {
        ArrayList<ToDoList> toDoLists = null;
        toDoLists = (ArrayList<ToDoList>) toDoListDAO.findByUserId(id);
        toDoLists.sort(Comparator.comparing(ToDoList::getTime));
        String jsonInString = new Gson().toJson(toDoLists);
        return jsonInString;
    }
}
