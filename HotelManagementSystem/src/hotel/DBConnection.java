package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // ✅ Correct database URL with IP instead of "localhost"
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/hotel_db";
    private static final String USER = "root";  // Change if needed
    private static final String PASS = "root";  // Change if needed

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Load MySQL Driver
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Database Connected Successfully!"); // Debugging line
        } catch (ClassNotFoundException e) {
            System.err.println("❌ ERROR: MySQL JDBC Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ ERROR: Database Connection Failed!");
            e.printStackTrace();
        }
        return conn;
    }
}

