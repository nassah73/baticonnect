package controler.clientController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class ProjectsController {

    @FXML
    private Label welcomeLabel;

    /**
     * تُستدعى تلقائياً بعد تحميل ملف FXML
     */
    @FXML
    public void initialize() {
        // يمكنك هنا تعيين اسم العميل الفعلي الذي قام بالدخول
        // welcomeLabel.setText("Welcome back, [Actual Client Name]");
        System.out.println("Client Projects Dashboard Loaded.");
    }

    /**
     * معالجة النقر على زر "Add New Project"
     */
    @FXML
    private void handleAddProjectAction(ActionEvent event) {
        System.out.println("Add New Project button clicked by Client.");
        // TODO: تنفيذ منطق الانتقال إلى واجهة إضافة مشروع جديد
    }

    // TODO: أضف هنا دوال لمعالجة النقر على أزرار التنقل (Design Plans, Reports, etc.)
}