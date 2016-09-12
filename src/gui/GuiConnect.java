package gui;

import java.util.List;

/**
 * Creates connection between GUI and Game classes
 */
public interface GuiConnect {

    /**
     * Tell player to move forward
     * Test with hasStraight() before using this method.
     */
    public void goStraight();

    /**
     * Tell player to move left
     * Test with hasLeft() before using this method.
     */
    public void goLeft();

    /**
     * Tell player to move right
     * Test with hasRight() before using this method.
     */
    public void goRight();

    /**
     * Tell player to move backwards
     * Test with hasBack() before using this method.
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
     * Test if player can move backwards
     */
    public boolean hasBack();

    /**
     * Start a new game
     */
    public void newGame();

    /**
     * Get player stats, String[] mit Name an 0, KP an 1, Level an 2 und Name von Weapon an 3
     */
    public String[] getStats();

    /**
     * Get help for current room
     */
    public String getHelp();

    /**
     * Returns the file name of the image for the current room.
     * @return the file name of the image for the current room
     */
    public String getRoomImageFileName();

    /**
     * Returns the description of the current room.
     * @return the description of the current room
     */
    public String getRoomDescription();

    /**
     * Returns the messages the GUI needs to display during a fight with a creature,
     * or finding of treasures.
     * @return A list of Strings which will be displayed
     */
    public List<String> showAndWait();

    /**
     * Set player name
     */
    public void setPlayerName(String name);

}
