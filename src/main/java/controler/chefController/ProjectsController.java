package controler.chefController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.Event; // يمكن استخدامه بدلاً من ActionEvent إذا لزم الأمر
import javafx.scene.input.MouseEvent;
import java.io.IOException;

// 🚨 يجب استيراد Controller الخاص بالتفاصيل لتمرير البيانات
import controler.chefController.ProjectDetailsController;


public class ProjectsController {

    @FXML
    private VBox projectsListContainer;

    // ===============================================
    // دوال المساعدة لفتح المشاهد والنوافذ
    // ===============================================

    /**
     * دالة موحدة لتغيير المشهد الرئيسي (لتنقل الـ Nav Bar)
     * تبقى private لأنها دالة مساعدة وليست FXML handler مباشرة.
     */
    private void switchScene(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.getScene().setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML for Navigation: " + fxmlPath);
        }
    }

    /**
     * دالة موحدة لفتح نافذة منبثقة (Pop-up Window)
     * تقبل مسار FXML، عنوان النافذة، ومعرف المشروع (ID) إذا كان متاحاً.
     */
    private void openNewPopUpWindow(String fxmlFileName, String title, String projectId) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/chefFXML/" + fxmlFileName));
            Parent root = loader.load();

            // 🚨 منطق تمرير ID المشروع
            if (fxmlFileName.equals("projectDetails.fxml") && projectId != null) {
                ProjectDetailsController controller = loader.getController();
                if (controller != null) {
                    // افتراض أن ProjectDetailsController يحتوي على دالة setProjectId(String)
                    controller.setProjectId(projectId);
                } else {
                    System.err.println("Error: ProjectDetailsController is null.");
                }
            }

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait(); // showAndWait أفضل للنوافذ المنبثقة

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to open Pop-up window: " + fxmlFileName);
        }
    }


    // ===============================================
    // دوال التنقل (NAVIGATION HANDLERS) - يجب أن تكون public
    // ===============================================

    @FXML public void handleDashboardClick(ActionEvent event) { switchScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard"); }
    @FXML public void handleResponsablesClick(ActionEvent event) { switchScene(event, "/view/chefFXML/responsables.fxml", "Responsables Management"); }
    @FXML public void handleProjectsClick(ActionEvent event) { /* البقاء في الصفحة: لا شيء */ }
    @FXML public void handleReportsClick(ActionEvent event) { switchScene(event, "/view/chefFXML/reports.fxml", "Reports & Analytics"); }
    @FXML public void handleMaterialsClick(ActionEvent event) { switchScene(event, "/view/chefFXML/materials.fxml", "Materials Inventory"); }
    @FXML public void handleClientRequestsClick(ActionEvent event) { switchScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests"); }


    // ===============================================
    // دوال المشاريع (PROJECT HANDLERS)
    // ===============================================

    /**
     * فتح نافذة إضافة مشروع جديد.
     * يجب أن تكون public وتستقبل ActionEvent.
     */
    @FXML
    public void handleAddProjectAction(ActionEvent event) { // ✅ الصيغة الصحيحة
        // استدعاء الدالة الموحدة لفتح النافذة
        openNewPopUpWindow("addProject.fxml", "Add New Project", null);
    }

    /**
     * معالجة النقر على زر "View Details" لفتح تفاصيل المشروع.
     * يجب أن تكون public وتستقبل ActionEvent لاستخراج ID المشروع.
     */
    @FXML
    public void handleViewProjectDetails(ActionEvent event) { // ✅ الصيغة الصحيحة

        Node source = (Node) event.getSource();
        String projectId = null; // سيتم تعيينه من بيانات العقدة

        // المنطق: الصعود في شجرة العقد (Node Tree) للبحث عن الـ VBox الرئيسي
        // الذي يحتوي على بيانات المشروع.
        Node projectNode = source;
        // صعود الشجرة حتى نجد VBox المشروع الرئيسي (نفترض أنه يحمل styleClass معينة)
        while (projectNode != null &&
                !(projectNode instanceof VBox && projectNode.getStyleClass().contains("card-project-details"))) {

            // تحقق احتياطي في حال عدم وجود styleClass
            if (projectNode.getUserData() != null) {
                // افترض أن الـ ID مخزن في userData لأقرب حاوية مناسبة
                projectId = projectNode.getUserData().toString();
                break;
            }
            projectNode = projectNode.getParent();
        }

        // إذا تم إيجاد الـ VBox الرئيسي، جلب الـ ID منه
        if (projectNode != null && projectNode.getUserData() != null) {
            projectId = projectNode.getUserData().toString();
        }


        if (projectId == null || projectId.isEmpty()) {
            // استخدام ID تجريبي في حال فشل الاستخراج (يجب تصحيح FXML لاستخدام UserData)
            System.err.println("Warning: Could not retrieve projectId. Using default ID: OFFICE-RENO-1");
            projectId = "OFFICE-RENO-1";
        }

        System.out.println("Attempting to open details for Project ID: " + projectId);

        // استدعاء الدالة الموحدة لفتح النافذة
        openNewPopUpWindow("projectDetails.fxml", "Project Details", projectId);
    }

}