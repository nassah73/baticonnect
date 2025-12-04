package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddMaterialController {

    // حقن حقول الإدخال
    @FXML private TextField nameField;
    @FXML private ComboBox<String> unitComboBox;
    @FXML private TextField quantityField;
    @FXML private ComboBox<String> supplierComboBox;
    @FXML private TextField priceField;
    @FXML private TextField minStockField;

    @FXML
    public void initialize() {
        // تهيئة قائمة وحدات القياس (Unit ComboBox)
        ObservableList<String> units = FXCollections.observableArrayList(
                "Bags", "Tons", "m³", "Units", "Boxes", "Liters"
        );
        unitComboBox.setItems(units);

        // تهيئة قائمة الموردين (Supplier ComboBox)
        ObservableList<String> suppliers = FXCollections.observableArrayList(
                "Al-Faisal Trading", "Mega Steel Inc.", "Concrete Suppliers Co.", "Local Market"
        );
        supplierComboBox.setItems(suppliers);
    }

    /**
     * معالجة حدث حفظ المادة الجديدة.
     */
    @FXML
    private void handleSaveMaterial(ActionEvent event) {
        // 1. جلب البيانات
        String materialName = nameField.getText();
        String unit = unitComboBox.getValue();
        String quantity = quantityField.getText();
        String supplier = supplierComboBox.getValue();
        String price = priceField.getText();
        String minStock = minStockField.getText();

        // 2. التحقق البسيط من صحة البيانات (Validation)
        if (materialName.isEmpty() || unit == null || quantity.isEmpty() || price.isEmpty()) {
            System.err.println("Error: Please fill in all required fields.");
            // يجب إضافة منطق لعرض رسالة خطأ للمستخدم (مثل Alert)
            return;
        }

        // 3. طباعة البيانات للتحقق (هنا يجب أن يكون منطق الحفظ في قاعدة البيانات)
        System.out.println("--- New Material Data ---\n" +
                "Name: " + materialName + "\n" +
                "Unit: " + unit + "\n" +
                "Quantity: " + quantity + "\n" +
                "Supplier: " + supplier + "\n" +
                "Price: " + price + "\n" +
                "Min Stock: " + minStock);

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
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}