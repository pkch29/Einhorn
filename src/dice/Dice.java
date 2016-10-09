package dice;


import java.util.Random;

/**
 * A 20 sides dice
 */
public class Dice {

    private Random rand = new Random();

    /**
     * method creates a random number
     * @return number
     */
    public int rollDice (){
        return (rand.nextInt(20)+1);
    }
}
