package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddProjectController {

    // حقن حقول الإدخال
    @FXML private TextField projectNameField;
    @FXML private ComboBox<String> managerComboBox;
    @FXML private ComboBox<String> categoryComboBox;
    @FXML private TextField locationField;
    @FXML private TextField budgetField;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker deadlinePicker;
    @FXML private TextArea descriptionArea;

    @FXML
    public void initialize() {
        // تهيئة قائمة المدراء (Manager ComboBox)
        ObservableList<String> managers = FXCollections.observableArrayList(
                "Choaib", "John Smith", "Maria Garcia", "Ahmed Hassan"
        );
        managerComboBox.setItems(managers);

        // تهيئة قائمة التصنيفات (Category ComboBox)
        ObservableList<String> categories = FXCollections.observableArrayList(
                "Residential", "Commercial", "Infrastructure", "Industrial", "Renovation"
        );
        categoryComboBox.setItems(categories);
    }

    /**
     * معالجة حدث حفظ المشروع.
     */
    @FXML
    private void handleSaveProject(ActionEvent event) {
        // 1. جمع البيانات المدخلة
        String projectName = projectNameField.getText();
        String manager = managerComboBox.getValue();
        String category = categoryComboBox.getValue();
        String location = locationField.getText();
        String budget = budgetField.getText();
        String startDate = startDatePicker.getValue() != null ? startDatePicker.getValue().toString() : "";
        String deadline = deadlinePicker.getValue() != null ? deadlinePicker.getValue().toString() : "";
        String description = descriptionArea.getText();

        // 2. التحقق البسيط من صحة البيانات (Validation)
        if (projectName.isEmpty() || manager == null || category == null || budget.isEmpty()) {
            System.err.println("Error: Please fill in all required fields (Name, Manager, Category, Budget).");
            // يجب إضافة منطق لعرض رسالة خطأ للمستخدم (مثل Alert)
            return;
        }

        // 3. طباعة البيانات للتحقق
        System.out.println("--- New Project Data ---");
        System.out.println("Name: " + projectName);
        System.out.println("Manager: " + manager);
        System.out.println("Category: " + category);
        System.out.println("Budget: " + budget);
        System.out.println("Start Date: " + startDate);
        System.out.println("Deadline: " + deadline);
        System.out.println("Location: " + location);
        System.out.println("Description: " + description);

        // 4. إغلاق النافذة
        closeWindow(event);
    }

    /**
     * معالجة حدث إلغاء العملية وإغلاق النافذة.
     */
    @FXML
    private void handleCancel(ActionEvent event) {
        System.out.println("Operation cancelled. Closing window.");
        closeWindow(event);
    }

    /**
     * دالة مساعدة لإغلاق النافذة الحالية.
     */
    private void closeWindow(ActionEvent event) {
        // الحصول على الـ Stage من الزر الذي ضغط
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}