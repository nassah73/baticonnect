package controler;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class DashboardController {

    // تعريف الرسوم البيانية
    @FXML private BarChart<String, Number> componentInventoryChart;
    @FXML private PieChart expenseBreakdownChart;
    @FXML private LineChart<String, Number> monthlyExpensesTrendChart;

    // تعريف لوحات الإحصاء
    @FXML private Label activeProjectsCount;
    @FXML private Label responsablesCount;
    @FXML private Label materialsTypes;
    @FXML private Label monthlyExpensesTotal;

    // تعريف مؤشرات التقدم
    @FXML private Label cementLabel;
    @FXML private ProgressIndicator cementProgress;
    @FXML private Label steelRodsLabel;
    @FXML private ProgressIndicator steelRodsProgress;
    @FXML private Label bricksLabel;
    @FXML private ProgressIndicator bricksProgress;

    @FXML
    public void initialize() {
        // تهيئة الرسوم البيانية والإحصائيات
        loadInventoryData();
        loadExpenseBreakdownData();
        loadMonthlyTrendData();
        loadStatsCards();
    }

    private void loadInventoryData() {
        // ... كود تحميل BarChart ...
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
        // ... كود تحميل PieChart ...
        expenseBreakdownChart.getData().addAll(
                new PieChart.Data("Materials 43%", 43),
                new PieChart.Data("Labor 33%", 33),
                new PieChart.Data("Equipment 15%", 15),
                new PieChart.Data("Other 8%", 8)
        );
    }

    private void loadMonthlyTrendData() {
        // ... كود تحميل LineChart ...
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
        // تحديث النصوص
        activeProjectsCount.setText("5");
        responsablesCount.setText("12");
        materialsTypes.setText("9 types");
        monthlyExpensesTotal.setText("$150K");

        // تحديث Progress Indicators
        cementProgress.setProgress(0.85);
        steelRodsProgress.setProgress(0.55);
        bricksProgress.setProgress(0.90);
    }

    @FXML
    private void handleHomeClick() {
        System.out.println("زر Home تم الضغط عليه.");
    }
}