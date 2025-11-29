package database_managment;
import java.sql.*;
public class setdata_client {
      private static String Url= "jdbc:mysql://localhost:3306/Client";
    private static  String name= "root";
    private static String password= "Hassan@12";

    public static void main(String[] args) throws SQLException {
        try{
            Connection con = DriverManager.getConnection(Url,name,password);
            System.out.println("connecter");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
