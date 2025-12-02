package controler.chefController;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ProjectsController {

    @FXML
    public void initialize() {
        System.out.println("Projects View Loaded.");
        // هنا يمكنك إضافة كود لتحميل بيانات المشاريع عند بدء تشغيل الواجهة
    }

    // ---------------------------------------------
    // دوال التنقل إلى جميع الواجهات الأخرى (تستخدم مسار chefFXML)
    // ---------------------------------------------

    // دالة مساعدة لتقليل تكرار الكود
    private void loadNewScene(ActionEvent event, String fxmlPath, String title) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            stage.setTitle(title);
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("فشل تحميل واجهة " + title + ". الخطأ: " + e.getMessage());
        }
    }

    // التنقل إلى الداشبورد (Dashboard)
    @FXML
    private void handleDashboardClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard");
    }

    // التنقل إلى المسؤولين (Responsables)
    @FXML
    private void handleResponsablesClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/responsables.fxml", "Project Responsables");
    }

    // التنقل إلى التقارير (Reports)
    @FXML
    private void handleReportsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/reports.fxml", "Project Reports");
    }

    // التنقل إلى المواد (Materials)
    @FXML
    private void handleMaterialsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/materials.fxml", "Materials Management");
    }

    // التنقل إلى طلبات العملاء (Client Requests)
    @FXML
    private void handleClientRequestsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests");
    }
}