package controler.chefController;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ResponsablesController {

    @FXML
    public void initialize() {
        // هنا يمكن إضافة كود لتهيئة بيانات المسؤولين
        System.out.println("Responsables View Loaded.");
    }

    /**
     * دالة الرجوع من صفحة المسؤولين إلى الداشبورد
     */
    @FXML
    private void handleDashboardClick(ActionEvent event) throws IOException {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            // *** تم تصحيح المسار من /view/chef/ إلى /view/chefFXML/ ***
            // ليتطابق مع هيكل مجلداتك الفعلي (resources/view/chefFXML/dashboard.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/chefFXML/dashboard.fxml"));
            Parent root = loader.load();

            stage.setTitle("Chief Dashboard");
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            // تحديث رسالة الخطأ لتطابق المسار الجديد:
            System.err.println("فشل تحميل واجهة الداشبورد: تأكد من وجود الملف في /view/chefFXML/dashboard.fxml واسم المتحكم: " + e.getMessage());
        }
    }
}