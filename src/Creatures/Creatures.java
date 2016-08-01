package Creatures;

/**
 * Created by Anna on 11.07.2016.
 */
public interface Creatures {

    /**
     * Turns the name into a String.
     * @return the name of the crature as a String.
     */
    String toString();

    /**
     * Gets the health points of the creature.
     * @return the actual health points from the creature
     */
    int getHP();

    /**
     * Gets the level of the creatures.
     * @return the actual level from the creature
     */
    int getLevel();

    /**
     * Gets the attack damage of the creature.
     * @param damage needs the attackdamage of the weapon of the creature
     * @param level is the actual level of the creature
     * @param dice is a random number of a D20-dice
     * @return the attackdamage of the creature.
     */
    int attack(int damage, int level, int dice);

    /**
     * Gets the name of the creature.
     * @return the creatures name.
     */
    String getName();

    /**
     *
     * @param name
     */
    void setName(String name);

    /**
     *
     * @param hp
     */
    void setHp(int hp);

    /**
     *
     * @param level
     */
    void setLevel(int level);



}
