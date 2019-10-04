package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/softserve?serverTimezone=Europe/Kiev&useSSL=false";
    //&serverTimezone=UTC
    private static final String username = "root";
    private static final String password = "1234567Aa";

    private static Connection connection = null;

    private ConnectionManager() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
