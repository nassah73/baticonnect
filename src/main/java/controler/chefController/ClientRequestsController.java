package controler.chefController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class ClientRequestsController {

    @FXML
    public void initialize() {
        // يتم هنا تحميل وعرض بيانات طلبات العملاء
    }

    // =================================================================
    // دوال التنقل الموحدة (Standard Navigation Functions)
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
        switchScene(event, "/view/chefFXML/materials.fxml", "Materials Inventory");
    }

    @FXML
    private void handleClientRequestsClick(ActionEvent event) {
        // لا نحتاج لتبديل المشهد
    }

    // =================================================================
    // دالة خاصة بالصفحة
    // =================================================================
    @FXML
    private void handleViewDetailsAction(ActionEvent event) {
        System.out.println("View Details clicked on a client request.");
        // TODO: تنفيذ منطق عرض تفاصيل الطلب
    }
}