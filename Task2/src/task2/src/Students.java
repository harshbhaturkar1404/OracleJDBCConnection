import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Students {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rstask";
        String username = "root";
        String password = "harsh";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Student";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("ID\tName\tAge \tCourse");
            System.out.println("----------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("StudentID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String Course =rs.getString("Course");
                System.out.println(id + "\t" + name + "\t" + age + "\t" + Course);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}