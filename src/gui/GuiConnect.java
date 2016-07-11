package gui;

import java.util.List;

/**
 * Creates connection between GUI and Game classes
 */
public interface GuiConnect {
    public void goStraight();
    public void goLeft();
    public void goRight();
    public void goBack();
    public boolean hasStraight();
    public boolean hasLeft();
    public boolean hasRight();
    public void newGame();
    public int[] getStats();
    public String getHelp();
    public String getRoom();
    public List<String> showAndWait();
    public void setName(String name);

}
