package controler.chef;

import javafx.fxml.FXML;
import javafx.stage.Stage;
public class ResponsablesControler {
    @FXML
    private void handleDashboardClick(javafx.event.ActionEvent event) throws Exception {
        try {
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            // تحميل واجهة الداشبورد
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
            javafx.scene.Parent root = loader.load();

            stage.setTitle("Chief Dashboard");
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("فشل تحميل واجهة الداشبورد: " + e.getMessage());
        } }

    @FXML
    public void initialize() {
        // يمكن هنا تحميل بيانات المسؤولين من قاعدة البيانات
    }

    // نحتاج لدالة لكي نعود للوحة القيادة
    @FXML
    private void handleDashboardClick() {
        // يمكنك هنا وضع كود للرجوع للصفحة الرئيسية
        System.out.println("الرجوع إلى لوحة القيادة.");
    }
}
