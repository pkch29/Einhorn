package map;

import creature.Creature;
import item.Item;

/**
 * A room in the dangeon.
 * The room can house a creature and can have an item to be looted.
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
     * Constructor for a room with image and description.
     * @param imageName the name of the image file for this room
     * @param description a string describing the room
     * @warning opsolete! should not be used, will be removed soon.
     */
	public Room(String imageName, String description) {
	    this.imageName = imageName;
        this.description = description;

        this.name = "";
        this.roomN = "";
        this.roomE = "";
        this.roomS = "";
        this.roomW = "";
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
     * Checks if the room can be looted.
     * A room can only be looted if there is an item and if
     * there is no living creature in the room.
     * @return whether the room can be looted.
     */
    public boolean canBeLooted() {
        return !(hasCreature() && creature.isAlive() || !hasItem());
    }

    /**
     * Loot the room.
     * If the room can be looted, return the room's item
     * and remove item from the room.
     * @return the item that was in the room.
     */
    public Item lootRoom() {
        Item loot = null;
        if (canBeLooted()) {
            loot = item;
            item = null;
        }
        return loot;
    }

    /**
     * Spawns a given creature in the room.
     * This will replace a currently existing creature,
     * @param creature the creature to spawn in the room.
     */
    public void spawnCreature(Creature creature) {
        this.creature = creature;
    }

    /**
     * Stores a given item in the room.
     * This will replace a currently stored item.
     * @param item the item to store in the room.
     */
    public void storeItem(Item item) {
        this.item = item;
    }

}
