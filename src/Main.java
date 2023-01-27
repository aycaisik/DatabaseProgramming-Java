import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;


        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");
            while (resultSet.next()){
                System.out.println(resultSet.getString("Name"));
            }
            System.out.println("bağlantı oluştu");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }

    }
}
