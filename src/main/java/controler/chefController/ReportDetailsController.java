package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ReportDetailsController {

    // حقن العناصر من FXML
    @FXML private Label reportTitleLabel;
    @FXML private Label reportDateLabel;
    @FXML private Label statusTag;
    @FXML private Label submitterLabel;
    @FXML private Label projectLabel;
    @FXML private Label typeLabel;
    @FXML private TextArea contentArea;

    // متغير لتخزين ID التقرير
    private String currentReportId;

    @FXML
    public void initialize() {
        // تهيئة أولية
    }

    /**
     * دالة عامة لاستقبال ID التقرير وتحديث الواجهة بالبيانات
     * يتم استدعاؤها من ReportsController.
     */
    public void setReportId(String reportId) {
        this.currentReportId = reportId;
        System.out.println("Displaying details for Report ID: " + reportId);

        // --- هنا يجب أن يكون منطق جلب البيانات من قاعدة البيانات ---
        // (سنستخدم بيانات تجريبية مؤقتة)

        if ("REPORT-001".equals(reportId)) {
            updateUI(
                    "Weekly Progress - Week 45", "2025-11-08", "Reviewed", "tag-reviewed",
                    "John Smith", "Office Building Renovation (OFFICE-RENO-1)", "Weekly Progress",
                    "Work on 3rd floor structural frame completed. Materials delivery delayed by 2 days. Adjusted schedule to compensate."
            );
        } else if ("REPORT-002".equals(reportId)) {
            updateUI(
                    "Material Request Report", "2025-11-06", "Pending Review", "tag-pending",
                    "Maria Garcia", "Residential Complex (RES-COMPLEX-2)", "Material Request",
                    "Urgent request for 500 bags of Portland Cement Type I and 10 tons of rebar (Size 16mm). Delivery required by 2025-11-15."
            );
        } else {
            updateUI(
                    "Error: Report Not Found", "N/A", "N/A", "tag-pending",
                    "N/A", "N/A", "N/A",
                    "Could not load report details for the given ID: " + reportId
            );
        }
    }

    /**
     * دالة مساعدة موحدة لتحديث جميع حقول الواجهة
     */
    private void updateUI(String title, String date, String status, String statusClass, String submitter, String project, String type, String content) {
        reportTitleLabel.setText(title);
        reportDateLabel.setText("Submitted on: " + date);
        statusTag.setText(status);
        statusTag.getStyleClass().setAll(statusClass);

        submitterLabel.setText(submitter);
        projectLabel.setText(project);
        typeLabel.setText(type);
        contentArea.setText(content);
    }

    // ===============================================
    // دوال الإجراءات (Actions)
    // ===============================================

    @FXML
    private void handleApprove(ActionEvent event) {
        System.out.println("Report " + currentReportId + " Approved/Reviewed.");
        // منطق تحديث حالة التقرير في قاعدة البيانات
        handleClose(event);
    }

    @FXML
    private void handleReject(ActionEvent event) {
        System.out.println("Report " + currentReportId + " Rejected.");
        // منطق رفض التقرير (مع إرسال ملاحظات)
        handleClose(event);
    }

    @FXML
    private void handleClose(ActionEvent event) {
        // لإغلاق النافذة المنبثقة الحالية
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
}