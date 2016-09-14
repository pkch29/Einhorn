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
        messages = new ArrayList<>();
        initGame();
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
                messages.add("");
                messages.add("Try again. You are back at the entry!");
                newGame();
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
        return room.hasRoomInDirection(player.getBackDirection());
    }

    @Override
    public boolean hasCreature() {
        return room.hasCreature();
    }

    @Override
    public boolean hasLeft() {
        return room.hasRoomInDirection(player.getLeftDirection());
    }

    @Override
    public boolean hasGold() {
        return room.hasGold();
    }

    @Override
    public boolean hasRight() {
        return room.hasRoomInDirection(player.getRightDirection());
    }

    @Override
    public boolean hasStraight() {
        return room.hasRoomInDirection(player.getStraightDirection());
    }

    @Override
    public boolean hasWeapon() {
        return room.hasWeapon();
    }

    /**
     * Initializes the game parameters
     */
    private void initGame() {
        dice = new Dice();
        try {
            storage = new Storage();
        } catch (IOException e) {
            // @TODO: 10.09.16 tell gui to tell user that the config files are messed up.
            e.printStackTrace();
        }
        // TODO: 13.09.16 default HP for player!
//        player = new Player("Player", 1, 18);
        player = new Player(storage.getCreature("You"));
//        player.setItem(storage.getItem("Hand"));
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
