package controler.chefController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class ClientRequestsController {

    // ---------------------------------------------
    // دالة مساعدة للتنقل (يجب أن تستخدم هذه الصيغة)
    // ---------------------------------------------
    private void loadNewScene(ActionEvent event, String fxmlPath, String title) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            stage.setTitle(title);
            // استخدام setRoot للتبديل بين الواجهات في نفس النافذة
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("فشل تحميل واجهة " + title + ". الخطأ: " + e.getMessage());
        }
    }

    @FXML
    public void initialize() {
        System.out.println("Client Requests View Loaded.");
        // هنا يمكن بدء تحميل البيانات من قاعدة البيانات
    }

    // ---------------------------------------------
    // دوال التنقل (Navigation Handlers)
    // ---------------------------------------------

    @FXML
    private void handleDashboardClick(ActionEvent event) {
        // "Home" يقود إلى صفحة المشاريع الرئيسية
        loadNewScene(event, "/view/chefFXML/projects.fxml", "Chief Dashboard");
    }

    @FXML
    private void handleProjectsClick(ActionEvent event) {
        // "Projects" يقود أيضاً إلى صفحة المشاريع الرئيسية
        loadNewScene(event, "/view/chefFXML/projects.fxml", "All Projects");
    }

    @FXML
    private void handleResponsablesClick(ActionEvent event) {
        // TODO: يجب إنشاء هذا الملف FXML
        loadNewScene(event, "/view/chefFXML/responsables.fxml", "Project Responsables");
    }

    @FXML
    private void handleReportsClick(ActionEvent event) {
        // TODO: يجب إنشاء هذا الملف FXML
        loadNewScene(event, "/view/chefFXML/reports.fxml", "Project Reports");
    }

    @FXML
    private void handleMaterialsClick(ActionEvent event) {
        // TODO: يجب إنشاء هذا الملف FXML
        loadNewScene(event, "/view/chefFXML/materials.fxml", "Materials Management");
    }

    // ---------------------------------------------
    // منطق الواجهة الحالية
    // ---------------------------------------------

    @FXML
    private void handleViewDetailsAction(ActionEvent event) {
        System.out.println("Chief clicked: View Request Details.");
        // TODO: تنفيذ منطق فتح نافذة جديدة لعرض تفاصيل الطلب المحدد
    }
}