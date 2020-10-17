package dao;

import java.sql.*;

public class MySqlConnection {
    public Connection getNewConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/kazansightseeing?" +
                "serverTimezone=Europe/Moscow&useUnicode=true";
        String user = "java_itis_ks";
        String password = "java_itis_ks";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, user, password);
    }
}
