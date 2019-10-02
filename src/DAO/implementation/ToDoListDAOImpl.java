package DAO.implementation;

import DAO.ToDoListDAO;
import connection.ConnectionManager;
import model.ToDoList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoListDAOImpl implements ToDoListDAO {
    //language=SQL
    private static final String DELETE = "DELETE FROM softserve.todolist WHERE id=?";
    //language=SQL
    private static String FIND_BY_USER_ID = "SELECT * FROM softserve.todolist where user_id=?";
    //language=SQL
    private static String FIND_ALL = "SELECT * FROM `softserve.todolist`";
    //language=SQL
    private static String FIND_BY_ID = "SELECT * FROM `softserve.todolist` WHERE id=?";
    //language=SQL
    private static String CREATE = "INSERT INTO softserve.todolist (`title`, `description`, `action`, `user_id`) Values (?, ?, ?, ?)";
    //language=SQL
    private static String UPDATE = "UPDATE softserve.todolist SET (`title=?`, `description=?`, `action=?`, `time=dafault`) WHERE `user.id`=?";

    private static PreparedStatement createPreparedStatementByUserId(Connection connection, String sql, Integer id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    private static PreparedStatement createPreparedStatementById(Connection connection, String sql, int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    private static PreparedStatement createPreparedStatementForCreate(Connection connection, String sql, ToDoList toDoList) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, toDoList.getTitle());
        ps.setString(2, toDoList.getDescription());
        ps.setString(3, toDoList.getAction());
        ps.setInt(4, toDoList.getUserId());
        return ps;
    }

    private static PreparedStatement createPreparedStatementForUpdate(Connection connection, String sql, ToDoList toDoList) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, toDoList.getTitle());
        ps.setString(2, toDoList.getDescription());
        ps.setString(3, toDoList.getAction());
        ps.setInt(4, toDoList.getId());
        return ps;
    }

    @Override
    public List<ToDoList> findAll() throws SQLException {
        List<ToDoList> toDoLists = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                String action = resultSet.getString(4);
                Timestamp time = resultSet.getTimestamp(5);
                int userId = resultSet.getInt(6);
                toDoLists.add(new ToDoList(id, title, description, action, time, userId));
            }
        }
        return toDoLists;
    }

    @Override
    public ToDoList findById(Integer id) throws SQLException {
        ToDoList toDoList = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementById(connection, FIND_BY_ID, id);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                String action = resultSet.getString(4);
                Timestamp time = resultSet.getTimestamp(5);
                int userId = resultSet.getInt(6);
                toDoList = new ToDoList(id, title, description, action, time, userId);
            }
        }
        return toDoList;
    }

    @Override
    public int create(ToDoList toDoList) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementForCreate(connection, CREATE, toDoList)) {
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(ToDoList toDoList) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementForUpdate(connection, UPDATE, toDoList)) {
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementById(connection, DELETE, id)) {
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<ToDoList> findByUserId(Integer id) throws SQLException {
        List<ToDoList> toDoLists = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementByUserId(connection, FIND_BY_USER_ID, id);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int toDoListId = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                String action = resultSet.getString(4);
                Timestamp time = resultSet.getTimestamp(5);
                int userId = resultSet.getInt(6);
                toDoLists.add(new ToDoList(toDoListId, title, description, action, time, userId));
            }
        }
        return toDoLists;
    }

}
