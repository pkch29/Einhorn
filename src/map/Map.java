package map;

import creature.Player;
import dice.Dice;
import messenger.GermanMessenger;
import messenger.Messenger;
import storage.Storage;

import java.io.IOException;
import java.util.List;

/**
 * Map class that implements the GuiConnect to communicate with the fx components.
 * It is responsible to coordinate Player, Storage and Rooms.
 */
@SuppressWarnings("WeakerAccess")
public class Map implements gui.GuiConnect {

    private Dice dice = null;
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
    }

    /**
     * Enters a room.
     * This is the main method which is called after a direction was choosen.
     * If player leaves a room with a creature, the player will not heal.
     * @param room the room the player is going to enter.
     */
    private void enterRoom(Room room) {
        if (! this.room.hasCreature()) {
            player.healing();
        }
        this.room = room;
        this.room.resetFlags();
        this.room.selectImageName(player.getStraightDirection());
        if (isVictoryConditionFulfilled()) {
            messenger.playerWon();
            flagGameIsWon = true;
            return;
        }
        if (room.hasWeapon()) {
            messenger.roomHasWeapon(room.getWeaponName(), room.getWeaponDescription(), room.getWeaponForce());
        } else if (room.hasCreature()) {
            messenger.roomHasCreature(room.getCreatureName(), room.getCreatureDescription(),
                    room.getCreatureSpecies(), room.getCreatureWeaponName());
        } else if (room.hasGold()) {
            // TODO: 9/22/16 Treasure still missing
            messenger.roomHasTreasure("Treasure", "Treasure description");
        } else {
            messenger.roomIsEmpty();
        }
    }

    @Override
//    public void fight() {
    public List<String> fight() {
        room.attackCreature(messenger, player, dice);
        // TODO: 9/21/16 GUIController should change the method logic similar to the other methods and get the messages from showAnfWait as well.
        return messenger.getMessages();
    };
    
    @Override
    // TODO: 9/21/16 should return a void and generate messages. Probably needs other name.
//    public void getHelp(){}
    public String getHelp() {
        messenger.help();
        // TODO: 9/21/16 GUIController should get the messages as usual.
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

    /**
     * Test is victory condition is fullfilled
     * @return whether victory condition is fullfilled
     */
    private boolean isVictoryConditionFulfilled() {
        return room.isEntry() && player.hasTreasure();
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
        resetGameFlags();
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

    /**
     * Reset all game flags.
     */
    private void resetGameFlags() {
        flagGameIsWon = false;
    }

    @Override
    public void setPlayerName(String name) {
        player.setName(name);
    }

    @Override
    public List<String> showAndWait()
    {
        return messenger.getMessages();
    }

    @Override
    public void takeWeapon() {
        room.giveWeaponToPlayer(player);
    }

}
