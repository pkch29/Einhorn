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
     * @return whether the player can move forward
     */
    boolean hasStraight();

    /**
     * Test if player can move left
     * @return whether the player can move left
     */
    boolean hasLeft();

    /**
     * Test if player can move right
     * @return whether the player can move right
     */
    boolean hasRight();

    /**
     * Test if player can move backwards
     * @return whether the player can move backwards
     */
    boolean hasBack();

    /**
     * Test if room has a weapon
     * @return whether room has a weapon
     */
    boolean hasWeapon();

    /**
     * Test if room has a creature that is alive
     * @return whether room has a creature
     */
    boolean hasCreature();

    /**
     * Player wants to fight the monster.
     */
    void fight();

    /**
     * Test if room has gold
     * @return whether room has gold
     */
    boolean hasGold();

    /**
     * Test whether creature was recently killed.
     * @return whether creature was recently killed
     */
    boolean isCreatureKilled();

    /**
     * Start a new game
     */
    void newGame();

    /**
     * Get player stats as array of String.
     * The array has the following structure:
     * 0: name of player
     * 1: his current KP
     * 2: his current level
     * 3: name of the equipped weapon
     * 4: collected amount of gold
     * 5: number of gone steps
     * @return String array of fixed length with 6 entries.
     */
    String[] getStats();

    /**
     * Get help and instructions to play the game.
     * @return help and instructions to play the game.
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
     * Returns the messages the GUI needs to display about what creatures and items are in the room.
     * @return A list of Strings which will be displayed
     */
    List<String> showAndWait();

    /**
     * Set player name
     * @param name the new name of the player
     */
    void setPlayerName(String name);

    /**
     * Tells the GUI name of the item in the current room.
     * Item can be a weapon or a treasure.
     * @return Name of the item stored in the current room.
     */
    String getItemName();

    /**
     * Tells the map to take the item into the inventory of the player.
     */
    void takeItem();

    /**
     * Tells the gui if the player finished the game.
     * @return whether game is won
     */
    boolean isGameWon();

    /**
     * Tells the gui if the player died.
     * @return whether game is lost
     */
    boolean isGameLost();
}




