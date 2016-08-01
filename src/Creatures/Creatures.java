package Creatures;

import item.Item;
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
     * Gets the Item of the creature.
     * @return the item of the creature
     */
    Item getItem();

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
     * Sets the name of the creature.
     * @param name of the creature
     */
    void setName(String name);

    /**
     * Sets the Health points of the creature.
     * @param hp health points of the creature
     */
    void setHp(int hp);

    /**
     * Sets the creatures (new) Item.
     * @param item of the creature
     */
    void setItem(Item item);

    /**
     * Sets the level of the creature.
     * @param level of the creature
     */
    void setLevel(int level);



}
