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
     * Get player stats, String[] mit Name an 0, KP an 1, Level an 2 und Name von Weapon an 3
     */
    public int[] getStats();

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
    public void setName(String name);

}
