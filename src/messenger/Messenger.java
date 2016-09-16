package messenger;

import java.util.List;

/**
 * Generates Messages to be displayed by the GUI
 */
public class Messenger {

    /**
     * Player won the game
     * @param messages the messages to be displayed by GUI
     */
    public void playerWon(List<String> messages) {
        messages.clear();
        messages.add("GAME OVER - Du hast gewonnen!");
        messages.add("");
        messages.add("Du kannst es gleich nochmal versuchen.");
        messages.add("Du befindest Dich wieder am Eingang - aber ohne Schatz.");
    }

}
