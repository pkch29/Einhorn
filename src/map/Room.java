package map;

import creature.Creature;
import creature.Player;
import dice.Dice;
import item.Weapon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A room in the dangeon.
 * The room can house a creature, contain an item to be looted or hold some gold.
 * Connected rooms have to be called according to their coordinates "x-y". The first room the player enters,
 * has to be called "Entry". Use "none" if there is no room in this direction.
 */
@SuppressWarnings("WeakerAccess")
public class Room {

    public static final String ENTRY = "Entry";  // the name of the first room where the player starts
    public static final String NONE = "none";    // marker for connections that are dead ends
    // TODO: 13.09.16 default für leeren Gang
    public static final String DEFAULT_IMAGE = "Lothofiedus.jpg"; // default background image

    private final String name;
    private final String description;
    private final String roomNameNorth;
    private final String roomNameEast;
    private final String roomNameSouth;
    private final String roomNameWest;

    private Creature creature = null;
    private Weapon weapon = null;
	private String imageName;

    private boolean flagKilledCreature;
    private boolean flagTookGold;
    private boolean flagTookWeapon;

    /**
     * Constructor of a room.
     * @param name name of the room
     * @param roomNameNorth name of the room in the north
     * @param roomNameEast name of the room in the east
     * @param roomNameSouth name of the room in the south
     * @param roomNameWest name of the room in the west
     * @param description description of the room
     */
    public Room(String name, String roomNameNorth, String roomNameEast, String roomNameSouth, String roomNameWest,
                String description) {
        this.name = name;
        this.description = description;
        this.roomNameNorth = roomNameNorth;
        this.roomNameEast = roomNameEast;
        this.roomNameSouth = roomNameSouth;
        this.roomNameWest = roomNameWest;
        this.imageName = DEFAULT_IMAGE;
    }

    /**
     * Room will fight vs the player using the given dice
     * @param player the player who will handle the fight
     * @param dice a dice the player and creature have to use
     * @return list of messages to be shown to the player
     */
    public List<String> fightPlayer(Player player, Dice dice) {

        // TODO: 14.09.16 Debug output for fights
        System.out.printf("\n\nPlayer vs " + creature.getName() + "\n");
        System.out.printf("Player %2d          Creature %2d\n",
                player.getHP(), creature.getHP());

        List<String> messages = new ArrayList<>();

        messages.add("Du wurdest von " + creature.getName() + " angegriffen.");
        messages.add(creature.getDescription());
        messages.add("");

        while (player.isAlive() && creature.isAlive()) {
            int creatureAttack = creature.attack(dice.rollDice());
            int playerAttack = player.attack(dice.rollDice());
            int damage = Math.abs(creatureAttack - playerAttack);

//            if (playerAttack == creatureAttack) {
//                System.out.println("A draw ...");
//                continue;
//            }

            if (playerAttack < creatureAttack) {
                player.defend(damage);
            } else {
                creature.defend(damage);
            }
            System.out.printf("Player %2d : %2d     Creature %2d : %2d      %2d\n",
                    player.getHP(), playerAttack, creature.getHP(), creatureAttack,  damage);
        }

        messages.add("");
        if (player.isAlive()) {
            player.killedCreature();
            flagKilledCreature = true;
            messages.add("Du hast überlebt und steigst einen Level auf!");
        } else {
            messages.add("Du wurdest getötet!");
        }

        return messages;
    }

    /**
     * Find name of a valid image file
     * @return name of a valid image file
     */
    private String getImageFilename() {
        String fileName;
        if (hasCreature()) {
            // TODO: 13.09.16 brauchen noch die echten Bilder hierfür.
//            fileName = creature.getName() + ".jpg";
            fileName = DEFAULT_IMAGE;
        } else {
            fileName = DEFAULT_IMAGE;
        }
        return fileName;
    }

