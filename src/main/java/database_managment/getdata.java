package database_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class getdata {
    private final String query;
    private final String URL = "jdbc:mysql://localhost:3306/java_schema";
    private final String USER = "root";
    private final String PASSWORD = "Hassan@12";

    public getdata(String query) {
        this.query = query;
    }

    // A better pattern: Process data and close resources inside the method
    public List<String> getData() throws SQLException {
        // Use try-with-resources to automatically close con, stmt, and rs
        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(this.query)
        ) {
            List<String> results = new ArrayList<>();
            // Example processing: Just getting the String value of the first column
            while (rs.next()) {
                results.add(rs.getString(1));
            }
            return results;
        } // Resources are automatically closed here
    }

    // The closeConnection() method is now unnecessary.
}
