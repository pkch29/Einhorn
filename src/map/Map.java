package map;

import creature.Player;
import dice.Dice;
import storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Map class that implements the GuiConnect to communicate with the fx components.
 * It is responsible to coordinate Player, Storage and Rooms.
 */
@SuppressWarnings("WeakerAccess")
public class Map implements gui.GuiConnect {

    private Dice dice = null;
    private List<String> messages = null;
    private Player player = null;
    private Room room = null;
    private Storage storage = null;

    public Map() {
        dice = new Dice();
        try {
            storage = new Storage();
        } catch (IOException e) {
            // @TODO: 10.09.16 tell gui to tell user that the config files are messed up.
            e.printStackTrace();
        }
        player = new Player("Player", 1, 18);
        player.setItem(storage.getItem("Hand"));
        messages = new ArrayList<>();
    }

    /**
     * Enters a room and handles action (loot, attack).
     * This is the main method which is called after a direction was choosen.
     * @param room the room the player is going to enter.
     */
    private void enterRoom(Room room) {
        this.room = room;
        messages.clear();
        if (room.hasWeapon()) {
            lootWeapon();
        } else if (room.hasCreature()) {
            fightCreature();
            if (! isPlayerAlive()) {
                messages.add("GAME OVER!");
            }
        }
    }

    /**
     * Fight the creature in the room
     */
    private void fightCreature() {
        messages.addAll(room.fightPlayer(player, dice));
    }

    @Override
    public String getHelp() {
        return "This is a general help text.";
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
        return player.getStats();
    }

    @Override
    public void goBack() {
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goBack())));
    }

    @Override
    public void goLeft() {
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goLeft())));
    }

    @Override
    public void goRight() {
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goRight())));
    }

    @Override
    public void goStraight() {
        enterRoom(storage.getRoom(room.getRoomNameInDirection(player.goStraight())));
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
     * Checks if player is still alive
     * @return if player is alive
     */
    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    /**
     * Player can loot the weapon in the room.
     */
    private void lootWeapon() {
        if (room.hasStrongerWeapon(player.getItem())) {
            messages.addAll(room.giveWeaponToPlayer(player));
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
