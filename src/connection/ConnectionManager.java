package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static String url = "jdbc:mysql://localhost:3306/softserve?useSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1234567Aa";

    private static Connection connection = null;

    private ConnectionManager() {

    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
