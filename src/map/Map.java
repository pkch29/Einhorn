package map;

import java.util.ArrayList;
import java.util.List;


/**
 * Main class that implements the GuiConnect to communicate with the fx components.
 */
public class Map implements gui.GuiConnect {

    private ArrayList<RoomInfo> rooms;
    private int currentRoomId;
    //private Player player;


    @Override
    public void goBack() {
        int playerOrientation = 0; //player.getOrientation();
        go(playerOrientation+2);
    }

    @Override
    public void goStraight() {
        int playerOrientation = 0; //player.getOrientation();
        go(playerOrientation);
    }

    @Override
    public void goLeft() {
        int playerOrientation = 0; //player.getOrientation();
        go(playerOrientation-1);
    }

    @Override
    public void goRight() {
        int playerOrientation = 0; //player.getOrientation();
        go(playerOrientation+1);
    }

    private void go(int direction) {
        //@TODO user always has to make sure that the direction exists!
        // currently here is an additional check, but as there is no feedback given,
        // its quite useless.
        if (!rooms.get(currentRoomId).hasDoor(direction)) {
            return;
        }

        //@TODO maybe some checks if we can leave?
        // maybe we can only go backwards if there is still a creature in the room

        currentRoomId = rooms.get(currentRoomId).getConnectedRoomId(direction);
    }

    @Override
    public boolean hasStraight() {
        int playerOrientation = 0; //player.getOrientation();
        return rooms.get(currentRoomId).hasDoor(playerOrientation);
    }

    @Override
    public boolean hasLeft() {
        int playerOrientation = 0; //player.getOrientation();
        return rooms.get(currentRoomId).hasDoor(playerOrientation - 1);
    }

    @Override
    public boolean hasRight() {
        int playerOrientation = 0; //player.getOrientation();
        return rooms.get(currentRoomId).hasDoor(playerOrientation + 1);
    }

    @Override
    public void newGame() {
        initGame();
    }

    @Override
    public int[] getStats() {
        return new int[0];
    }

    @Override
    public String getHelp() {
        return "This is probably a general help text.";
    }

    @Override
    public String getRoom()
    {
        return null;
    }

    @Override
    public String getRoomImageFileName() {
        return rooms.get(currentRoomId).getRoom().getImageName();
    }

    @Override
    public String getRoomDescription() {
        return rooms.get(currentRoomId).getRoom().getDescription();
    }


    @Override
    public List<String> showAndWait() {
        return null;
    }

    @Override
    public void setName(String name) {
        // player.setName(name);
    }

    private void initGame() {
        rooms = new ArrayList<>();
        currentRoomId = 0;
        generateTorus();
    }


    private void generateTorus() {
        Room room = new Room("room.jpg", "Der sich wiederholende Standard-Raum");
        RoomInfo info = new RoomInfo(room, 0, 0, 0, 0);
        rooms.add(info);
    }


}
