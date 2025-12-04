package controler.chefController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; // 🚨 استيراد Scene
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Modality; // 🚨 استيراد Modality
import java.io.IOException;

public class ResponsablesController {

    @FXML
    public void initialize() {
        // يتم هنا تحميل وعرض بيانات المسؤولين
    }

    // =================================================================
    // دوال مساعدة لفتح النوافذ المنبثقة (MODAL WINDOWS)
    // =================================================================

    // دالة مساعدة لفتح نافذة منبثقة جديدة
    private void openNewWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));

            // جعل النافذة منبثقة (Modal) لتركز انتباه المستخدم عليها
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait(); // تمنع التفاعل مع الواجهة الرئيسية حتى تُغلق

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML: " + fxmlPath);
        }
    }


    // =================================================================
    // دوال الإجراءات الخاصة بصفحة المسؤولين
    // =================================================================

    // 🚨 1. دالة إضافة مسؤول جديد (يتم استدعاؤها من زر "+ Add Responsable")
    @FXML
    private void handleAddResponsableAction(ActionEvent event) {
        // افترض أن ملف الإضافة هو addResponsable.fxml
        openNewWindow("/view/chefFXML/addResponsable.fxml", "Add New Responsable");
    }

    // 🚨 2. دالة عرض التفاصيل (يجب ربطها بكل زر "View Details")
    // بما أن هذا الزر يقع داخل VBox ديناميكي، قد تحتاج لاحقًا إلى تمرير معرف المسؤول (ID)
    // لكن حاليًا، سنفتح النافذة فقط.
    @FXML
    private void handleViewDetailsAction(ActionEvent event) {
        // افترض أن ملف التفاصيل هو responsableDetails.fxml
        openNewWindow("/view/chefFXML/responsableDetails.fxml", "Responsable Details");
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
    // ... (بقية دوال التنقل تبقى كما هي)
    @FXML
    private void handleDashboardClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard");
    }

    @FXML
    private void handleResponsablesClick(ActionEvent event) {
        // لا نحتاج لتبديل المشهد
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
        switchScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests");
    }
}