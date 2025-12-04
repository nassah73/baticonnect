package controler.chefController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene; // 🚨 استيراد Scene
import javafx.stage.Modality; // 🚨 استيراد Modality
import java.io.IOException;

public class MaterialsController {

    @FXML
    public void initialize() {
        // يتم هنا تحميل وعرض بيانات المواد في الجدول
    }

    // =================================================================
    // دوال المساعدة لفتح المشاهد والنوافذ
    // =================================================================

    private void switchScene(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setTitle(title);
            stage.getScene().setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML: " + fxmlPath);
        }
    }

    /**
     * دالة موحدة لفتح نافذة منبثقة (Pop-up Window).
     * @param fxmlFileName اسم ملف FXML المراد عرضه (يجب أن يكون في مسار /view/chefFXML/).
     * @param title عنوان النافذة.
     */
    private void openNewPopUpWindow(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/chefFXML/" + fxmlFileName));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // لغرض النوافذ المنبثقة
            stage.setResizable(false);
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to open Pop-up window: " + fxmlFileName);
        }
    }

    // =================================================================
    // دوال التنقل الموحدة (Standard Navigation Functions)
    // =================================================================

    @FXML
    private void handleDashboardClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard");
    }

    @FXML
    private void handleResponsablesClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/responsables.fxml", "Responsables Management");
    }

    @FXML
    private void handleProjectsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/projects.fxml", "Projects Management");
    }

    @FXML
    private void handleReportsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/reports.fxml", "Reports & Analytics");
    }

    @FXML
    private void handleMaterialsClick(ActionEvent event) {
        // لا نحتاج لتبديل المشهد
    }

    @FXML
    private void handleClientRequestsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests");
    }

    // =================================================================
    // دالة خاصة بالصفحة
    // =================================================================

    /**
     * تفعيل زر "+ Add Material" لفتح نافذة منبثقة لإضافة مادة.
     */
    @FXML
    private void handleAddMaterialAction(ActionEvent event) {
        System.out.println("Add Material button clicked. Opening 'addMaterial.fxml' window.");
        // استدعاء الدالة الموحدة لفتح النافذة
        // 🚨 يجب إنشاء ملف FXML باسم addMaterial.fxml
        openNewPopUpWindow("addMaterial.fxml", "Add New Material to Inventory");

        // يمكننا إضافة منطق تحديث الجدول هنا بعد إغلاق النافذة
        // initialize();
    }
}