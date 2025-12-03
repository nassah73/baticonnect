package Main_test; // استبدل Main_test باسم الحزمة الرئيسية لديك

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signIn.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            primaryStage.setTitle("ConstructionHub - Sign In");
            primaryStage.setScene(scene);

            // ✅ التعديل هنا: السماح للمستخدم بتكبير وتصغير النافذة
            primaryStage.setResizable(true);

            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Failed to load the Sign In FXML file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}