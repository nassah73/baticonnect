package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class AddResponsableController {

    // حقن العناصر من FXML
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField jobTitleField;
    @FXML
    private Button createButton;

    @FXML
    public void initialize() {
        // تهيئة أي شيء عند بدء الواجهة (غير ضروري حالياً)
    }

    // دالة تنفيذ عملية إضافة المسؤول عند الضغط على زر "Create Account"
    @FXML
    private void handleCreateResponsable(ActionEvent event) {
        // 1. جلب البيانات من الحقول
        String fullName = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String jobTitle = jobTitleField.getText();

        // 2. التحقق البسيط من البيانات (يجب توسيع التحقق لاحقاً)
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("Error: Please fill in all required fields.");
            // يمكنك إضافة عرض رسالة خطأ للمستخدم هنا (مثل Label)
            return;
        }

        // 3. تنفيذ منطق الحفظ (مثلاً، إرسال البيانات إلى قاعدة بيانات أو API)
        System.out.println("--- New Responsable Added ---");
        System.out.println("Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Job Title: " + jobTitle);
        // ملاحظة: لا يجب طباعة كلمة المرور في Console الحقيقي

        // 4. إغلاق النافذة المنبثقة
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.close();

        // 5. يمكنك إضافة تحديث للواجهة الرئيسية (ResponsablesController) هنا
    }
}