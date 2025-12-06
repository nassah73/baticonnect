package database_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // 🛑 بيانات الاتصال الثابتة
    private static final String HOST_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Hassan@12";

    // 🌟🌟🌟 المتغير الجديد للـProperties (الذي سيحل المشكل) 🌟🌟🌟
    private static final String CONNECTION_PROPERTIES =
            "?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false&useOldAliasMetadataBehavior=true";

    public static Connection getConnection(String dbName) throws SQLException {
        // نجمع HOST_URL مع اسم قاعدة البيانات (dbName) ومع الـProperties
        String fullURL = HOST_URL + dbName + CONNECTION_PROPERTIES;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(fullURL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("❌ خطأ: لم يتم العثور على MySQL JDBC Driver.");
            throw new SQLException("Database Driver not found.", e);
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("❌ خطأ في إغلاق الاتصال: " + e.getMessage());
            }
        }
    }
}