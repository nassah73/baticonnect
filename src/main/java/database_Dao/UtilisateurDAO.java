package database_Dao;

import user_pak.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UtilisateurDAO {

    // ... هنا توجد دالة insertUser القديمة ...

    // 🌟🌟🌟 ضيفي دالة LOGIN هنا 🌟🌟🌟

    /**
     * التحقق من بيانات الدخول والبحث في جميع قواعد البيانات الثلاثة
     *
     * @param email    الإيميل المدخل
     * @param password كلمة السر المدخلة
     * @return كائن المستخدم (Utilisateur) إذا كان الدخول ناجحاً، أو null إذا فشل.
     */
    public Utilisateur login(String email, String password) {
        String[] databases = {"chief", "client", "responsable"};
        String SELECT_USER_SQL =
                "SELECT nom, prenom, email, motDePasse, role FROM utilisateur WHERE email = ? AND motDePasse = ?";

        for (String dbName : databases) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;

            try {
                connection = DatabaseConnection.getConnection(dbName);
                preparedStatement = connection.prepareStatement(SELECT_USER_SQL);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("role");

                    // هنا ننشئ كائن المستخدم
                    Utilisateur user = new Utilisateur(
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("motDePasse")
                    );
                    user.setRole(role);

                    System.out.println("✅ تم العثور على المستخدم بنجاح في DB: " + dbName + " بالدور: " + role);
                    return user;
                }
            } catch (SQLException e) {
                // يمكن أن يحدث هذا الخطأ إذا لم يكن الجدول موجوداً في إحدى الـDBs
                System.err.println("⚠️ فشل البحث في DB: " + dbName + ".");
                continue;
            } finally {
                // إغلاق الموارد
                DatabaseConnection.closeConnection(connection);
            }
        }
        return null;
    }

    public boolean insertUser(user_pak.Utilisateur user, String role) {
        String dbName;

        switch (role) {
            case "chief":
                dbName = "chief";
                break;
            case "responsable":
                dbName = "responsable";
                break;
            case "client":
                dbName = "client";
                break;
            default:
                System.err.println("❌ خطأ: دور غير معروف للإدراج.");
                return false;
        }

        // 🛑 SQL Statement: تأكدي من أن أسماء الأعمدة مطابقة لقاعدة بياناتك
        String INSERT_USER_SQL = "INSERT INTO utilisateur (nom, prenom, email, motDePasse, role) VALUES (?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. الاتصال بقاعدة البيانات الصحيحة
            connection = DatabaseConnection.getConnection(dbName);

            // 2. إعداد الـSQL Statement
            preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getMotDePasse());
            preparedStatement.setString(5, role); // تخزين الدور في جدول المستخدم

            // 3. التنفيذ
            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("✅ تم تسجيل المستخدم في DB: " + dbName);
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            // خطأ في SQL (قد يكون الإيميل مكرر - Unique Constraint)
            System.err.println("❌ فشل إدراج المستخدم في DB: " + dbName + ". الرسالة: " + e.getMessage());
            return false;
        } finally {
            // إغلاق الموارد
            DatabaseConnection.closeConnection(connection);
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
