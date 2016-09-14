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

    // 0-Norden, 1-Osten, 2-Süden, 3-Westen
    int direction;



//    public Player(String name, int level, int Hp){
//        this.name = name;
//        this.level = level;
//        this.HP = Hp;
//        this.dir = 0;
//    }

    /**
     * Create a player from a given creature
     * @param creature
     */
    public Player(Creature creature) {
        this.HP = creature.getHP();
        this.level = creature.getLevel();
        this.weapon = creature.getWeapon();
        this.dir = 0;
    }

    /**
     *
     * @param dir
     */
    public void setDirection(int dir){
       direction=dir;
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public int goRight(){
        direction ++;
        if(direction>3){
            direction = direction%4;
        }
        return direction;
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public int goStraight(){
        return direction;
    }


    /**
     *
     * @return
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
     *
     * @return
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
     *
     * @return
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
     *
     * @return
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
        level +=1;
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
