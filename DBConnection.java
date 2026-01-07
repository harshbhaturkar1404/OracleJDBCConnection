import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public static void main(String[] args) {
        // MySQL JDBC Driver and URL
        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://localhost:3306/JdCon";
        String userName = "root";
        String password = "harsh";
        try {
            // Load MySQL JDBC Driver
            Class.forName(mysqlDriver);
            // Create Connection
            Connection con = DriverManager.getConnection(mysqlUrl, userName, password);
            // Success message
            System.out.println("CONNECTION SUCCESSFUL...");
            // Close connection
            con.close();
        } catch (Exception ex) {
            System.out.println("CONNECTION FAILED!");
            ex.printStackTrace();
        }
    }
}
