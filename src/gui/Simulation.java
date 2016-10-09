package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This simulation is based on the popular game dungeons &amp; dragons. You can guide your hero
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

    /**
     * Main method of the program, launches the Application.
     * @param args The arguments given at the command line
     */
    public static void main(String[] args) {
        launch(args);
    }
}