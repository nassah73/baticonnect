package controler.chefController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

// الاستيرادات الإضافية للرسوم البيانية
import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart; // لاستخدام Series في BarChart و LineChart
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DashboardController {

    // 🚨 حقن عناصر الرسوم البيانية FXML
    @FXML
    private PieChart expensePieChart;

    @FXML
    private BarChart<String, Number> inventoryBarChart; // BarChart للمخزون

    @FXML
    private LineChart<String, Number> monthlyLineChart; // LineChart للاتجاهات الشهرية


    @FXML
    public void initialize() {
        // تهيئة البيانات لجميع الرسوم البيانية
        loadExpenseBreakdownData();
        loadInventoryData();
        loadMonthlyTrend();
    }

    // 1. دالة تحميل بيانات الرسم البياني الدائري (PieChart)
    private void loadExpenseBreakdownData() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Materials 43%", 43),
                        new PieChart.Data("Labor 33%", 33),
                        new PieChart.Data("Equipment 15%", 15),
                        new PieChart.Data("Other 8%", 8)
                );

        if (expensePieChart != null) {
            expensePieChart.setData(pieChartData);
            expensePieChart.setTitle("");
        }
    }

    // 2. 🚨 دالة تحميل بيانات المخزون (BarChart)
    private void loadInventoryData() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Inventory Level (%)");

        // إضافة بيانات المخزون (Cement, Steel Rods, Bricks, Electrical Wire)
        series.getData().add(new XYChart.Data<>("Cement", 85));
        series.getData().add(new XYChart.Data<>("Steel Rods", 55));
        series.getData().add(new XYChart.Data<>("Bricks", 90));
        series.getData().add(new XYChart.Data<>("Electrical Wire", 50));

        if (inventoryBarChart != null) {
            inventoryBarChart.getData().add(series);
            inventoryBarChart.setLegendVisible(false);
        }
    }

    // 3. 🚨 دالة تحميل بيانات الاتجاه الشهري (LineChart)
    private void loadMonthlyTrend() {
        // البيانات تقريبية للتمثيل
        String[] months = {"Jul", "Aug", "Sep", "Oct", "Nov"};

        // سلسلة Materials (اللون الأزرق في الصورة المرجعية)
        XYChart.Series<String, Number> materialsSeries = new XYChart.Series<>();
        materialsSeries.setName("Materials");
        materialsSeries.getData().add(new XYChart.Data<>(months[0], 45000));
        materialsSeries.getData().add(new XYChart.Data<>(months[1], 52000));
        materialsSeries.getData().add(new XYChart.Data<>(months[2], 47000));
        materialsSeries.getData().add(new XYChart.Data<>(months[3], 57000));
        materialsSeries.getData().add(new XYChart.Data<>(months[4], 62000));

        // سلسلة Labor (اللون الأخضر)
        XYChart.Series<String, Number> laborSeries = new XYChart.Series<>();
        laborSeries.setName("Labor");
        laborSeries.getData().add(new XYChart.Data<>(months[0], 35000));
        laborSeries.getData().add(new XYChart.Data<>(months[1], 40000));
        laborSeries.getData().add(new XYChart.Data<>(months[2], 42000));
        laborSeries.getData().add(new XYChart.Data<>(months[3], 43000));
        laborSeries.getData().add(new XYChart.Data<>(months[4], 45000));

        // سلسلة Equipment (اللون البرتقالي)
        XYChart.Series<String, Number> equipmentSeries = new XYChart.Series<>();
        equipmentSeries.setName("Equipment");
        equipmentSeries.getData().add(new XYChart.Data<>(months[0], 15000));
        equipmentSeries.getData().add(new XYChart.Data<>(months[1], 18000));
        equipmentSeries.getData().add(new XYChart.Data<>(months[2], 15000));
        equipmentSeries.getData().add(new XYChart.Data<>(months[3], 20000));
        equipmentSeries.getData().add(new XYChart.Data<>(months[4], 22000));


        if (monthlyLineChart != null) {
            monthlyLineChart.getData().addAll(materialsSeries, laborSeries, equipmentSeries);
        }
    }


    // =================================================================
    // دوال التنقل الموحدة (Standard Navigation Functions)
    // =================================================================

    private void switchScene(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setTitle(title);
            stage.getScene().setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML: " + fxmlPath);
        }
    }

    @FXML
    private void handleDashboardClick(ActionEvent event) { }

    @FXML
    private void handleResponsablesClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/responsables.fxml", "Responsables Management");
    }

    @FXML
    private void handleProjectsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/projects.fxml", "Projects Management");
    }

    @FXML
    private void handleReportsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/reports.fxml", "Reports & Analytics");
    }

    @FXML
    private void handleMaterialsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/materials.fxml", "Materials Inventory");
    }

    @FXML
    private void handleClientRequestsClick(ActionEvent event) {
        switchScene(event, "/view/chefFXML/clientRequests.fxml", "Client Requests");
    }
}