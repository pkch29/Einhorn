package item;

/**
 * Interface for Items, declares basic methods needed for items that can be stored in a room.
 */
public interface Item {

    /**
     * Turns the object name into a String
     * @return item name
     */
    String toString();

    /**
     * Gets item name
     * @return item name
     */
    String getName();

    /**
     * Gets description of the item
     * @return description of item
     */
    String getDescription();

}


