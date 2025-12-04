package controler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class SignUpController {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label errorMessageLabel;

    @FXML private RadioButton clientRoleRadio;
    @FXML private RadioButton responsableRoleRadio;
    @FXML private RadioButton chiefRoleRadio;

    @FXML private HBox clientRoleBox;
    @FXML private HBox responsableRoleBox;
    @FXML private HBox chiefRoleBox;

    private String selectedRole = null;
    private ToggleGroup roleToggleGroup;

    // ... (initialize and handleRoleSelection functions remain the same) ...

    @FXML
    public void initialize() {
        roleToggleGroup = new ToggleGroup();
        clientRoleRadio.setToggleGroup(roleToggleGroup);
        responsableRoleRadio.setToggleGroup(roleToggleGroup);
        chiefRoleRadio.setToggleGroup(roleToggleGroup);

        clientRoleRadio.setUserData("client");
        responsableRoleRadio.setUserData("responsible");
        chiefRoleRadio.setUserData("chief");

        // الاختيار الافتراضي: Chief
        chiefRoleRadio.setSelected(true);
        selectedRole = (String) chiefRoleRadio.getUserData();

        roleToggleGroup.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle != null) {
                selectedRole = (String) newToggle.getUserData();
            }
        });
    }

    @FXML
    private void handleRoleSelectionClient(MouseEvent event) {
        clientRoleRadio.setSelected(true);
    }

    @FXML
    private void handleRoleSelectionResponsible(MouseEvent event) {
        responsableRoleRadio.setSelected(true);
    }

    @FXML
    private void handleRoleSelectionChief(MouseEvent event) {
        chiefRoleRadio.setSelected(true);
    }


    // ---------------------------------------------
    // منطق التسجيل - تم التعديل للانتقال المباشر
    // ---------------------------------------------
    @FXML
    private void handleSignupButtonAction(ActionEvent event) {
        String fullName = fullNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        errorMessageLabel.setText("");

        // 1. التحقق من البيانات
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorMessageLabel.setText("المرجو ملء جميع الحقول.");
            return;
        }

        // 2. التحقق من تطابق كلمة المرور
        if (!password.equals(confirmPassword)) {
            errorMessageLabel.setText("كلمة المرور وتأكيدها غير متطابقين.");
            return;
        }

        // 3. التحقق من اختيار الدور
        if (selectedRole == null) {
            errorMessageLabel.setText("المرجو اختيار الدور.");
            return;
        }

        // 4. TODO: تنفيذ منطق التسجيل (DAO) - هنا يتم إدخال المستخدم الجديد في قاعدة البيانات

        System.out.println("User registered successfully. Role: " + selectedRole + ", Email: " + email);

        // 5. 🌟 الانتقال المباشر إلى لوحة التحكم بناءً على الدور 🌟
        loadDashboard(selectedRole);
    }

    // ---------------------------------------------
    // التنقل إلى شاشة الدخول (Sign In)
    // ---------------------------------------------

    @FXML
    private void handleBackToLoginClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signIn.fxml"));
            Parent root = loader.load();

            // استخدام fullNameField للحصول على Stage
            Stage stage = (Stage) fullNameField.getScene().getWindow();

            stage.setTitle("ConstructionHub - Sign In");
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("فشل تحميل صفحة تسجيل الدخول. تأكد من مسار /view/signIn.fxml");
        }
    }

    // ---------------------------------------------
    // 🌟 دالة تحميل لوحة التحكم المضافة (جديدة) 🌟
    // ---------------------------------------------
    private void loadDashboard(String role) {
        String fxmlPath;
        String title;

        switch (role) {
            case "chief":
                fxmlPath = "/view/chefFXML/dashboard.fxml";
                title = "Chief Dashboard";
                break;
            case "responsible":
                fxmlPath = "/view/responsableFXML/projects.fxml";
                title = "Responsable Dashboard";
                break;
            case "client":
                fxmlPath = "/view/clientFXML/projects.fxml";
                title = "Client Dashboard";
                break;
            default:
                // في حال حدوث خطأ غير متوقع في الدور
                errorMessageLabel.setText("خطأ غير متوقع في الدور، جارٍ العودة لصفحة الدخول.");
                handleBackToLoginClick(null);
                return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) fullNameField.getScene().getWindow();
            stage.setTitle(title);
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("فشل في تحميل لوحة التحكم: " + role + ". تأكد من المسار.");
        }
    }
}