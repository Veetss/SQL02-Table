import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Connection con = null;

        try {
            String db_url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "Password!";

            con = DriverManager.getConnection(db_url, user, password);

            Statement s = con.createStatement();

            String sql = "CREATE TABLE student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";

            s.executeUpdate(sql);

            s.execute("insert into student (last_name,first_name) value (\"Boukoti\", \"Ismail\");");
            s.execute("insert into student (last_name,first_name) value (\"Vassarotti\", \"Vittoria\");");
            s.execute("insert into student (last_name,first_name) value (\"De Fenzo\", \"Marco\");");
            s.execute("insert into student (last_name,first_name) value (\"Mustata\", \"Elena Alina\");");

            System.out.println("Table created.");

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(con != null)
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
