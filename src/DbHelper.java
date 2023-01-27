import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName="root";
    private String password= "Ben1.miyim";
    private String dbUrl = "jdbc:mysql://localhost:3306/hello";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);

    }
    public void showErrorMessage(SQLException e){
        System.out.println("Error : "+ e.getMessage());
        System.out.println("Error code :" + e.getErrorCode());
    }
}
