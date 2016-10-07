package item;


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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gibt die Höhe des Goldschatzes wieder
     * @return die Höhe des Goldschatzes
     */
    public int getAmount() { return amount; }

}
