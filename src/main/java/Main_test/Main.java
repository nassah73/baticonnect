package Main_test; // تأكد بلي الباكيج عندك هو هذا

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // هنا فين كاين السر: كنقولو ليه سير جيب لينا الملف dashboard.fxml من دوسي view
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));

        // هنا كنحطو القياسات (نفس القياسات اللي درتي ف Scene Builder)
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("التطبيق ديالي");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}