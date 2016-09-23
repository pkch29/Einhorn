package creature;

import item.Weapon;

/**
 * Created by Anna on 11.07.2016.
 */
public class Player implements Creatures {

    int HP;
    int level;
    String name;
    Weapon weapon;
    int dir;
    int maxHP;

    private boolean flagHasTreasure = false;

    // 0-Norden, 1-Osten, 2-Süden, 3-Westen
    int direction;

    /**
     * Create a player from a given creature
     * @param creature
     */
    public Player(Creature creature) {
        this.HP = creature.getHP();
        this.maxHP = creature.getHP();
        this.level = creature.getLevel();
        this.weapon = creature.getWeapon();
        this.dir = 0;
    }

    /**
     * sets the direction (integer values - 0 north, 1 east, 2 south, 3 west
     * @param dir - set dir as direction
     */
    public void setDirection(int dir){
       direction=dir;
    }

    /**
     * go left and returns the actual direction
     * @return direction
     */
    public int goLeft(){
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
        if(HP>0){
            return true;
        } else {
            return false;
        }
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
    public int attack(int attackdamage, int level, int dice) {
        int damage;

        damage = (attackdamage*level)+ dice;
        //Schlagstärke = Angriffskraft der Waffe * eigenes Level + Wurf eines D20 Würfels

        return damage;
    }

    @Override
    public int attack(int dice) {
        int damage = (weapon.getForce()*level) + dice;
        return damage;
    }

    public void killedCreature(){
        level += 1;
        // TODO: 14.09.16 healing() when leaving room or maxHP after kill. 
//        HP = maxHP;
    }

    public void setTreasure (){
        flagHasTreasure = true;
    }

    public boolean hasTreasure(){
        return flagHasTreasure;
    }

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

    @Override
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public void setHp(int hp) {
        this.HP = hp;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public String[] getStats() {
        String[] stats = new String[4];
        stats[0] = getName();
        stats[1] = Integer.toString(getHP());
        stats[2] = Integer.toString(getLevel());
        stats[3] = getWeapon().getName();
        return stats;
    }
}
