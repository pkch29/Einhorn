package item;


public class Gold implements Item{

    private String name;
    private String description;

    public Gold(String name, String description) {
        this.name = name;
        this.description = description;
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
}
