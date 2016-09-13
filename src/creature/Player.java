package creature;

import creature.Creatures;
import item.Item;

/**
 * Created by Anna on 11.07.2016.
 */
public class Player implements Creatures {

    int HP;
    int level;
    String name;
    Item item;
    boolean alive;

    // 0-Norden, 1-Osten, 2-Süden, 3-Westen
    int direction;



    public Player(String name, int level, int Hp){
        this.name = name;
        this.level = level;
        this.HP = Hp;
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
        if(direction<0 || direction>3){
            direction = direction%4;
        }
        return direction;
    }

    /**
     *
     * @return
     */
    public int goRight(){
        direction ++;
        if(direction<0 || direction>3){
            direction = direction%4;
        }
        return direction;
    }

    /**
     *
     * @return
     */
    public int goBack(){
        direction =- 2;

        if(direction<0 || direction>3){
            direction = direction%4;
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


    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void defend(int damage) {
        HP =- damage;

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
    public Item getItem() {
        return item;
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
        return 0;
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
    public void setItem(Item item) {
        this.item = item;
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
        stats[3] = getItem().getName();
        return stats;
    }
}
