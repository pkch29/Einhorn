package map;

import creature.Player;
import dice.Dice;
import messenger.GermanMessenger;
import messenger.Messenger;
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
    private Messenger messenger = null;

    private boolean flagGameIsWon = false;

    /**
     * Constructor
     * Most variables get instantiated by a call to newGame from the GUI
     */
    public Map() {
        messenger = new GermanMessenger();
        messages = messenger.getMessages();
    }

    /**
     * Enters a room and handles action (loot, attack).
     * This is the main method which is called after a direction was choosen.
     * @param room the room the player is going to enter.
     */
    private void enterRoom(Room room) {
        room.resetFlags();
        this.room = room;
        player.healing();
        if (room.isEntry() && player.hasTreasure()) {
            messenger.playerWon();

            flagGameIsWon = true;
            return;
        }
//        if (room.hasWeapon()) {
//            lootWeapon();
//        } else if (room.hasCreature()) {
//            fightCreature();
//            if (! isPlayerAlive()) {
//                messages.add("GAME OVER - Du hast verloren!");
//                messages.add("");
//                messages.add("Versuch es nochmal.");
//                messages.add("Du befindest Dich wieder frisch und munter am Eingang.");
//                newGame();
//            }
//        }
    }

    @Override
    public List<String> fight() {
        room.attackCreature(messenger, player, dice);
        return messages;
//        fightCreature();
    };

    /**
     * Fight the creature in the room
     */
//    private void fightCreature() {
//        messages.addAll(room.fightPlayer(player, dice));
//    }

    @Override
    public String getHelp() {
        return "Finde das Schwert und töte Gothofiedus,\ntöte dann Grodagrim und hole die Lanze.\n"
                + "Jetzt suche den Schatz ...\nund verlasse das Verlies.";
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
    public String getWeaponName() {
        return room.getWeaponName();
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

    @Override
    public boolean isCreatureKilled() {
        return room.isCreatureKilled();
    }

    @Override
    public boolean isGameWon()  {
        return flagGameIsWon;
    }

    @Override
    public boolean isGoldTaken() {
        return room.isGoldTaken();
    }

    @Override
    public boolean isWeaponTaken() {
        return room.isWeaponTaken();
    }

    /**
     * Checks if player is still alive
     * @return if player is alive
     */
    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    @Override
    public void newGame() {
        flagGameIsWon = false;
        dice = new Dice();
        try {
            storage = new Storage();
        } catch (IOException e) {
            // @TODO: 10.09.16 tell gui to tell user that the config files are messed up.
            e.printStackTrace();
        }
        Player prevPlayer = player;
        player = new Player(storage.getCreature("You"));
        if (prevPlayer != null) {
            player.setName(prevPlayer.getName());
        }
        room = storage.getRoom(Room.ENTRY);
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

    @Override
    public void takeWeapon() {
        room.giveWeaponToPlayer(player);
    }

}
