package map;

import creature.Player;
import storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Main class that implements the GuiConnect to communicate with the fx components.
 */
public class Map implements gui.GuiConnect {

    private Storage storage;
    private ArrayList<RoomInfo> rooms;
    private int currentRoomId;
    private Player player;


    public Map() {
        player = new Player("John Doe", 0, 100);
//        try {
//            storage = new Storage();
//        } catch (IOException e) {
//            // @TODO: 10.09.16 tell gui to tell user that the config files are messed up.
//            e.printStackTrace();
//        }
    }


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

    @Override
    public String[] getStats() {
        //@TODO: 10.09.16 player needs to implement getStats according to GuiConnect interface
        //return player.getStats();
        String[] stats = new String[4];
        stats[0] = player.getName();
        stats[1] = Integer.toString(player.getHP());
        stats[2] = Integer.toString(player.getLevel());
        stats[3] = "no item yet"; //player.getItem().getName();
        return stats;
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
    public String getHelp() {
        return "This is probably a general help text.";
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
    public void setPlayerName(String name) {
         player.setName(name);
    }

    private void initGame() {
        rooms = new ArrayList<>();
        currentRoomId = 0;
        generateTorus();
    }


    private void generateTorus() {
        Room room = new Room("Lothofiedus.jpg", "Der sich wiederholende Standard-Raum");
        RoomInfo info = new RoomInfo(room, 0, 0, 0, 0);
        rooms.add(info);
    }


}
