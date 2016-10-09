package messenger;


import java.util.List;

public interface Messenger {


    /**
     * Player won the game
     */
    void playerWon();

    /**
     * Gets the Messages
     * @return messages of list
     */
    List<String> getMessages();

    /**
     * Player get help
     */
    void help();

    /**
     * Player lost the fight and died
     * @param creatureName the name of the creature
     * @param weaponNameCreature weapon that is used by creature
     */
    void gameLost(String creatureName, String weaponNameCreature);

    /**
     * Creature lost the fight and died
     * @param creatureName the name of the creature
     * @param weaponNamePlayer weapon that is used by player
     * @param hpPlayer health points of player
     * @param damage damage taken by an attack
     */
    void creatureDied(String creatureName, String weaponNamePlayer, int hpPlayer, int damage);

    /**
     * Message after fight, both are still alive
     * @param weaponNamePlayer weapon that is used by player
     * @param weaponNameCreature weapon that is used by creature
     * @param creatureName the name of the creature
     * @param playerName the name of the player
     * @param hasPlayerWon whether the player has won or not
     * @param hpPlayer health points of player
     * @param hpCreature health points of creature
     * @param damage damage taken by an attack
     */
    void playerAttacked(String weaponNamePlayer, String weaponNameCreature, String creatureName, String playerName,
                        boolean hasPlayerWon, int hpPlayer, int hpCreature, int damage);

    /**
     * Message about a creature inside a room
     * @param name name of the creature
     * @param description a sentence with detailed description
     * @param species name of the species
     * @param weaponName name of the weapon type
     */
    void roomHasCreature(String name, String description, String species, String weaponName);

    /**
     * Message about a weapon inside a room
     * @param name name of the weapon
     * @param description a sentence with detailed description
     */
    void roomHasWeapon(String name, String description);

    /**
     * Message about a treasure inside a room
     * @param name name of the treasure
     * @param description a sentence with detailed description
     */
    void roomHasTreasure(String name, String description);

    /**
     * Message about the treasure that is taken
     * @param name name of treasure
     * @param description a sentence with detailed description
     * @param amount amount of gold
     */
    void treasureIsTaken(String name, String description, int amount);

    /**
     * Message about the weapon that is taken
     * @param name name of weapon
     * @param description a sentence with detailed description
     * @param force force of the weapon
     */
    void weaponIsTaken(String name, String description, int force);

    /**
     * Mesage that there is nothing special in the room.
     */
    void roomIsEmpty();

}
