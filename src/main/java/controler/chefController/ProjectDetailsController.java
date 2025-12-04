package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ProjectDetailsController {

    // حقن جميع العناصر ذات الصلة من FXML
    @FXML private Label projectNameLabel;
    @FXML private Label managerLabel;
    @FXML private Label statusTag;
    @FXML private ProgressBar overallProgressBar;
    @FXML private Label progressPercentLabel;
    @FXML private Label startDateLabel;
    @FXML private Label deadlineLabel;
    @FXML private Label locationLabel;
    @FXML private Label categoryLabel;
    @FXML private Label totalBudgetLabel;
    @FXML private Label spentToDateLabel;
    @FXML private Label remainingBudgetLabel;

    // دالة initialize يتم استدعاؤها بعد تحميل FXML
    @FXML
    public void initialize() {
        // يمكن تركها فارغة أو استخدامها لتهيئات أولية
    }

    /**
     * دالة عامة لاستقبال ID المشروع وتحديث الواجهة بالبيانات
     * يتم استدعاؤها من ProjectsController.
     */
    public void setProjectId(String projectId) {
        System.out.println("Displaying details for Project ID: " + projectId);

        // --- هنا يجب أن يكون منطق جلب البيانات من قاعدة البيانات ---
        // (سنستخدم بيانات تجريبية مؤقتة)

        if ("OFFICE-RENO-1".equals(projectId)) {
            // بيانات مشروع المكتب
            updateUI(
                    "Office Building Renovation", "John Smith", "In Progress", 0.65,
                    "2025-01-10", "2026-06-15", "Casablanca", "Commercial",
                    "$2,500,000", "$1,600,000", "$900,000",
                    "tag-inprogress", "#007bff" // أزرق
            );
        } else if ("RES-COMPLEX-2".equals(projectId)) {
            // بيانات مشروع المجمع السكني
            updateUI(
                    "Residential Complex", "Maria Garcia", "Planning", 0.25,
                    "2026-01-01", "2027-03-30", "Rabat", "Multi-Family Residential",
                    "$8,000,000", "$2,000,000", "$6,000,000",
                    "tag-planning", "#ffc107" // أصفر
            );
        } else {
            // في حال فشل استخراج الـ ID أو لـ ID افتراضي
            updateUI(
                    "Project Not Found", "N/A", "Error", 0.0,
                    "N/A", "N/A", "N/A", "N/A",
                    "N/A", "N/A", "N/A",
                    "tag-planning", "#6c757d" // رمادي
            );
        }
    }

    /**
     * دالة مساعدة موحدة لتحديث جميع حقول الواجهة
     */
    private void updateUI(String name, String manager, String status, double progress, String start, String deadline, String location, String category, String totalBudget, String spent, String remaining, String statusClass, String progressColor) {
        projectNameLabel.setText(name);
        managerLabel.setText("Managed by: " + manager);

        // تحديث حالة المشروع
        statusTag.setText(status);
        statusTag.getStyleClass().setAll(statusClass);

        // تحديث شريط التقدم
        overallProgressBar.setProgress(progress);
        progressPercentLabel.setText((int)(progress * 100) + "%");
        progressPercentLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: " + progressColor + ";");
        overallProgressBar.setStyle("-fx-accent: " + progressColor + ";"); // تحديث لون شريط التقدم

        // تحديث تفاصيل المشروع
        startDateLabel.setText(start);
        deadlineLabel.setText(deadline);
        locationLabel.setText(location);
        categoryLabel.setText(category);

        // تحديث الميزانية
        totalBudgetLabel.setText(totalBudget);
        spentToDateLabel.setText(spent);
        remainingBudgetLabel.setText(remaining);

        // يمكنك إضافة منطق لتحديث لون الميزانية المتبقية هنا
        if (remaining.startsWith("$")) {
            remainingBudgetLabel.setStyle("-fx-text-fill: #28a745;"); // أخضر
        }
    }

    // ===============================================
    // دوال الإجراءات (Actions)
    // ===============================================

    @FXML
    private void handleEditInfo(ActionEvent event) {
        System.out.println("Edit Project Info clicked.");
        // هنا يمكن فتح نافذة منبثقة لتعديل المشروع
    }

    @FXML
    private void handleDeleteProject(ActionEvent event) {
        System.out.println("Delete Project clicked.");
        // هنا يمكن إضافة منطق تأكيد وحذف المشروع
    }

    @FXML
    private void handleClose(ActionEvent event) {
        // لإغلاق النافذة المنبثقة الحالية
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
}