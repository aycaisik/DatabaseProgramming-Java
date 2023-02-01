import java.sql.*;
import java.util.ArrayList;

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
            ArrayList<Country> countries = new ArrayList<>();
            while (resultSet.next()){
               // System.out.println(resultSet.getString("Name"));
                countries.add(new Country(resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region") ));
            }
            System.out.println(countries.size());
            System.out.println("bağlantı oluştu");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }

    }
}
