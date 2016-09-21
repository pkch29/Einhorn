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
     * @param creatureName
     * @param weaponNameCreature
     */
    void gameLost(String creatureName, String weaponNameCreature);

    /**
     * Creature lost the fight and died
     * @param creatureName
     * @param weaponNamePlayer
     * @param hpPlayer
     * @param damage
     */
    void creatureDied(String creatureName, String weaponNamePlayer, int hpPlayer, int damage);

    /**
     * Message after fight, both are still alive
     * @param weaponNamePlayer
     * @param weaponNameCreature
     * @param creatureName
     * @param hasPlayerWon
     * @param hpPlayer
     * @param hpCreature
     * @param damage
     */
    void playerAttacked(String weaponNamePlayer, String weaponNameCreature, String creatureName, boolean hasPlayerWon,
                        int hpPlayer, int hpCreature, int damage);


    /**
     * Message about a creature inside a room
     * @param name name of the creature
     * @param description a sentence with detailed description
     * @param species name of the species
     * @param weaponName name of the weapon type
     */
//    void roomHasCreature(String name, String description, String species, String weaponName);

    /**
     * Message about a weapon inside a room
     * @param name name of the weapon
     * @param description a sentence with detailed description
     * @param force force of the weapon
     */
//    void roomHasWeapon(String name, String description, int force);


    /**
     * Message about a treasure inside a room
     * @param name name of the treasure
     * @param description a sentence with detailed description
     */
//    void roomHasTreasure(String name, String description);

}
