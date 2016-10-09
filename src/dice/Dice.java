package dice;


import java.util.Random;

/**
 * A 20 sides dice
 */
public class Dice {

    private int number;
    private Random rand = new Random();

    /**
     * method creates a random number
     * @return number
     */
    public int rollDice (){
        number = (rand.nextInt(20)+1);
        return number;
    }
}
