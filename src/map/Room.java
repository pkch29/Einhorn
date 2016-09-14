package map;

import creature.Creature;
import creature.Player;
import dice.Dice;
import item.Weapon;

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

        List<String> messages = new ArrayList<>();

        messages.add("You were attacked by the " + creature.getSpecies() + " " + creature.getName() + ".");
        messages.add(creature.getDescription());
        messages.add("");

        while (player.isAlive() && creature.isAlive()) {
            player.defend(creature.attack(dice.rollDice()));
            messages.add(creature.getName() + " rolled a " + dice.getNumber() + ". Your health is now " + player.getHP());
            if (player.isAlive()) {
                creature.defend(player.attack(dice.rollDice()));
                messages.add("You rolled a " + dice.getNumber() + ". " + creature.getName() + "'s health is now " + creature.getHP());
            }
        }

        messages.add("");
        if (player.isAlive()) {
            // TODO: 14.09.16 tell player that he just killed a creature of a certain level
//            player.killedCreature(creature.getLevel());
            messages.add("You survived using your " + player.getWeapon().getName() + ".");
        } else {
            messages.add("You were killed!");
        }

        return messages;
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
     * Gives the weapon (the current item in the room) to the player.
     * @param player the player that will receive the weapon.
     * @return list of messages to be shown to the player
     */
    public List<String> giveWeaponToPlayer(Player player) {
        List<String> messages = new ArrayList<>();
        messages.add("You found a " + weapon.getName() + " (" + weapon.getForce() + ")");
        messages.add(weapon.getDescription());
        // TODO: 13.09.16 player needs to decide if he wants the weapon
//        player.takeWeapon(this,item);
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
     * Spawns a given creature in the room.
     * The room image will show this creature.
     * This will replace a currently existing creature,
     * @param creature the creature to spawn in the room.
     */
    public void spawnCreature(Creature creature) {
        // TODO: 13.09.16 brauchen noch die echten Bilder hierfür. 
//        this.imageName = creature.getName() + ".jpg";
        this.imageName = DEFAULT_IMAGE;
        this.creature = creature;
        this.weapon = null;
    }

    /**
     * Stores a given weapon in the room.
     * This will replace a currently stored item.
     * @param weapon the weapon to store in the room.
     */
    public void storeWeapon(Weapon weapon) {
        System.out.println("Storing weapon " + weapon.getName());
        this.imageName = DEFAULT_IMAGE;
        this.weapon = weapon;
        this.creature = null;
    }

    /**
     * Take the weapon from the room
     * @return the item that was in the room
     */
    public Weapon takeWeapon() {
        Weapon weapon = this.weapon;
        this.weapon = null;
        return weapon;
    }

}
