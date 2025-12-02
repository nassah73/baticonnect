package Main_test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // المسار صحيح: /view/dashboard.fxml داخل مجلد resources
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1200, 850);

        stage.setTitle("Chief Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // تشغيل التطبيق
        launch();
    }
}