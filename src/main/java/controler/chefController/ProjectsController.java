package controler.chefController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ProjectsController {

    @FXML
    private VBox projectsListContainer;

    // ===============================================
    // دوال المساعدة لفتح المشاهد والنوافذ
    // ===============================================

    /**
     * دالة موحدة لتغيير المشهد الرئيسي (لتنقل الـ Nav Bar)
     */
    private void switchScene(ActionEvent event, String fxmlPath, String title) {
        try {
            // ملاحظة: المسار يجب أن يبدأ بـ /
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.getScene().setRoot(root);

        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
            System.err.println("Failed to load FXML for Navigation: " + fxmlPath);
        }
    }

    /**
     * دالة موحدة لفتح نافذة منبثقة (Pop-up Window)
     */
    private void openNewPopUpWindow(String fxmlFileName, String title, String projectId) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/chefFXML/" + fxmlFileName));
            Parent root = loader.load();

            // 🚨 منطق تمرير ID المشروع (ProjectDetailsController يجب أن تكون معرفة)
            if (fxmlFileName.equals("projectDetails.fxml") && projectId != null) {
                ProjectDetailsController controller = loader.getController();
                controller.setProjectId(projectId);
            }

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
            System.err.println("Failed to open Pop-up window: " + fxmlFileName);
        }
    }


    // ===============================================
    // دوال التنقل (NAVIGATION HANDLERS)
    // ===============================================

    @FXML public void handleDashboardClick(ActionEvent event) { switchScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard"); }
    @FXML public void handleResponsablesClick(ActionEvent event) { switchScene(event, "/view/chefFXML/responsables.fxml", "Responsables Management"); }
    @FXML public void handleProjectsClick() { /* البقاء في الصفحة */ }
    @FXML public void handleReportsClick(ActionEvent event) { switchScene(event, "/view/chefFXML/reports.fxml", "Reports & Analytics"); }
    @FXML public void handleMaterialsClick(ActionEvent event) { switchScene(event, "/view/chefFXML/materials.fxml", "Materials Inventory"); }
    @FXML public void handleClientRequestsClick(ActionEvent event) { switchScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests"); }


    // ===============================================
    // دوال المشاريع (PROJECT HANDLERS) 🚨 (تم تغييرها إلى public)
    // ===============================================

    /**
     * معالجة النقر على كارت المشروع أو زر View Details لفتح التفاصيل.
     * يجب أن تكون public ليتم تحميلها من FXML.
     */
    @FXML
    public void handleViewProjectDetails(Object event) {
        Node source;
        if (event instanceof MouseEvent) {
            source = (Node) ((MouseEvent) event).getSource();
        } else if (event instanceof ActionEvent) {
            source = (Node) ((ActionEvent) event).getSource();
        } else {
            return;
        }

        String projectId = "PROJECT-001";

        // منطق استخراج الـ ID من الـ VBox الرئيسي باستخدام userData
        Node projectNode = source;
        while (!(projectNode instanceof VBox && projectNode.getStyleClass().contains("card-project-details")) && projectNode != null) {
            projectNode = projectNode.getParent();
        }

        if (projectNode != null && projectNode.getUserData() != null) {
            projectId = projectNode.getUserData().toString();
        }

        openNewPopUpWindow("projectDetails.fxml", "Project Details", projectId);
    }

    /**
     * فتح نافذة إضافة مشروع جديد.
     * يجب أن تكون public ليتم تحميلها من FXML.
     */
    @FXML
    public void handleAddProjectAction() {
        openNewPopUpWindow("addProject.fxml", "Add New Project", null);
    }

    public void handleViewProjectDetails() {
    }

    public VBox getProjectsListContainer() {
        return projectsListContainer;
    }

    public void setProjectsListContainer(VBox projectsListContainer) {
        this.projectsListContainer = projectsListContainer;
    }
}