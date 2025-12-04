package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorMessageLabel;

    /**
     * تُستدعى عند النقر على زر "Sign In"
     * تستخدم المصادقة الثابتة (Hardcoded) للانتقال إلى الداشبورد.
     */
    @FXML
    private void handleSignInButtonAction(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        errorMessageLabel.setText(""); // مسح رسائل الخطأ السابقة

        if (username.isEmpty() || password.isEmpty()) {
            errorMessageLabel.setText("Please enter your email and password.");
            return;
        }

        // المصادقة الثابتة (Hardcoded Authentication)
        String role = null;
        if (username.equals("chief") && password.equals("123")) {
            role = "chef";
        } else if (username.equals("resp") && password.equals("123")) {
            role = "responsable";
        } else if (username.equals("client") && password.equals("123")) {
            role = "client";
        }

        if (role != null) {
            // المصادقة نجحت: تحميل الداشبورد بناءً على الدور
            loadDashboard(role, event);
        } else {
            // المصادقة فشلت
            errorMessageLabel.setText("Error: Invalid email or password.");
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

            // الحصول على الـ Stage وتغيير الـ Root
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("ConstructionHub - Sign Up");
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("Failed to load sign up page.");
        }
    }

    /**
     * دالة تحميل الداشبورد الخاص بالدور (Chef, Responsable, Client)
     * مع تحديد الأبعاد لحل مشكلة القياس.
     */
    private void loadDashboard(String role, ActionEvent event) {
        String fxmlPath;
        String title;
        double width;
        double height;

        switch (role) {
            case "chef":
                fxmlPath = "/view/chefFXML/dashboard.fxml";
                title = "Chief Dashboard";
                width = 1200; // الأبعاد المطلوبة لواجهة المدير
                height = 850;
                break;
            case "responsable":
                fxmlPath = "/view/responsableFXML/responsable_dashboard.fxml";
                title = "Responsable Dashboard";
                width = 1000;
                height = 700;
                break;
            case "client":
                fxmlPath = "/view/clientFXML/client_dashboard.fxml";
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

            // الحصول على الـ Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // ✅ إنشاء Scene جديد بأبعاد محددة لحل مشكلة القياس
            Scene scene = new Scene(root, width, height);

            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("Failed to load Dashboard for role: " + role);
        }
    }
}