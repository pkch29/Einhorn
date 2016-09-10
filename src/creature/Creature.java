package creature;

import item.Item;

/**
 * Creates a creature with the attributes that have been set
 *
 */

public class Creature implements Creatures {

    private String name;
    private String species;
    private String description;
    private int hp;
    private int level;
    private Item item;

    public Creature(String name, String species, String description, int hp, int level, Item item) {
        this.name = name;
        this.species = species;
        this.description = description;
        this.hp = hp;
        this.level = level;
        this.item = item;
    }

    /**
     * Turns the object name into a String
     * @return the creatures species and name
     */
    public String toString(){
        return " the " + species + " " + name;
    }

    /**
     * Gets the health points of the creature
     * @return health points
     */
    @Override
    public int getHP() {
        return hp;
    }

    /**
     * Gets the name of the creature
     * @return the creatures name
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the species name of the creature
     * @return the creatures species name
     */
    public String getSpecies(){
        return species;
    }

    /**
     * Gets the description of the creature
     * @return the creatures description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Gets the experience level of the creature
     * @return the creatures level
     */
    public int getLevel(){
        return level;
    }

    /**
     * method that attacks
     * @param attackdamage
     * @param level is the actual level of the creature
     * @param dice is a random number of a D20-dice
     * @return damage
     */
    public int attack(int attackdamage, int level, int dice) {
        int damage;
        damage = (attackdamage*level)+ dice;
        //Schlagstärke = Angriffskraft der Waffe * eigenes Level + Wurf eines D20 Würfels

        return damage;
    }

    /**
     * Gets the item of creature
     * @return the creatures item
     */
    public Item getItem(){
        return item;
    }

    /**
     * Sets the name of the creature
     * @param name of the creature
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the name of the creature
     * @param species name of the creature
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets the description of the creature
     * @param description of the creature
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets creatures health points
     * @param hp, health points of the creature
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Sets the experience level of the creature
     * @param level of the creature
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Sets creatures item
     * @param item of the creature
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Checks if the health points of the creature greater than 0
     * @return true if health points greater than 0, otherwise return false
     */
    public boolean isAlive(){
        return hp > 0;
    }

    
}
