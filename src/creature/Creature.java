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

    public Creature(String name, String species, String description, int level, int hp, Item item) {
        this.name = name;
        this.species = species;
        this.description = description;
        this.hp = hp;
        this.level = level;
        this.item = item;
    }

    @Override
    public String toString(){
        return " the " + species + " " + name;
    }

    @Override
    public int getHP() {return hp;}

    @Override
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

    @Override
    public int getLevel(){
        return level;
    }

    @Override
    public int attack(int attackdamage, int level, int dice) {
        int damage = (attackdamage*level)+ dice;
        //Schlagstärke = Angriffskraft der Waffe * eigenes Level + Wurf eines D20 Würfels

        return damage;
    }

    @Override
    public int attack(int dice) {
        int damage = (item.getForce()*level) + dice;
        return damage;
    }

    @Override
    public void defend(int damage) {
        int newHp = hp - damage;
        if (newHp < 0){
            hp = 0;
        }else hp = newHp;
    }

    @Override
    public Item getItem(){
        return item;
    }

    @Override
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

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean isAlive(){
        return hp > 0;
    }

    
}
