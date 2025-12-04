package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ClientRequestDetailsController {

    // حقن العناصر من FXML
    @FXML private Label requestTitleLabel;
    @FXML private Label clientNameLabel;
    @FXML private Label statusTag;
    @FXML private Label categoryValueLabel;
    @FXML private Label budgetValueLabel;
    @FXML private Label deadlineValueLabel;
    @FXML private Label locationValueLabel;
    @FXML private Label submissionDateLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label clientEmailLabel;
    @FXML private Label clientPhoneLabel;


    @FXML
    public void initialize() {
        // يمكن تركها فارغة أو استخدامها لتهيئات أولية
    }

    /**
     * دالة عامة لاستقبال ID الطلب وتحديث الواجهة بالبيانات.
     * يتم استدعاؤها من ClientRequestsController.
     */
    public void setClientRequestId(String requestId) {
        System.out.println("Displaying details for Client Request ID: " + requestId);

        // **هنا يجب أن يكون منطق جلب البيانات من قاعدة البيانات بناءً على requestId**

        // حالياً، نستخدم بيانات تجريبية (Hardcoded data)
        if ("REQ-001".equals(requestId)) {
            requestTitleLabel.setText("Luxury Villa Construction");
            clientNameLabel.setText("Client: Michael Anderson | ID: " + requestId);
            statusTag.setText("Pending");
            statusTag.getStyleClass().setAll("tag-pending");

            categoryValueLabel.setText("Residential Building");
            budgetValueLabel.setText("$2,500,000");
            deadlineValueLabel.setText("2026-06-15");
            locationValueLabel.setText("Beverly Hills, Los Angeles");
            submissionDateLabel.setText("2024-11-20");
            descriptionLabel.setText("The client is requesting the complete construction of a luxury, single-family villa. Requirements include high-end finishes, smart home integration, and a large outdoor entertainment area. The project must adhere to strict environmental standards. Client prefers materials from the 'Premium' category.");
            clientEmailLabel.setText("michael.anderson@example.com");
            clientPhoneLabel.setText("+1 (555) 123-4567");

        } else if ("REQ-002".equals(requestId)) {
            requestTitleLabel.setText("Tech Office Complex");
            clientNameLabel.setText("Client: Sarah Johnson | ID: " + requestId);
            statusTag.setText("High Priority");
            statusTag.getStyleClass().setAll("tag-high-priority");

            categoryValueLabel.setText("Commercial Building");
            budgetValueLabel.setText("$5,000,000");
            deadlineValueLabel.setText("2026-12-01");
            locationValueLabel.setText("Downtown San Francisco");
            submissionDateLabel.setText("2024-11-25");
            descriptionLabel.setText("Proposal for a new modern office complex focused on sustainable design and open-plan workspaces. High-priority due to investor schedule.");
            clientEmailLabel.setText("sarah.johnson@techcorp.com");
            clientPhoneLabel.setText("+1 (555) 987-6543");
        }
        // ... يمكنك إضافة حالات أخرى
    }

    // دالة لمعالجة إجراء الموافقة على الطلب
    @FXML
    private void handleApproveAction(ActionEvent event) {
        System.out.println("Client Request Approved. Redirecting to Project Creation...");
        // **TODO: هنا يتم تنفيذ منطق تحويل الطلب إلى مشروع جديد (قد يتطلب فتح نافذة Add Project)**

        // إغلاق النافذة المنبثقة
        closeWindow(event);
    }

    // دالة لمعالجة إجراء رفض الطلب
    @FXML
    private void handleRejectAction(ActionEvent event) {
        System.out.println("Client Request Rejected.");
        // **TODO: هنا يتم تنفيذ منطق تحديث حالة الطلب إلى 'Rejected'**

        // إغلاق النافذة المنبثقة
        closeWindow(event);
    }

    /**
     * دالة مساعدة لإغلاق النافذة الحالية.
     */
    private void closeWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}