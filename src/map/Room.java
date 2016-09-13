package map;

import creature.Creature;
import creature.Player;
import dice.Dice;
import item.Item;

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

    private final String name;
    private final String description;
    private final String roomNameNorth;
    private final String roomNameEast;
    private final String roomNameSouth;
    private final String roomNameWest;

    private Creature creature = null;
    private Item item = null;
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
    }

    /**
     * Room will fight vs the player using the given dice
     * @param player the player who will handle the fight
     * @param dice a dice the player and creature have to use
     */
    public void fightPlayer(Player player, Dice dice) {
        // TODO: 12.09.16 Needs implementations in player and creature
        while (player.isAlive() && creature.isAlive()) {
            player.defend(creature.attack(dice.rollDice()));
            if (player.isAlive()) {
                creature.defend(player.attack(dice.rollDice()));
            }
        }
        // TODO: 13.09.16 this is just for debug reasons!
        System.out.println("Player was attacked by " + creature.getName() + " (" + creature.getSpecies() + ")");
        System.out.println("Player:   " + player.getHP());
        System.out.println("Creature: " + creature.getHP());
        if (player.isAlive()) {
            System.out.println("player killed " + creature.getName() + " using " + player.getItem().getName());
        }
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
     */
    public void giveWeaponToPlayer(Player player) {
        player.setItem(this.item);
    }

    /**
     * Checks if the room has a creature in it.
     * @return whether the room has a creature in it
     */
    public boolean hasCreature() {
        return creature != null;
    }

    /**
     * Checks if the room has an item in it.
     * @return whether the room has an item in it
     */
    public boolean hasItem() {
        return item != null;
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
     * Spawns a given creature in the room.
     * The room image will show this creature.
     * This will replace a currently existing creature,
     * @param creature the creature to spawn in the room.
     */
    public void spawnCreature(Creature creature) {
        this.imageName = creature.getName() + ".jpg";
        this.creature = creature;
        this.item = null;
    }

    /**
     * Stores a given item in the room.
     * This will replace a currently stored item.
     * @param item the item to store in the room.
     */
    public void storeItem(Item item) {
        // TODO: 11.09.16 korrekte Datei für Raum ohne Kreatur verwenden!
        this.imageName = "Raum.jpg";
        this.item = item;
        this.creature = null;
    }

}
