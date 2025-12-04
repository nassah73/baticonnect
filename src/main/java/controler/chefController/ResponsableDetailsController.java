package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Button; // لاستخدام زر الإغلاق إذا لزم الأمر

public class ResponsableDetailsController {

    // حقن العناصر من FXML
    @FXML
    private Label responsableNameLabel;
    @FXML
    private Label emailValueLabel;
    @FXML
    private Label jobTitleValueLabel;
    @FXML
    private Label dateHiredValueLabel;
    @FXML
    private Label activeProjectsLabel;
    @FXML
    private Label tasksCompletedLabel;
    @FXML
    private Label performanceLabel;
    @FXML
    private ProgressBar performanceBar;

    // دالة لاستقبال بيانات المسؤول المحدد (ID) عند فتح النافذة
    public void setResponsableData(String responsableId) {
        // في التطبيق الحقيقي:
        // 1. استخدام الـ ID لجلب بيانات المسؤول من قاعدة البيانات.
        // 2. تحديث الحقول باستخدام البيانات المسترجعة.

        // حالياً، سنستخدم بيانات تجريبية (Hardcoded data)
        if (responsableId.equals("JS123")) {
            responsableNameLabel.setText("John Smith - ID: " + responsableId);
            emailValueLabel.setText("john.smith@company.com");
            jobTitleValueLabel.setText("Senior Site Supervisor");
            dateHiredValueLabel.setText("2022-05-10");
            activeProjectsLabel.setText("2");
            tasksCompletedLabel.setText("45");
            performanceBar.setProgress(0.92);
            performanceLabel.setText("92%");
            performanceLabel.setStyle("-fx-text-fill: #28a745; -fx-font-weight: bold;");
        }
        // يمكنك إضافة حالات أخرى لبقية المسؤولين
    }

    @FXML
    public void initialize() {
        // يمكن تركها فارغة، أو استخدامها لتهيئات أولية
        // ملاحظة: يُفضل استخدام setResponsableData لملء البيانات
    }

    // يمكن إضافة دوال لـ Edit Info و Delete Responsable هنا لاحقاً

    // مثال لدالة يتم استدعاؤها لـ Edit Info
    @FXML
    private void handleEditInfoAction() {
        System.out.println("Editing info...");
        // منطق فتح نافذة تعديل أو تمكين الحقول
    }
}