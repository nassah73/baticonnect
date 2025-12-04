package controler.responsableController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class ProjectsController {

    @FXML
    private Label welcomeLabel;

    /**
     * تُستدعى تلقائياً بعد تحميل ملف FXML
     */
    @FXML
    public void initialize() {
        System.out.println("Responsable Projects Dashboard Loaded.");
        // يمكن هنا تحميل بيانات المشاريع الفعلية للـ Responsable
    }

    /**
     * معالجة النقر على زر "+ Update Progress" في الأعلى
     */
    @FXML
    private void handleUpdateProgressAction(ActionEvent event) {
        System.out.println("Responsable clicked: Global Update Progress.");
        // TODO: تنفيذ منطق بدء تحديث التقدم لعدة مشاريع
    }

    /**
     * معالجة النقر على منطقة "Join a Project"
     */
    @FXML
    private void handleJoinProjectAction(MouseEvent event) {
        System.out.println("Responsable clicked: Join a New Project.");
        // TODO: تنفيذ منطق الانتقال إلى صفحة الانضمام لمشروع
    }

    /**
     * معالجة النقر على زر "View Details" لأي مشروع
     */
    @FXML
    private void handleViewDetailsAction(ActionEvent event) {
        System.out.println("Responsable clicked: View Project Details.");
        // TODO: تنفيذ منطق عرض تفاصيل مشروع محدد
    }

    /**
     * معالجة النقر على زر "Update" لتحديث مشروع محدد
     */
    @FXML
    private void handleUpdateAction(ActionEvent event) {
        System.out.println("Responsable clicked: Update Specific Project.");
        // TODO: تنفيذ منطق الانتقال إلى صفحة تحديث تقدم مشروع
    }
}