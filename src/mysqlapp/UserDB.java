package mysqlapp;

import java.sql.*;
import java.util.ArrayList;

public class UserDB implements DB {

    public static User select(String uEmail, String uPassword) {

        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String sql = "SELECT * FROM softserve.user WHERE `email` = ? and `password` = ?";
            try (Connection conn = DB.connection();
                 PreparedStatement preparedStatement = createPreparedStatementByEmailAndPassword(conn, uEmail, uPassword, sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int prodId = resultSet.getInt(1);
                    String email = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String firstName = resultSet.getString(4);
                    String secondName = resultSet.getString(5);
                    user = new User(prodId, email, password, firstName, secondName);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return user;
    }

    public static int insert(User user) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String sql = "INSERT INTO softserve.user (`email`, `password`, `first_name`, `second_name`) Values (?, ?, ?, ?)";
            try (Connection conn = DB.connection();
                 PreparedStatement preparedStatement = createPreparedStatementByUser(conn, user, sql)) {
                return preparedStatement.executeUpdate();

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    private static PreparedStatement createPreparedStatementByEmailAndPassword(Connection conn, String uEmail, String uPassword, String sql) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, uEmail);
        ps.setString(2, uPassword);
        return ps;
    }

    private static PreparedStatement createPreparedStatementByUser(Connection conn, User user, String sql) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstName());
        ps.setString(4, user.getSecondName());
        return ps;
    }

}
