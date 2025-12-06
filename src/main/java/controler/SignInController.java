package controler;

import database_Dao.UtilisateurDAO; // <--- إضافة: استيراد DAO
import user_pak.Utilisateur;       // <--- إضافة: استيراد كائن المستخدم

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.control.*;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {

    // نستخدم "usernameField" لتخزين الإيميل
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorMessageLabel;

    /**
     * تُستدعى عند النقر على زر "Sign In"
     * تتحقق من بيانات الدخول في قواعد البيانات (chief, client, responsable).
     */
    @FXML
    private void handleSignInButtonAction(ActionEvent event) {
        String email = usernameField.getText().trim(); // نستخدم الحقل كإيميل
        String password = passwordField.getText().trim();

        errorMessageLabel.setText("");

        if (email.isEmpty() || password.isEmpty()) {
            errorMessageLabel.setText("المرجو إدخال الإيميل و كلمة المرور.");
            return;
        }

        // 🛑 منطق التحقق من قاعدة البيانات (DAO Logic) 🛑
        UtilisateurDAO dao = new UtilisateurDAO();
        Utilisateur loggedInUser = dao.login(email, password);

        // التحقق من النتيجة
        if (loggedInUser != null) {
            // المصادقة نجحت: تحميل الداشبورد بناءً على الدور المسترجع من الـDB
            System.out.println("✅ تم تسجيل الدخول بنجاح! الدور: " + loggedInUser.getRole());
            loadDashboard(loggedInUser.getRole(), event);
        } else {
            // المصادقة فشلت
            errorMessageLabel.setText("خطأ: الإيميل أو كلمة المرور غير صحيحة.");
        }
    }

    /**
     * تُستدعى عند النقر على رابط "Sign up here" أو زر "Sign Up"
     */
    @FXML
    private void handleSignupLinkClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signUp.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("ConstructionHub - Sign Up");
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("Failed to load sign up page.");
        }
    }

    /**
     * دالة تحميل الداشبورد الخاص بالدور (Chief, Responsable, Client)
     * مع تحديد الأبعاد.
     */
    private void loadDashboard(String role, ActionEvent event) {
        String fxmlPath;
        String title;
        double width;
        double height;

        // ملاحظة: قمنا بتغيير "chef" إلى "chief" في الـswitch case ليتطابق مع اسم الدور في قاعدة البيانات
        switch (role) {
            case "chief":
                fxmlPath = "/view/chefFXML/dashboard.fxml";
                title = "Chief Dashboard";
                width = 1200;
                height = 850;
                break;
            case "responsable":
                fxmlPath = "/view/responsableFXML/responsable_dashboard.fxml";
                title = "Responsable Dashboard";
                width = 1000;
                height = 700;
                break;
            case "client":
                fxmlPath = "/view/clientFXML/projects.fxml";
                title = "Client Dashboard";
                width = 900;
                height = 600;
                break;
            default:
                errorMessageLabel.setText("Unknown role error.");
                return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, width, height);

            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("فشل في تحميل لوحة التحكم: " + role);
        }
    }
}