package item;

/**
 * Gold class for any treasure in the game.
 */
public class Gold implements Item{

    private String name;
    private String description;
    private int amount;

    /**
     * Default constructor for gold
     * @param name name of the treasure
     * @param description a sentence describing the treasure
     * @param amount amount of gold in the treasure
     */
    public Gold(String name, String description, int amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString(){
        return " the " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Get the amount of gold in the treasure.
     * @return the amount of gold in the treasure.
     */
    public int getAmount() { return amount; }

}
