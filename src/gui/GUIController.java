package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import map.Map;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by Lisa on 06.07.2016.
 */
public class GUIController implements Initializable {
    GuiConnect map = new Map();
    @FXML
    private Button newButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button straight;
    @FXML
    private Button right;
    @FXML
    private Button left;
    @FXML
    private Button back;
    @FXML
    private Text name;
    @FXML
    private Text health;
    @FXML
    private Text level;
    @FXML
    private Text weapon;

    @FXML
    private Text text;
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newGame();

    }

    public void getName(){
        TextInputDialog dialog = new TextInputDialog("Pink Fluffy Unicorn");
        dialog.setTitle("Wie lautet dein Name?");
        dialog.setHeaderText(null);
        dialog.setContentText("Bitte gib deinen Namen ein:");
        Optional<String> result = dialog.showAndWait();
        String name = "";
        if (result.isPresent()){
             name = result.get();
        }
        map.setName(name);
    }

    public void newGame(){
        map.newGame();
        getName();
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kfStats = new KeyFrame(Duration.millis(500), (x)->showStats());
        KeyFrame kfDir = new KeyFrame(Duration.millis(1), (x)->checkDirections());
        KeyFrame kfRoom = new KeyFrame(Duration.millis(1), (x)->showRoom());
        timeline.getKeyFrames().addAll(kfStats,kfDir,kfRoom);
        timeline.play();
    }

    public void newPressed(){
        newGame();
    }

    public void helpPressed(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hilfe");
        alert.setHeaderText(null);
        alert.setContentText(map.getHelp());

        alert.showAndWait();

    }

    public void straightPressed(){
        map.goStraight();
        showMessage();
    }
    public void backPressed(){
        map.goBack();
        showMessage();
    }
    public void leftPressed(){
        map.goLeft();
        showMessage();
    }
    public void rightPressed(){
        map.goRight();
        showMessage();
    }
    public void showStats(){
        map.getStats();
        //Gefaket zum testen
        String[] stats = {"Name", "100", "1", "Hand"};
        name.setText("Name: "+stats[0]);
        health.setText("KP: "+stats[1]);
        level.setText("Level: "+stats[2]);
        weapon.setText("Waffe: "+stats[3]);

    }
    public void checkDirections(){
        if (!map.hasLeft()){
            left.setDisable(true);
        }
        if (!map.hasRight()){
            right.setDisable(true);
        }
        if (!map.hasStraight()){
            straight.setDisable(true);
        }
    }

    public void showRoom(){
        //Ändern zu map.getRoomImageFileName wenn implementiert
        Image roomPic = new Image(GUIController.class.getResourceAsStream("/Resources/Lothofiedus.jpg"));
        image.setFitWidth(300);
        image.setPreserveRatio(true);
        image.setImage(roomPic);
        text.setText(map.getRoomDescription());
    }

    public void showMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Neuer Raum");
        alert.setHeaderText("Da ist ein MOOONSTER!!!");
        //List<String> t = map.showAndWait();
        List<String> t = new ArrayList<String>();
        t.add("bla");
        t.add("blub");
        String s = t.stream()
                .map(i-> i.toString())
                .collect(Collectors.joining("\n"));
        alert.setContentText(s);

        alert.showAndWait();
    }

}
