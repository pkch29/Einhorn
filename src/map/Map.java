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

    private Storage storage = null;
    private Player player = null;
    private Room room = null;

    public Map() {
        player = new Player("John Doe", 0, 100);
        try {
            storage = new Storage();
        } catch (IOException e) {
            // @TODO: 10.09.16 tell gui to tell user that the config files are messed up.
            e.printStackTrace();
        }
    }

    @Override
    public void goBack() {
        // TODO: 11.09.16 player needs to implement getRoomInDirection
//        room = storage.getRoom(room.getRoomNameInDirection(player.goBack()));
        room = storage.getRoom(room.getRoomNameInDirection(2));
    }

    @Override
    public void goStraight() {
//        room = storage.getRoom(room.getRoomNameInDirection(player.goStraight()));
        room = storage.getRoom(room.getRoomNameInDirection(0));
    }

    @Override
    public void goLeft() {
//        room = storage.getRoom(room.getRoomNameInDirection(player.goLeft()));
        room = storage.getRoom(room.getRoomNameInDirection(3));
    }

    @Override
    public void goRight() {
//        room = storage.getRoom(room.getRoomNameInDirection(player.goRight()));
        room = storage.getRoom(room.getRoomNameInDirection(1));
    }

    @Override
    public String[] getStats() {
//        //@TODO: 10.09.16 player needs to implement getStats according to GuiConnect interface
//        return player.getStats();
        String[] stats = new String[4];
        stats[0] = player.getName();
        stats[1] = Integer.toString(player.getHP());
        stats[2] = Integer.toString(player.getLevel());
        stats[3] = "no item yet"; //player.getItem().getName();
        return stats;
    }

    @Override
    public boolean hasStraight() {
        // TODO: 11.09.16 player needs to implement getStraightDirection()
//        return room.hasRoomInDirection(player.getStraightDirection());
        return room.hasRoomInDirection(0);
    }

    @Override
    public boolean hasLeft() {
        // TODO: 11.09.16 player needs to implement getLeftDirection()
//        return room.hasRoomInDirection(player.getLeftDirection());
        return room.hasRoomInDirection(3);
    }

    @Override
    public boolean hasRight() {
        // TODO: 11.09.16 player needs to implement getRightDirection()
//        return room.hasRoomInDirection(player.getRightDirection());
        return room.hasRoomInDirection(1);
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
        return room.getImageName();
    }

    @Override
    public String getRoomDescription() {
        return room.getDescription();
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
        room = storage.getRoom("Entry");
    }



}
