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


}
