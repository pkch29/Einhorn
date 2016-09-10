package item;


public class Item {

    private String name;
    private String description;
    private int force;

    public Item(String name, String description, int force) {
        this.name = name;
        this.description = description;
        this.force = force;
    }

    /**
     * Turns the object name into a String
     * @return item name
     */
    public String toString(){
        return name;
    }

    /**
     * Gets item name
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets description of the item
     * @return description of item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the force points
     * @return force points
     */
    public int getForce() {
        return force;
    }

    /**
     * Sets name of the item
     * @param name of item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets description of the item
     * @param description of item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the force points
     * @param force points
     */
    public void setForce(int force) {
        this.force = force;
    }
}
