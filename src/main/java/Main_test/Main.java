package Main_test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // المسار المصحح: /view/chef/dashboard.fxml
        // استخدام الشرطة المائلة '/' ليتطابق مع المجلدات المتداخلة view/chef
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/chefFXML/dashboard.fxml"));        Scene scene = new Scene(fxmlLoader.load(), 1200, 850);

        stage.setTitle("Chief Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}