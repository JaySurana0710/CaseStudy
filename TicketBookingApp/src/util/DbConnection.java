package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/trainticket";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, "root", "jaysurana");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

