package map;

import creature.Player;
import dice.Dice;
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
    private Dice dice = null;
    private List<String> messages;

    public Map() {
        player = new Player("John Doe", 0, 100);
        dice = new Dice();
        try {
            storage = new Storage();
        } catch (IOException e) {
            // @TODO: 10.09.16 tell gui to tell user that the config files are messed up.
            e.printStackTrace();
        }
        messages = new ArrayList<>();
        messages.add("OMFG a creature! RUUUUUNNNNNNNN.....");
    }

    /**
     * Enters a room and handles action (loot, attack)
     * @param room the room the player is going to enter.
     */
    private void enterRoom(Room room) {
        this.room = room;
        if (room.hasItem()) {
            lootWeapon();
        } else if (room.hasCreature()) {
            fightCreature();
            // TODO: 12.09.16 Needs isAlive in player class.
//            if (player.isAlive()) {
//                // TODO: 12.09.16 give some feedback to the player, that he won and can proceed.
//            } else {
//                // TODO: 12.09.16 Game is lost!
//            }
        }
    }

    /**
     * Fight the creature in the room
     */
    private void fightCreature() {
        room.fightPlayer(player, dice);
    }

    @Override
    public String getHelp() {
        return "This is probably a general help text.";
    }

    @Override
    public String getRoomDescription() {
        return room.getDescription();
    }

    @Override
    public String getRoomImageFileName() {
        return room.getImageName();
    }

    @Override
    public String[] getStats() {
//        //@TODO: 10.09.16 player needs to implement getStats according to GuiConnect interface
//        return player.getStats();
        // TODO: 13.09.16 player has no item in the beginning! -> player.getStats() crashes
        String[] stats = new String[4];
        stats[0] = player.getName();
        stats[1] = Integer.toString(player.getHP());
        stats[2] = Integer.toString(player.getLevel());
        stats[3] = "no item yet"; //player.getItem().getName();
        return stats;
    }

    @Override
    public void goBack() {
        // TODO: 11.09.16 player needs to implement getRoomInDirection
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goBack())));
//        enterRoom(storage.getRoom(room.getRoomNameInDirection(2)));
    }

    @Override
    public void goLeft() {
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goLeft())));
//        enterRoom(storage.getRoom(room.getRoomNameInDirection(3)));
    }

    @Override
    public void goRight() {
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goRight())));
//        enterRoom(storage.getRoom(room.getRoomNameInDirection(1)));
    }

    @Override
    public void goStraight() {
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goStraight())));
//        enterRoom(storage.getRoom(room.getRoomNameInDirection(0)));
    }

    @Override
    public boolean hasBack() {
        // TODO: 12.09.16 player needs to implement getBackDirection()
//        return room.hasRoomInDirection(player.getBackDirection());
        return room.hasRoomInDirection(2);
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
    public boolean hasStraight() {
        // TODO: 11.09.16 player needs to implement getStraightDirection()
//        return room.hasRoomInDirection(player.getStraightDirection());
        return room.hasRoomInDirection(0);
    }

    /**
     * Initializes the game parameters
     */
    private void initGame() {
        room = storage.getRoom(Room.ENTRY);
    }

    /**
     * Player can loot the weapon in the room.
     */
    private void lootWeapon() {
        boolean doLoot = true;
        // TODO: 12.09.16 Interact with the player and set doLoot accordingly
        if (doLoot) {
            room.giveWeaponToPlayer(player);
        }
    }

    @Override
    public void newGame() {
        initGame();
    }

    @Override
    public void setPlayerName(String name) {
        player.setName(name);
    }

    @Override
    public List<String> showAndWait()
    {
        return messages;
    }

}
