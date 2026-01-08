import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public static void main(String[] args) {

        String mysqlDriver = "com.mysql.cj.jdbc.Driver";//DataBase Connection Detail
        String mysqlUrl = "jdbc:mysql://localhost:3306/JdCon";
        String userName = "root";
        String password = "harsh";
        try {

            Class.forName(mysqlDriver);

            Connection con = DriverManager.getConnection(mysqlUrl, userName, password);
            //Connection with database
            System.out.println("CONNECTION SUCCESSFUL...");

            con.close();
        } catch (Exception ex) {
            System.out.println("CONNECTION FAILED!");
            ex.printStackTrace();
        }
    }
}
