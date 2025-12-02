package controler.chefController;

import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import java.io.IOException;

public class DashboardController {

    // تعريف الرسوم البيانية والإحصائيات كما هي
    @FXML private BarChart<String, Number> componentInventoryChart;
    @FXML private PieChart expenseBreakdownChart;
    @FXML private LineChart<String, Number> monthlyExpensesTrendChart;
    @FXML private Label activeProjectsCount;
    @FXML private Label responsablesCount;
    @FXML private Label materialsTypes;
    @FXML private Label monthlyExpensesTotal;
    @FXML private ProgressIndicator cementProgress;
    @FXML private ProgressIndicator steelRodsProgress;
    @FXML private ProgressIndicator bricksProgress;


    @FXML
    public void initialize() {
        // تهيئة الرسوم البيانية والإحصائيات
        loadInventoryData();
        loadExpenseBreakdownData();
        loadMonthlyTrendData();
        loadStatsCards();
    }

    // دوال تحميل البيانات (لا تحتاج لتعديل)
    private void loadInventoryData() {
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Current Stock");
        series1.getData().add(new XYChart.Data<>("Cement", 80));
        series1.getData().add(new XYChart.Data<>("Steel Rods", 60));
        series1.getData().add(new XYChart.Data<>("Bricks", 70));
        series1.getData().add(new XYChart.Data<>("Electrical Wire", 45));
        series1.getData().add(new XYChart.Data<>("Pipes", 55));
        componentInventoryChart.getData().addAll(series1);
    }
    private void loadExpenseBreakdownData() {
        expenseBreakdownChart.getData().addAll(
                new PieChart.Data("Materials 43%", 43),
                new PieChart.Data("Labor 33%", 33),
                new PieChart.Data("Equipment 15%", 15),
                new PieChart.Data("Other 8%", 8)
        );
    }
    private void loadMonthlyTrendData() {
        XYChart.Series<String, Number> materialsSeries = new XYChart.Series<>();
        materialsSeries.setName("Materials");
        materialsSeries.getData().add(new XYChart.Data<>("Jul", 45000));
        materialsSeries.getData().add(new XYChart.Data<>("Aug", 51000));
        materialsSeries.getData().add(new XYChart.Data<>("Sep", 48000));
        materialsSeries.getData().add(new XYChart.Data<>("Oct", 55000));
        materialsSeries.getData().add(new XYChart.Data<>("Nov", 61000));

        XYChart.Series<String, Number> laborSeries = new XYChart.Series<>();
        laborSeries.setName("Labor");
        laborSeries.getData().add(new XYChart.Data<>("Jul", 35000));
        laborSeries.getData().add(new XYChart.Data<>("Aug", 37000));
        laborSeries.getData().add(new XYChart.Data<>("Sep", 39000));
        laborSeries.getData().add(new XYChart.Data<>("Oct", 41000));
        laborSeries.getData().add(new XYChart.Data<>("Nov", 45000));

        XYChart.Series<String, Number> equipmentSeries = new XYChart.Series<>();
        equipmentSeries.setName("Equipment");
        equipmentSeries.getData().add(new XYChart.Data<>("Jul", 15000));
        equipmentSeries.getData().add(new XYChart.Data<>("Aug", 17000));
        equipmentSeries.getData().add(new XYChart.Data<>("Sep", 15000));
        equipmentSeries.getData().add(new XYChart.Data<>("Oct", 19000));
        equipmentSeries.getData().add(new XYChart.Data<>("Nov", 22000));

        monthlyExpensesTrendChart.getData().addAll(materialsSeries, laborSeries, equipmentSeries);
    }
    private void loadStatsCards() {
        activeProjectsCount.setText("5");
        responsablesCount.setText("12");
        materialsTypes.setText("9 types");
        monthlyExpensesTotal.setText("$150K");
        cementProgress.setProgress(0.85);
        steelRodsProgress.setProgress(0.55);
        bricksProgress.setProgress(0.90);
    }

    // ---------------------------------------------
    // دوال التنقل الموحدة (Navigation Handlers)
    // ---------------------------------------------

    /** دالة مساعدة موحدة لتبديل الواجهات */
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

    // دالة Dashboard (التي تحل محل handleHomeClick)
    @FXML
    private void handleDashboardClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/dashboard.fxml", "Chief Dashboard");
    }

    @FXML
    private void handleResponsablesClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/responsables.fxml", "Project Responsables");
    }

    // ✅ تمت إضافة الدالة المفقودة هنا لتغطية زر Projects
    @FXML
    private void handleProjectsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/projects.fxml", "All Projects");
    }

    @FXML
    private void handleReportsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/reports.fxml", "Project Reports");
    }

    @FXML
    private void handleMaterialsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/materials.fxml", "Materials Management");
    }

    @FXML
    private void handleClientRequestsClick(ActionEvent event) throws IOException {
        loadNewScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests");
    }
}