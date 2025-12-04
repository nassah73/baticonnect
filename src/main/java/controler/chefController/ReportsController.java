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

// 🚨 يجب إنشاء هذا Controller لاحقاً
// import controler.chefController.ReportDetailsController;

public class ReportsController {

    @FXML
    public void initialize() {
        // يتم هنا تحميل التقارير وعرضها
    }

    // =================================================================
    // دوال المساعدة لفتح المشاهد والنوافذ
    // =================================================================

    /**
     * دالة موحدة لتغيير المشهد الرئيسي (لتنقل الـ Nav Bar)
     */
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
     * دالة موحدة لفتح نافذة منبثقة (Pop-up Window)
     * تقبل مسار FXML، عنوان النافذة، ومعرف التقرير (ID) إذا كان متاحاً.
     */
    private void openNewPopUpWindow(String fxmlFileName, String title, String reportId) {
        try {
            // نستخدم مسار chefFXML/ لأن الملفات ستكون هناك
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/chefFXML/" + fxmlFileName));
            Parent root = loader.load();

            // 🚨 منطق تمرير ID التقرير (يجب أن يكون لديك ReportDetailsController)
            // if (fxmlFileName.equals("reportDetails.fxml") && reportId != null) {
            //     ReportDetailsController controller = loader.getController();
            //     if (controller != null) {
            //         controller.setReportId(reportId);
            //     } else {
            //         System.err.println("Error: ReportDetailsController is null.");
            //     }
            // }

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
    // دوال التنقل (NAVIGATION HANDLERS) - تبقى كما هي
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
        // لا نحتاج لتبديل المشهد
    }

    @FXML
    private void handleMaterialsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/materials.fxml", "Materials Inventory");
    }

    @FXML
    private void handleClientRequestsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests");
    }

    // =================================================================
    // دالة خاصة بالصفحة (REPORT HANDLERS)
    // =================================================================

    /**
     * معالجة النقر على زر "View Report" لفتح تفاصيل التقرير.
     * يجب جلب ID التقرير من عنصر الـ HBox/Button الذي تم النقر عليه.
     */
    @FXML
    private void handleViewReportDetails(ActionEvent event) {
        System.out.println("View Report button clicked.");

        // 🚨 هنا يجب أن يكون منطق استخراج ID التقرير
        // بما أن ملف reports.fxml لا يملك UserData حالياً في الـ HBox (مثلاً)،
        // سنستخدم ID افتراضي مؤقتاً لتشغيل النافذة.
        String reportId = "REPORT-001"; // ID افتراضي (يجب تعديل FXML لاحقاً لإضافة UserData)

        System.out.println("Attempting to open details for Report ID: " + reportId);

        // استدعاء الدالة الموحدة لفتح النافذة
        openNewPopUpWindow("reportDetails.fxml", "Report Details", reportId);
    }
}