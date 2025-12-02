package controler.chefController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;

public class ClientRequestsController {

    // يمكنك تعريف TableView هنا إذا كنت ستستخدم جدولاً لعرض الطلبات
    // @FXML
    // private TableView<ClientRequest> requestsTable;

    @FXML
    public void initialize() {
        System.out.println("Client Requests View Loaded.");
        // يمكن إضافة دالة loadClientRequestsData() هنا لاحقاً
    }

    // ---------------------------------------------
    // دوال التنقل (Navigation Handlers)
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

    @FXML
    private void handleDashboardClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard");
    }

    @FXML
    private void handleResponsablesClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/responsables.fxml", "Project Responsables");
    }

    @FXML
    private void handleProjectsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/projects.fxml", "All Projects");
    }

    @FXML
    private void handleReportsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/reports.fxml", "Project Reports");
    }

    @FXML
    private void handleMaterialsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/materials.fxml", "Materials Management");
    }

    // ---------------------------------------------
    // كلاس نموذجي (يمكنك استخدامه لملء الجدول لاحقاً)
    // ---------------------------------------------

    /*
    public static class ClientRequest {
        // public String get...() { ... }
    }
    */
}