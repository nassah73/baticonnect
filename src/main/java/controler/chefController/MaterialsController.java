package controler.chefController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;

public class MaterialsController {

    // 1. تعريف الجدول الذي تم ربطه في materials.fxml
    @FXML
    private TableView<Material> materialsTable;

    @FXML
    public void initialize() {
        System.out.println("Materials View Loaded.");
        // تحميل البيانات النموذجية في الجدول عند بدء تشغيل الواجهة
        loadMaterialsData();
    }

    // ---------------------------------------------
    // دوال تحميل البيانات
    // ---------------------------------------------

    private void loadMaterialsData() {
        // إنشاء قائمة بيانات وهمية (Sample Data)
        ObservableList<Material> data = FXCollections.observableArrayList(
                new Material("Cement Bags", "150 bags", "BuildMart", "2025-11-01", "In Stock"),
                new Material("Steel Rods", "2000 units", "MetalCorp", "2025-10-28", "In Stock"),
                new Material("Bricks", "5000 units", "Brick Factory", "2025-10-25", "In Stock"),
                new Material("Electrical Wire", "500 meters", "ElectroSupply", "2025-11-03", "In Stock"),
                new Material("Plumbing Pipes", "300 meters", "PipePro", "2025-10-30", "Low Stock")
        );
        materialsTable.setItems(data);
    }

    // ---------------------------------------------
    // دوال التنقل إلى جميع الواجهات الأخرى
    // ---------------------------------------------

    // دالة مساعدة لتقليل تكرار الكود
    private void loadNewScene(ActionEvent event, String fxmlPath, String title) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            stage.setTitle(title);
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("فشل تحميل واجهة " + title + ". الخطأ: " + e.getMessage());
        }
    }

    // التنقل إلى الداشبورد (Dashboard)
    @FXML
    private void handleDashboardClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard");
    }

    // التنقل إلى المسؤولين (Responsables)
    @FXML
    private void handleResponsablesClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/responsables.fxml", "Project Responsables");
    }

    // التنقل إلى المشاريع (Projects) - (تذكر إضافة هذه الدالة للمتحكمات الأخرى لاحقاً!)
    @FXML
    private void handleProjectsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/projects.fxml", "All Projects");
    }

    // التنقل إلى التقارير (Reports)
    @FXML
    private void handleReportsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/reports.fxml", "Project Reports");
    }

    // التنقل إلى طلبات العملاء (Client Requests)
    @FXML
    private void handleClientRequestsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests");
    }

    // ---------------------------------------------
    // 2. كلاس نموذج المادة (Model Class)
    // ---------------------------------------------

    // هذا الكلاس ضروري لربط البيانات بالـ TableView في ملف FXML
    public static class Material {
        private final String materialName;
        private final String quantity;
        private final String supplier;
        private final String lastOrderDate;
        private final String status;

        public Material(String materialName, String quantity, String supplier, String lastOrderDate, String status) {
            this.materialName = materialName;
            this.quantity = quantity;
            this.supplier = supplier;
            this.lastOrderDate = lastOrderDate;
            this.status = status;
        }

        // Getters - يجب أن تتطابق أسماؤها مع property في FXML: materialName, quantity, supplier, lastOrderDate, status
        public String getMaterialName() { return materialName; }
        public String getQuantity() { return quantity; }
        public String getSupplier() { return supplier; }
        public String getLastOrderDate() { return lastOrderDate; }
        public String getStatus() { return status; }
    }
}