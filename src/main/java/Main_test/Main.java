package Main_test;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label helloLabel = new Label("🥳 JavaFX Khdama! Baticonnect Is Ready.");


        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);


        Scene scene = new Scene(root, 400, 300);


        stage.setTitle("JavaFX Test - Baticonnect");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}