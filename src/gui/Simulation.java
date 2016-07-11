package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Simulation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SceneBuilderGUI.fxml"));
        primaryStage.setTitle("Dungeons and Dragons");
        primaryStage.setScene(new Scene(root, Color.LIGHTGRAY));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}