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
    void goStraight();

    /**
     * Tell player to move left
     * Test with hasLeft() before using this method.
     */
    void goLeft();

    /**
     * Tell player to move right
     * Test with hasRight() before using this method.
     */
    void goRight();

    /**
     * Tell player to move backwards
     * Test with hasBack() before using this method.
     */
    void goBack();

    /**
     * Test if player can move forward
     */
    boolean hasStraight();

    /**
     * Test if player can move left
     */
    boolean hasLeft();

    /**
     * Test if player can move right
     */
    boolean hasRight();

    /**
     * Test if player can move backwards
     */
    boolean hasBack();

    /**
     * Test if room has a weapon
     * @return whether room has a weapon
     */
    boolean hasWeapon();

    /**
     * Test if room has a creature
     * @return whether room has a creature
     */
    boolean hasCreature();

    /**
     * Test if room has gold
     * @return whether room has gold
     */
    boolean hasGold();

    /**
     * Start a new game
     */
    void newGame();

    /**
     * Get player stats, String[] mit Name an 0, KP an 1, Level an 2 und Name von Weapon an 3
     */
    String[] getStats();

    /**
     * Get help for current room
     */
    String getHelp();

    /**
     * Returns the file name of the image for the current room.
     * @return the file name of the image for the current room
     */
    String getRoomImageFileName();

    /**
     * Returns the description of the current room.
     * @return the description of the current room
     */
    String getRoomDescription();

    /**
     * Returns the messages the GUI needs to display during a fight with a creature,
     * or finding of treasures.
     * @return A list of Strings which will be displayed
     */
    List<String> showAndWait();

    /**
     * Set player name
     */
    void setPlayerName(String name);
}




