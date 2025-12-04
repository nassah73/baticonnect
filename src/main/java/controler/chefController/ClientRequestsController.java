package controler.chefController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Modality; // **تمت الإضافة**
import javafx.scene.Scene; // **تمت الإضافة**
import javafx.scene.Node; // **تمت الإضافة**
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
    // دالة خاصة بالصفحة (إجراء فتح التفاصيل)
    // =================================================================
    @FXML
    private void handleViewDetailsAction(ActionEvent event) {
        // جلب معرّف الطلب (Request ID) من خاصية userData الموجودة على الزر
        Node source = (Node) event.getSource();
        String clientRequestId = null;

        if (source.getUserData() != null) {
            clientRequestId = source.getUserData().toString();
        } else {
            // في حال لم يتم تعيين userData (للتجربة)
            clientRequestId = "REQ-DEFAULT";
        }

        System.out.println("View Details clicked for Request ID: " + clientRequestId);

        openClientDetailsWindow(clientRequestId);
    }

    /**
     * دالة مساعدة لفتح النافذة المنبثقة لتفاصيل طلب العميل.
     */
    private void openClientDetailsWindow(String clientRequestId) {
        try {
            // المسار المتوقع لملف التفاصيل FXML الجديد
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/chefFXML/clientRequestDetails.fxml"));
            Parent root = loader.load();

            // الحصول على المتحكم وتمرير ID الطلب
            ClientRequestDetailsController controller = loader.getController();
            controller.setClientRequestId(clientRequestId);

            Stage stage = new Stage();
            stage.setTitle("Client Request Details: " + clientRequestId);
            stage.setScene(new Scene(root));

            // جعل النافذة منبثقة (Modal)
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load Client Request Details FXML. Make sure the file exists at /view/chefFXML/clientRequestDetails.fxml");
        }
    }
}