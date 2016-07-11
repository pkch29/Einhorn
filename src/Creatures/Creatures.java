package Creatures;

/**
 * Created by Anna on 11.07.2016.
 */
public interface Creatures {


    /**
     *
     * @return the actual health points from the creature
     */
    int getHP();

    /**
     *
     * @return the actual level from the creature
     */
    int getLevel();

    /**
     *
     * @return
     */
    int attack();

    /**
     *
     * @return
     */
    String getName();


}
