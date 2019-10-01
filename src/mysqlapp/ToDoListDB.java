package mysqlapp;

import java.sql.*;
import java.util.ArrayList;

public class ToDoListDB implements DB {

    public static ArrayList<ToDoList> selectAll(int id) {
        String sql = "SELECT todolist.id, title, description, `action`, `time` FROM softserve.todolist JOIN user ON todolist.user_id = user.id where todolist.user_id =?";
        ArrayList<ToDoList> toDoLists = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DB.connection();
                 PreparedStatement preparedStatement = createPreparedStatementById(conn, id, sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int prodId = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    String action = resultSet.getString(4);
                    String time = resultSet.getTimestamp(5).toString();
                    ToDoList toDoList = new ToDoList(prodId, title, description, action, time);
                    toDoLists.add(toDoList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toDoLists;
    }

    public static int insert(ToDoList toDoList, int userId) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String sql = "INSERT INTO `softserve`.`todolist` (`title`, `description`, `action`, `user_id`) Values (?, ?, ?, ?)";
            try (Connection conn = DB.connection();
                 PreparedStatement preparedStatement = createPreparedStatementByToDoList(conn, toDoList, userId, sql)) {
                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    private static PreparedStatement createPreparedStatementById(Connection conn, int userId, String sql) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);
        return ps;
    }

    private static PreparedStatement createPreparedStatementByToDoList(Connection conn, ToDoList toDoList, int userId, String sql) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, toDoList.getTitle());
        ps.setString(2, toDoList.getDescription());
        ps.setString(3, toDoList.getAction());
        ps.setInt(4,userId);
        return ps;
    }
}
