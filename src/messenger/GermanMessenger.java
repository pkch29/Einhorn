package messenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates Messages to be displayed by the GUI
 */
public class GermanMessenger implements Messenger {


    private List<String> messages = new ArrayList<>();

    @Override
    public void playerWon() {
        messages.clear();
        messages.add("GAME OVER - Du hast gewonnen!");
        messages.add("");
        messages.add("Du kannst es gleich nochmal versuchen.");
        messages.add("Du befindest Dich wieder am Eingang - aber ohne Schatz.");
    }

    @Override
    public void help(){

    }

    @Override
    public void gameLost(String creatureName, String weaponNameCreature){

    }

    @Override
    public void creatureDied(String creatureName, String weaponNamePlayer, int hpPlayer, int damage){

    }

    @Override
    public void playerAttacked(String weaponNamePlayer, String weaponNameCreature, String creatureName,
                               boolean hasPlayerWon, int hpPlayer, int hpCreature, int damage){

    }

    @Override
    public List<String> getMessages() {
        return messages;
    }
}
