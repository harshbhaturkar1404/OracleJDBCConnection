import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rstask"; //DataBase Connection Detail
        String username = "root"; //MySQL username
        String password = "harsh"; //MySQL password
        Scanner sc = new Scanner(System.in); // Scanner for user input
        System.out.println("Enter Student ID to Delete:");
        int id = sc.nextInt();//taking id of student to delete
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection to database
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            // Create a statement to execute SQL queries
            String sql = "DELETE FROM Student WHERE StudentID = " + id;
            // Execute the delete query
            int rowsAffected = stmt.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Success! Marks Deleted.");
            } else {
                System.out.println("Student ID not found.");
            }//checkin if deleted or not
            stmt.close();
            con.close();
            sc.close();//closing
        } catch (Exception e) {
            //showing the error
            e.printStackTrace();
        }
    }
}