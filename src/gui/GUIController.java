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
    private Button fightButton;
    @FXML
    private Button takeButton;
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
    private Text gold;
    @FXML
    private Text steps;

    @FXML
    private Text itemInfo;
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
        map.setPlayerName(name);
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

    public void fightPressed(){
        map.fight();
        showMessage(map.showAndWait());
    }

    public void takePressed(){
        map.takeItem();
        showMessage(map.showAndWait());
    }

    public void straightPressed(){
        map.goStraight();
        showMessage(map.showAndWait());
    }
    public void backPressed(){
        map.goBack();
        showMessage(map.showAndWait());
    }
    public void leftPressed(){
        map.goLeft();
        showMessage(map.showAndWait());
    }
    public void rightPressed(){
        map.goRight();
        showMessage(map.showAndWait());
    }
    public void showStats(){
        String[] stats = map.getStats();
        name.setText("Name: "+stats[0]);
        health.setText("KP: "+stats[1]);
        level.setText("Level: "+stats[2]);
        weapon.setText("Waffe: "+stats[3]);
        gold.setText("Gold: "+stats[4]);
        steps.setText("Schritte: "+stats[5]);

    }
    public void checkDirections(){
        if (map.isGameLost() || map.isGameWon()) {
            fightButton.setDisable(true);
            takeButton.setDisable(true);
            back.setDisable(true);
            left.setDisable(true);
            right.setDisable(true);
            straight.setDisable(true);
        } else if(map.hasCreature()){
            fightButton.setDisable(false);
            takeButton.setDisable(true);
            back.setDisable(false);
            left.setDisable(true);
            right.setDisable(true);
            straight.setDisable(true);
        } else {
            fightButton.setDisable(true);
            if(map.hasWeapon() || map.hasGold()) {
                takeButton.setDisable(false);
            }
            else {
                takeButton.setDisable(true);
            }
            if (!map.hasLeft()){
                left.setDisable(true);
            }
            else {
                left.setDisable(false);
            }
            if (!map.hasRight()){
                right.setDisable(true);
            }
            else {
                right.setDisable(false);
            }
            if (!map.hasStraight()){
                straight.setDisable(true);
            }
            else {
                straight.setDisable(false);
            }
            if(!map.hasBack()){
                back.setDisable(true);
            }
            else {
                back.setDisable(false);
            }
        }


    }

    public void showRoom(){
        String file = map.getRoomImageFileName();
        Image roomPic = new Image(GUIController.class.getResourceAsStream("/Resources/"+file));
        image.setFitWidth(300);
        image.setPreserveRatio(true);
        image.setImage(roomPic);
        text.setText(map.getRoomDescription());
        String item = map.getItemName();
        if (item.length() == 0){
            item = "-";
        }
        itemInfo.setText(item);
    }

    public void showMessage(List<String> strings){
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        String header = "Hmm... Wohin denn jetzt?";
        if(map.isGameWon()){
            header = "Juhu du hast gesiegt!";
            type = Alert.AlertType.WARNING;
        } else if (map.isGameLost()) {
            header = "Ehm, das war ... nicht so gut ...";
            type = Alert.AlertType.ERROR;
        }
        else {
            if (map.hasCreature()){
                header = "Da ist ein MOOONSTER!!!";
            }
            else {
                if(map.isCreatureKilled()){
                    header = "#$!!#! (Kampfgeräusche)";
                }
                if(map.hasWeapon()){
                    header = "Ui, da liegt was rum.";
                }
                else {
                    if(map.hasGold()){
                        header = "Es ist nicht alles Gold was glänzt, aber in diesem Fall schon!";
                    }
                }
            }
        }
        Alert alert = new Alert(type);
        alert.setTitle("Neuer Raum");
        alert.setHeaderText(header);
        if (strings.size() == 0){
            strings.add("Hier gibt's nichts... nur Staub");
        }
        String s = strings.stream()
                .map(i-> i.toString())
                .collect(Collectors.joining("\n"));
        alert.setContentText(s);
        alert.getDialogPane().setPrefWidth(600);
        alert.showAndWait();
    }

}