    /**
     * Gets a string describing the room.
     * @return the room's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the name of the room's image file
     * @return the name of the room's image file
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Gets the name of the room.
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name of the room in the given direction.
     * Direction is defined as integer, starting with 0 in the north, clockwise.
     * @param direction the direction to find the name of the room for.
     * @return name of the room in the given direction.
     */
    public String getRoomNameInDirection(int direction) {
        switch (direction) {
            case 0: return roomNameNorth;
            case 1: return roomNameEast;
            case 2: return roomNameSouth;
            default: return roomNameWest;
        }
    }

    /**
     * Gets the name of the weapon in the room
     * has to be called after hasWeapon();
     * @return name of the weapon in the room
     */
    public String getWeaponName() {
        if (hasWeapon()) {
            return weapon.getName();
        } else {
            return new String();
        }
    }

    /**
     * Gives the weapon (the current item in the room) to the player.
     * @param player the player that will receive the weapon.
     * @return list of messages to be shown to the player
     */
    public List<String> giveWeaponToPlayer(Player player) {
        List<String> messages = new ArrayList<>();
        messages.add("Du hast eine bessere Waffe gefunden: " + weapon.getName() + " (" + weapon.getForce() + ")");
        messages.add(weapon.getDescription());
        player.setWeapon(this.takeWeapon());
        return messages;
    }

    /**
     * Checks if the room has a creature in it.
     * @return whether the room has a creature in it
     */
    public boolean hasCreature() {
        return (creature != null) && creature.isAlive();
    }


    /**
     * Test if the room has gold in it
     * @return whether the room has gold in it
     */
    public boolean hasGold() {
        // TODO: 14.09.16 not yet implemented!
        return false;
    }

    /**
     * Checks if the room has a weapon in it.
     * @return whether the room has a weapon in it
     */
    public boolean hasWeapon() {
        return weapon != null;
    }

    /**
     * Tests if a room exists in the given direction.
     * @param direction the direction to find a room for.
     * @return if a room exists in the given direction.
     */
    public boolean hasRoomInDirection(int direction) {
        return ! getRoomNameInDirection(direction).contentEquals(NONE);
    }

    /**
     * Test if the weapon in the room is stronger than player's weapon
     * @param playerWeapon the weapon used by the player
     * @return whether the weapon in the room is stronger
     */
    public boolean hasStrongerWeapon(Weapon playerWeapon) {
        return (weapon.getForce() > playerWeapon.getForce());
    }

    /**
     * Test if creature was recently killed
     * @return whether creature was recently killed
     */
    public boolean isCreatureKilled() {
        return flagKilledCreature;
    }

    /**
     * Test if this room is the entrance.
     * @return whether this room is the entrance
     */
    public boolean isEntry() {
        return name.contentEquals(Room.ENTRY);
    }

    /**
     * Test if weapon was recently taken.
     * @return whether weapon was recently taken
     */
    public boolean isWeaponTaken() {
        return flagTookWeapon;
    }

    /**
     * Test if gold was recently taken
     * @return whether gold was recently taken
     */
    public boolean isGoldTaken() {
        return false;
    }


    /**
     * Reset the status flags
     */
    public void resetFlags() {
        flagKilledCreature = false;
        flagTookGold = false;
        flagTookWeapon = false;
    }

    /**
     * Spawns a given creature in the room.
     * The room image will show this creature.
     * This will replace a currently existing creature,
     * @param creature the creature to spawn in the room.
     */
    public void spawnCreature(Creature creature) {
        this.creature = creature;
        this.imageName = getImageFilename();
        this.weapon = null;
    }

    /**
     * Stores a given weapon in the room.
     * This will replace a currently stored item.
     * @param weapon the weapon to store in the room.
     */
    public void storeWeapon(Weapon weapon) {
        this.creature = null;
        this.imageName = getImageFilename();
        this.weapon = weapon;
    }

    /**
     * Take the weapon from the room
     * @return the item that was in the room
     */
    public Weapon takeWeapon() {
        Weapon weapon = this.weapon;
        this.weapon = null;
        flagTookWeapon = true;
        return weapon;
    }

}
