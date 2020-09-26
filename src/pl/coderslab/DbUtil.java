package pl.coderslab;

import java.sql.DriverManager;
import java.sql.SQLException;

// odpowiedzialna za utworzenie połączenia do bazy.
public class DbUtil {
    private static String DB_URL = "jdbc:mysql://localhost:3306/workshop2" +
            "?useSSL=false&characterEncoding=utf8" +
            "&serverTimezone=UTC";
    private static String DB_USER = "root";
    private static String DB_PASS = "coderslab";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
