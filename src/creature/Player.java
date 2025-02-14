package creature;

import item.Weapon;

/**
 * The representation of the user in the game.
 */
public class Player implements Creatures {

    private int HP;
    private int level;
    private String name;
    private Weapon weapon;
    private int gold;
    private int dir;
    private int maxHP;
    private int steps;

    // 0-north, 1-east, 2-south, 3-west
    private int direction;

    /**
     * Create a player from a given creature
     * @param creature the object creature
     */
    public Player(Creature creature) {
        this.HP = creature.getHP();
        this.maxHP = creature.getHP();
        this.level = creature.getLevel();
        this.weapon = creature.getWeapon();
        this.gold = 0;
        this.dir = 0;
        this.steps = 0;
    }

    /**
     * Collect a given amount of gold
     * @param amount amount of gold that was collected
     */
    public void collectGold(int amount) {
        gold += amount;
    }

    /**
     * go left and returns the actual direction
     * @return direction
     */
    public int goLeft(){
        steps++;
        direction --;
        if(direction>3){
            direction = direction%4;
        } else if(direction<0){
            direction =3;
        }
        return direction;
    }

    /**
     * go right and returns the actual direction
     * @return direction
     */
    public int goRight(){
        steps++;
        direction ++;
        if(direction>3){
            direction = direction%4;
        }
        return direction;
    }

    /**
     * go back and returns the actual direction
     * @return direction
     */
    public int goBack(){
        steps++;
        direction -= 2;

        if(direction>3){
            direction = direction%4;
        }else if(direction==-1){
            direction= 3;
        } else if(direction==-2){
            direction = 2;
        }

        return direction;
    }

    /**
     * go straight and return actual direction
     * @return direction
     */
    public int goStraight(){
        steps++;
        return direction;
    }

    /**
     * gets the left direction
     * @return direction
     */
    public int getLeftDirection(){

        if(direction==0){
            dir = 3;
        } else {
            dir = direction - 1;
        }
        return dir;
    }

    /**
     * gets the back direction
     * @return direction
     */
    public int getBackDirection(){

        if(direction==1){
            dir = 3;
        }else if (direction==0){
            dir = 2;
        }else {
            dir = direction -2;
        }

        return dir;
    }

    /**
     * gets the right direction
     * @return direction
     */
    public int getRightDirection(){

        if(direction==3){
            dir = 0;
        }else{
            dir = direction+1;
        }

        return dir;

    }

    /**
     * get the straight direction
     * @return direction
     */
    public int getStraightDirection(){
        return direction;
    }

    @Override
    public boolean isAlive() {
        return (HP > 0);
    }

    @Override
    public void defend(int damage) {
            int newHp = HP - damage;
            if (newHp <= 0){
                HP = 0;
            }else HP = newHp;
    }

    @Override
    public String toString(){

        return "You are called:  "+ name ;
    }

    /**
     * Gets collected amount of gold.
     * @return collected amount of gold
     */
    public int getGold() { return gold; }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int attack(int dice) {
        return (weapon.getForce()*level) + dice;
    }

    /**
     * Adds 1 to the player level
     */
    public void killedCreature(){
        level += 1;
    }

    /**
     * Checks if player has collected the treasure
     * @return whether gold was collected
     */
    public boolean hasTreasure(){
        return gold > 0;
    }

    /**
     * Heals player health points
     */
    public void healing(){
        HP += 5;
        if (HP > maxHP){
            HP = maxHP;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gives player a weapon.
     * @param weapon the weapon to give to the player
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Get player stats as array of String.
     * The array has the following structure:
     * 0: name of player
     * 1: his current HP
     * 2: his current level
     * 3: name of the equipped weapon
     * 4: collected amount of gold
     * 5: number of gone steps
     * @return String array of fixed length with 6 entries.
     */
    public String[] getStats() {
        String[] stats = new String[6];
        stats[0] = getName();
        stats[1] = Integer.toString(getHP());
        stats[2] = Integer.toString(getLevel());
        stats[3] = getWeapon().getName();
        stats[4] = Integer.toString(getGold());
        stats[5] = Integer.toString(steps);
        return stats;
    }
}
