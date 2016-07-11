package Creatures;

/**
 * Created by Anna on 11.07.2016.
 */
public class Player implements Creatures{

    int HP;
    int level;
    String name;


    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
