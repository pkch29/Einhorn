package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This simulation is based on the popular game dungeons&dragons. You can guiding your hero
 * through a text-based quest for treasure and battle with deadly creatures.
 */

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