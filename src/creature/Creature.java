package creature;

import item.Weapon;

/**
 * Creates a creature with defined attributes
 */
public class Creature implements Creatures {

    private String name;
    private String species;
    private String description;
    private int hp;
    private int level;
    private Weapon weapon;

    /**
     * Default constructor
     * @param name name of the creature
     * @param species species of the creature
     * @param description description of the creature
     * @param level starting level
     * @param hp maximum HP of the creature
     * @param weapon weapon carried by the creature
     */
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
        return (weapon.getForce()*level) + dice;
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

    @Override
    public boolean isAlive(){
        return hp > 0;
    }
    
}
