import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rstask"; //DataBase Connection Detail
        String username = "root"; //MySQL username
        String password = "harsh"; //MySQL password
        Scanner sc = new Scanner(System.in); // Scanner for user input
        System.out.println("Enter Student ID to Update:");
        int id = sc.nextInt();//taking id of student
        System.out.println("Enter New Marks:");
        int marks = sc.nextInt();//adding marks for the student

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Establish connection to database
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            // Create a statement to execute SQL queries
            String sql = "UPDATE Student SET marks = " + marks + " WHERE StudentID = " + id;
            // Execute the update query
            int rowsAffected = stmt.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Success! Marks updated.");
            } else {
                System.out.println("Student ID not found.");
            }//checkin if updated or not
            stmt.close();
            con.close();
            sc.close();//closing
        } catch (Exception e) {
            //showing the error
            e.printStackTrace();
        }
    }
}