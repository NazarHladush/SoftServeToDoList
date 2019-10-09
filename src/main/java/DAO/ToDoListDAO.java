package DAO;

import model.ToDoList;

import java.sql.SQLException;
import java.util.List;

public interface ToDoListDAO extends GeneralDAO<ToDoList, Integer> {
    List<ToDoList> findByUserId(Integer id) throws SQLException;
}
