package map;

import creature.Creature;
import item.Item;

/**
 * A room in the dangeon.
 * The room can house a creature and can have an item to be looted.
 */
@SuppressWarnings("WeakerAccess")
public class Room {

    private Creature creature = null;
    private Item item = null;
	private final String imageName;
	private final String description;

    /**
     * Constructor for a room with image and description.
     * @param imageName the name of the image file for this room
     * @param description a string describing the room
     */
	public Room(String imageName, String description) {
	    this.imageName = imageName;
        this.description = description;
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
