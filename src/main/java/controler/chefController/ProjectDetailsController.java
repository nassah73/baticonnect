package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
// لإضافة محتوى ديناميكي لاحقاً (Optional)


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

    // لإظهار الـ ID الذي تم إرساله (اختياري، للتحقق)
    @FXML private Label projectIdDisplayLabel;


    /**
     * دالة عامة لاستقبال ID المشروع وتحديث الواجهة بالبيانات.
     * يتم استدعاؤها من ProjectsController بعد تحميل FXML.
     */
    public void setProjectId(String projectId) {
        System.out.println("Displaying details for Project ID: " + projectId);

        // تحديث حقل الـ ID للتحقق (إذا أضفته في FXML)
        if (projectIdDisplayLabel != null) {
            projectIdDisplayLabel.setText("Project ID: " + projectId);
        }

        // --- هنا يجب أن يكون منطق جلب البيانات من قاعدة البيانات باستخدام 'projectId' ---
        // (نستخدم بيانات تجريبية (Hardcoded) حالياً)

        if ("OFFICE-RENO-1".equals(projectId)) {
            // بيانات المشروع الأول
            updateUI(
                    "Office Building Renovation",
                    "Choaib",
                    "In Progress",
                    0.75, // 75%
                    "2024-09-01",
                    "2025-05-30",
                    "Rabat, Morocco",
                    "Commercial",
                    "$2,500,000",
                    "$1,600,000",
                    "$900,000",
                    "tag-inprogress", // CSS Class
                    "#007bff"         // Progress Bar Color
            );
        } else if ("RESIDENTIAL-COMPLEX-2".equals(projectId)) {
            // بيانات المشروع الثاني
            updateUI(
                    "Residential Complex Development",
                    "Maria Garcia",
                    "Planning",
                    0.25, // 25%
                    "2025-01-15",
                    "2027-03-30",
                    "Casablanca, Morocco",
                    "Residential",
                    "$8,000,000",
                    "$200,000",
                    "$7,800,000",
                    "tag-planning", // CSS Class
                    "#ffc107"       // Progress Bar Color
            );
        } else {
            // بيانات المشروع الافتراضي (إذا كان الـ ID غير معروف أو كان "PROJECT-001")
            updateUI(
                    "Default Project Name",
                    "N/A",
                    "Unknown Status",
                    0.0,
                    "N/A",
                    "N/A",
                    "N/A",
                    "N/A",
                    "$0",
                    "$0",
                    "$0",
                    "tag-planning",
                    "#6c757d"
            );
        }
    }

    /**
     * دالة مساعدة لتحديث جميع حقول الواجهة بالبيانات المستلمة.
     */
    private void updateUI(String name, String manager, String status, double progress, String start, String deadline, String location, String category, String totalBudget, String spent, String remaining, String statusClass, String progressColor) {
        projectNameLabel.setText(name);
        managerLabel.setText("Managed by: " + manager);

        // تحديث حالة المشروع وتطبيق ستايل CSS
        statusTag.setText(status);
        statusTag.getStyleClass().setAll(statusClass);

        // تحديث شريط التقدم
        overallProgressBar.setProgress(progress);
        progressPercentLabel.setText((int)(progress * 100) + "%");
        progressPercentLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: " + progressColor + ";");
        overallProgressBar.setStyle("-fx-accent: " + progressColor + ";");

        // تحديث تفاصيل المشروع
        startDateLabel.setText(start);
        deadlineLabel.setText(deadline);
        locationLabel.setText(location);
        categoryLabel.setText(category);
        totalBudgetLabel.setText(totalBudget);
        spentToDateLabel.setText(spent);
        remainingBudgetLabel.setText(remaining);

        // يمكن إضافة منطق خاص لتلوين الميزانية المتبقية
        if (remaining.startsWith("-$")) {
            remainingBudgetLabel.setStyle("-fx-text-fill: #dc3545;"); // أحمر إذا كانت القيمة سالبة
        } else if (!remaining.equals("$0")) {
            remainingBudgetLabel.setStyle("-fx-text-fill: #28a745;"); // أخضر
        }
    }

    // دوال الإجراءات (مثال)
    @FXML
    private void handleEditInfo() {
        System.out.println("Edit Project Info clicked.");
        // يمكنك فتح نافذة AddProjectController هنا مع تحميل بيانات المشروع الحالي
    }

    @FXML
    private void handleDeleteProject() {
        System.out.println("Delete Project clicked.");
        // منطق حذف المشروع
    }
}