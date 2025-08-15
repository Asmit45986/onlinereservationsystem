import java.sql.*;

public class DatabaseConnector {
    static final String URL = "jdbc:mysql://localhost:3306/ReservationSystemDB";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}