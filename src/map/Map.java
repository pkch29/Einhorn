package map;

import java.util.List;


/**
 * Main class that implements the GuiConnect to communicate with the fx components.
 */
public class Map implements gui.GuiConnect {

    List<Room> rooms;
    //List<int[4]> connections;


    @Override
    public void goBack() {

    }

    @Override
    public void goStraight() {

    }

    @Override
    public void goLeft() {

    }

    @Override
    public void goRight() {

    }

    @Override
    public boolean hasStraight() {
        return false;
    }

    @Override
    public boolean hasLeft() {
        return false;
    }

    @Override
    public boolean hasRight() {
        return false;
    }

    @Override
    public void newGame() {

    }

    @Override
    public int[] getStats() {
        return new int[0];
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public String getRoom() {
        return null;
    }

    @Override
    public List<String> showAndWait() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
}
