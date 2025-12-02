package controler.chefController;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ReportsController {

    @FXML
    public void initialize() {
        System.out.println("Reports View Loaded.");
        // هنا يمكنك إضافة كود لتحميل بيانات التقارير عند بدء تشغيل الواجهة
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
            System.err.println("فشل تحميل واجهة " + title + ": تأكد من وجود الملف في " + fxmlPath + ". الخطأ: " + e.getMessage());
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

    // ✅ تم إضافة الدالة المفقودة للتنقل إلى المشاريع
    @FXML
    private void handleProjectsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/projects.fxml", "All Projects");
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