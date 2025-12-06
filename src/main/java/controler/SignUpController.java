package controler;

import resources_chief.ChefDeChantier; // <--- ADDED: استيراد كلاس Chief
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import java.io.IOException;
import database_Dao.UtilisateurDAO;

import client.Client;
public class SignUpController {

    // الحقول المرتبطة بالـFXML
    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private RadioButton clientRoleRadio;
    @FXML private RadioButton responsableRoleRadio;
    @FXML private RadioButton chiefRoleRadio;
    @FXML private HBox clientRoleBox; // تأكد من إضافة الـHBox ديال العميل
    @FXML private HBox responsableRoleBox;
    @FXML private HBox chiefRoleBox;
    @FXML private Label errorMessageLabel;

    // ---------------------------------------------
    // الحقول الإضافية لتعقب الحالة
    // ---------------------------------------------
    // ADDED: حقل لتخزين الدور المختار بشكل دائم
    private String selectedRole = "client";

    // ADDED: حقل لتخزين الكائن (Object) الذي تم إنشاؤه
    private Object newUserObject;


    // ---------------------------------------------
    // تهيئة الكونترولر (Initialization)
    // ---------------------------------------------
    @FXML
    public void initialize() {
        // نضبط الدور الافتراضي على 'client' في البداية
        clientRoleRadio.setSelected(true);
        // نربط الراديو بأزرار الاختيار ليعمل بشكل صحيح عند النقر على الـHBox
        setupRoleToggleGroup();
    }

    private void setupRoleToggleGroup() {
        // نستخدم ToggleGroup للتأكد من اختيار زر واحد فقط
        ToggleGroup group = new ToggleGroup();
        clientRoleRadio.setToggleGroup(group);
        responsableRoleRadio.setToggleGroup(group);
        chiefRoleRadio.setToggleGroup(group);
        // نربط HBox بالنقر
        clientRoleBox.setOnMouseClicked(e -> handleRoleSelectionClient(e));
    }


    // ---------------------------------------------
    // دوال اختيار الدور
    // ---------------------------------------------
    @FXML
    private void handleRoleSelectionClient(MouseEvent event) {
        clientRoleRadio.setSelected(true);
        selectedRole = "client";
        System.out.println("Role selected: Client");
    }

    @FXML
    private void handleRoleSelectionResponsible(MouseEvent event) {
        responsableRoleRadio.setSelected(true);
        selectedRole = "responsable";
        System.out.println("Role selected: Responsible");
    }

    @FXML
    private void handleRoleSelectionChief(MouseEvent event) {
        chiefRoleRadio.setSelected(true);
        selectedRole = "chief";
        System.out.println("Role selected: Chief");
    }


    // ---------------------------------------------
    // منطق التسجيل (Signup Logic)
    // ---------------------------------------------
    @FXML
    private void handleSignupButtonAction(ActionEvent event) {
        String fullName = fullNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();

        errorMessageLabel.setText("");

        // 1. التحقق من البيانات
        String confirmPassword = confirmPasswordField.getText();
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorMessageLabel.setText("المرجو ملء جميع الحقول.");
            return;
        }
        if (!password.equals(confirmPassword)) {
            errorMessageLabel.setText("كلمة المرور وتأكيدها غير متطابقين.");
            return;
        }
        if (selectedRole == null) {
            errorMessageLabel.setText("المرجو اختيار الدور.");
            return;
        }

        // 2. تحليل الاسم
        String[] names = fullName.split(" ", 2);
        String nom = names.length > 0 ? names[0] : "";
        String prenom = names.length > 1 ? names[1] : "";

        // 3. إنشاء كائن المستخدم (Utilisateur Object Creation)
        // نستخدم كائناً من النوع الأب (Utilisateur) لاستقبال أي دور (Chief, Client, Responsable)
        user_pak.Utilisateur userToRegister = null;

        if ("chief".equals(selectedRole)) {
            // خلق كائن ChefDeChantier
            userToRegister = new ChefDeChantier(nom, prenom, email, password);
            // (يمكنك حذف طباعة المعلومات لتبسيط الكود النهائي)
        } else if ("client".equals(selectedRole)) {
            userToRegister = new client.Client(nom, prenom, email, password);
        } else if ("responsable".equals(selectedRole)) {
            userToRegister = new responsable.Responsable(nom, prenom, email, password);
        }

        // 4. 🚀 استدعاء الـDAO وإدخال الكائن في قاعدة البيانات
        if (userToRegister != null) {
            // ننشئ كائن الـDAO
            UtilisateurDAO dao = new UtilisateurDAO();

            // ونحاول إدخال المستخدم، مع تمرير الكائن والدور المختار
            if (dao.insertUser(userToRegister, selectedRole)) {
                System.out.println("✅ تم تسجيل المستخدم (" + selectedRole + ") بنجاح.");

                // 5. الانتقال المباشر إلى لوحة التحكم (فقط عند النجاح)
                loadDashboard(selectedRole);
            } else {
                // فشل التسجيل (بسبب مشكل في الاتصال أو الإيميل مكرر)
                errorMessageLabel.setText("❌ فشل التسجيل. تأكد من إعدادات MySQL ومن أن الإيميل غير مكرر.");
                return;
            }
        } else {
            errorMessageLabel.setText("خطأ في تحديد الدور، يرجى المحاولة مرة أخرى.");
        }
    }

    // ---------------------------------------------
    // التنقل إلى شاشة الدخول (Sign In) - (كما هي)
    // ---------------------------------------------

    @FXML
    private void handleBackToLoginClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signIn.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) fullNameField.getScene().getWindow();

            stage.setTitle("ConstructionHub - Sign In");
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            errorMessageLabel.setText("فشل تحميل صفحة تسجيل الدخول. تأكد من مسار /view/signIn.fxml");
        }
    }

    // ---------------------------------------------
    // دالة تحميل لوحة التحكم (كما هي)
    // ---------------------------------------------
    private void loadDashboard(String role) {
        String fxmlPath;
        String title;

        switch (role) {
            case "chief":
                fxmlPath = "/view/chefFXML/dashboard.fxml";
                title = "Chief Dashboard";
                break;
            case "responsable":
                fxmlPath = "/view/responsableFXML/projects.fxml";
                title = "Responsable Dashboard";
                break;
            case "client":
                fxmlPath = "/view/clientFXML/projects.fxml";
                title = "Client Dashboard";
                break;
            default:
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