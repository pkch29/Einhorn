package dice;

import org.junit.Test;

/**
 * A test for the dice
 */
public class DiceTest {

    private Dice dice;

    @org.junit.Before
    public void setUp() throws Exception {
        dice = new Dice();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void distribution() throws Exception {
        int[] rolls = new int[21];
        for (int i=0; i<10000; i++) {
            rolls[0]++;
            rolls[dice.rollDice()]++;
        }
        int max = 0;
        for (int i=1; i<=20; i++) {
            if (rolls[i] > max) {
                max = rolls[i];
            }
        }
        System.out.printf("   %s\n", new String(new char[(int)(100*0.05*rolls[0]/max)]).replace("\0", "*"));
        for (int i=1; i<=20; i++) {
            int part = rolls[i]*100/max;
            System.out.printf("%2d %s\n", i, new String(new char[part]).replace("\0", "#"));
        }
    }
}
