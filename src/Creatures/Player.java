package Creatures;

/**
 * Created by Anna on 11.07.2016.
 */
public class Player implements Creatures{

    int HP;
    int level;
    String name;


    public Player(String name, int level, int Hp){
        this.name = name;
        this.level = level;
        this.HP = Hp;
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
    public void setLevel(int level) {
        this.level = level;
    }
}
