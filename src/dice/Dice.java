package dice;


import java.util.Random;

public class Dice {


    private int number;
    Random rand = new Random();


    /**
     * Gets the number of this dice
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * method creates a random number
     */
    private void rollDice (){
        number = (rand.nextInt(20)+1);
    }
}
