package gui;

import java.util.List;

/**
 * Creates connection between GUI and Game classes
 */
public interface GuiConnect {

    /**
     * Tell player to move forward
     */
    public void goStraight();

    /**
     * Tell player to move left
     */
    public void goLeft();

    /**
     * Tell player to move right
     */
    public void goRight();

    /**
     * Tell player to move backwards
     */
    public void goBack();

    /**
     * Test if player can move forward
     */
    public boolean hasStraight();

    /**
     * Test if player can move left
     */
    public boolean hasLeft();

    /**
     * Test if player can move right
     */
    public boolean hasRight();

    /**
     * Start a new game
     */
    public void newGame();

    /**
     * Get player stats
     */
    public int[] getStats();

    /**
     * Get help for current room
     */
    public String getHelp();

    /**
     * Return the current room object
     * //@TODO wer brauch das?
     */
    public String getRoom();

    /**
     * @TODO was macht das nochmal?
     */
    public List<String> showAndWait();

    /**
     * Set player name
     */
    public void setName(String name);

}
