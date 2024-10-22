package dice;

import org.junit.Test;

/**
 * A test for the dice
 */
@SuppressWarnings("FieldCanBeLocal")
public class DiceTest {

    private Dice dice;
    private final int numRolls = 100; // order of magnitude of dice rolls needed in the game.

    @org.junit.Before
    public void setUp() throws Exception {
        dice = new Dice();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    /**
     * Roll the dice several times and show some statistics.
     * Result will usually be better for higher number of rolls.
     * The low number (100 as default) is chosen to visualize unequal distribution.
     */
    @Test
    public void distribution() {
        int[] rolls = new int[21];
        System.out.println("Rolling " + numRolls + " dices D20 ...");
        for (int i=0; i<numRolls; i++) {
            rolls[0]++;
            rolls[dice.rollDice()]++;
        }
        int max = 0;
        for (int i=1; i<=20; i++) {
            if (rolls[i] > max) {
                max = rolls[i];
            }
        }

        // mathematical expected number of rolls
        int mean = (int)(0.05*rolls[0] * 100/max);
        System.out.printf("   %s\n", new String(new char[mean]).replace("\0", "*"));
        for (int i=1; i<=20; i++) {
            int part = rolls[i] *100/max;
            System.out.printf("%2d %s%s    %+2d%%\n", i, new String(new char[part]).replace("\0", "#"),
                    new String(new char[100-part]).replace("\0", " "), part-mean);
        }
    }
}
