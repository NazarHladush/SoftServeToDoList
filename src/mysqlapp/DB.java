package mysqlapp;

import java.sql.Connection;
import java.sql.DriverManager;

public interface DB {
    String url = "jdbc:mysql://localhost:3306/softserve?useSSL=false&serverTimezone=UTC";
    String username = "root";
    String password = "1234567Aa";

    static Connection connection() throws Exception {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
