package item;


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

    /**
     * Sets name of the item
     * @param name of item
     */
    void setName(String name);

    /**
     * Sets description of the item
     * @param description of item
     */
    void setDescription(String description);

}


