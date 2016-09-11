package map;

import creature.Creature;
import item.Item;

/**
 * A room in the dangeon.
 * The room can house a creature, contain an item to be looted or hold some gold.
 */
@SuppressWarnings("WeakerAccess")
public class Room {

    private final String name;
    private final String description;
    private final String roomN;
    private final String roomE;
    private final String roomS;
    private final String roomW;

    private Creature creature = null;
    private Item item = null;
	private String imageName;

    /**
     * Constructor of a room.
     * @param name name of the room
     * @param roomN name of the room in the north
     * @param roomE name of the room in the east
     * @param roomS name of the room in the south
     * @param roomW name of the room in the west
     * @param description description of the room
     */
    public Room(String name, String roomN, String roomE, String roomS, String roomW, String description) {
        this.name = name;
        this.description = description;
        this.roomN = roomN;
        this.roomE = roomE;
        this.roomS = roomS;
        this.roomW = roomW;
    }

    /**
     * Gets the name of the room in the given direction.
     * Direction is defined as integer, starting with 0 in the north, clockwise.
     * @param direction the direction to find the name of the room for.
     * @return name of the room in the given direction.
     */
    public String getRoomNameInDirection(int direction) {
        switch (direction) {
            case 0: return roomN;
            case 1: return roomE;
            case 2: return roomS;
            default: return roomW;
        }
    }


    /**
     * Tests if a room exists in the given direction.
     * @param direction the direction to find a room for.
     * @return if a room exists in the given direction.
     */
    public boolean hasRoomInDirection(int direction) {
        return ! getRoomNameInDirection(direction).contentEquals("none");
    }


    /**
     * Gets the name of the room's image file
     * @return the name of the room's image file
     */
	public String getImageName() {
		return imageName;
	}

    /**
     * Gets a string describing the room.
     * @return the room's description
     */
	public String getDescription() {
		return description;
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
