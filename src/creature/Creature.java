package creature;

import item.Item;
import item.Weapon;

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
    private Weapon weapon;

    public Creature(String name, String species, String description, int level, int hp, Weapon weapon) {
        this.name = name;
        this.species = species;
        this.description = description;
        this.hp = hp;
        this.level = level;
        this.weapon = weapon;
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
    public int attack(int dice) {
        int damage = (weapon.getForce()*level) + dice;
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
    public Weapon getWeapon(){
        return weapon;
    }

    /**
     * Sets the description of the creature
     * @param description of the creature
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isAlive(){
        return hp > 0;
    }

    
}
