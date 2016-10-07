package creature;

import item.Weapon;

/**
 * Created by Anna on 11.07.2016.
 */
public interface Creatures {

    /**
     * Checks if the creature is alive or not.
     * @return whether the creature is alive or not
     */
    boolean isAlive();

    /**
     * Defend against the damage, and reduce live accordingly
     * health points shouldn't be smaller than 0
     * @param damage damage taken by an attack
     */
    void defend(int damage);

    /**
     * Turns the name into a String.
     * @return the name of the creature as a String.
     */
    String toString();

    /**
     * Gets the health points of the creature.
     * @return the actual health points from the creature
     */
    int getHP();

    /**
     * Gets the weapon of the creature.
     * @return the weapon of the creature
     */
    Weapon getWeapon();

    /**
     * Gets the level of the creatures.
     * @return the actual level from the creature
     */
    int getLevel();

    /**
     * Gets the attack damage of the creature
     * @param dice is a random number of a D20-dice
     * @return the attackdamage of the creature
     */
    int attack(int dice);

    /**
     * Gets the name of the creature.
     * @return the creatures name.
     */
    String getName();

}
