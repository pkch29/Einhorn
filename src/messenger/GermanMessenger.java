package messenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates Messages to be displayed by the GUI
 */
public class GermanMessenger implements Messenger {


    private List<String> messages = new ArrayList<>();

    /**
     * Player won the game
     */
    public void playerWon() {
        messages.clear();
        messages.add("GAME OVER - Du hast gewonnen!");
        messages.add("");
        messages.add("Du kannst es gleich nochmal versuchen.");
        messages.add("Du befindest Dich wieder am Eingang - aber ohne Schatz.");
    }

    public List<String> getMessages() {
        return messages;
    }
}
