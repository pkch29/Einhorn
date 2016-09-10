package storage;

import creature.Creature;
import item.Item;
import reader.Reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 10.09.2016..
 */
public class Storage {

    private Map<String, Creature> creature_Map = new HashMap<>();
    private Map<String, Item> item_Map = new HashMap<>();

    public Storage() throws IOException {
        fill_item_map();
        fill_creature_map();
    }

    private void fill_item_map() throws IOException {

        List<String> items = Reader.read("weapons.txt");
        int counter = 1;
        String name = "";
        int force = 0;
        String description = "";
        for (String val : items) {
            switch (counter) {
                case 1:
                    name = val;
                    break;
                case 2:
                    force = Integer.parseInt(val);
                    break;
                case 3:
                    description = val;
                    break;
            }

            if (counter == 3) {
                Item i = new Item(name, description, force);
                item_Map.put(name, i);
                counter = 0;
            }
            counter++;

        }


    }

    private void fill_creature_map() throws IOException {

        List<String> creatures = Reader.read("creatures.txt");
        int counter = 1;
        String name = "";
        int hp = 0;
        String weapon = "";
        int experience = 0;
        String species = "";
        String description = "";
        for (String val : creatures) {
            switch (counter) {
                case 1:
                    name = val;
                    break;
                case 2:
                    species = val;
                    break;
                case 3:
                    description = val;
                    break;
                case 4:
                    experience = Integer.parseInt(val);
                    break;
                case 5:
                    hp = Integer.parseInt(val);
                    break;
                case 6:
                    weapon = val;
                    break;
            }
            if (counter == 6) {
                Creature c = new Creature(name, species, description, experience, hp, item_Map.get(weapon));
                creature_Map.put(name,c);
                counter =0;
            }
            counter++;

        }

    }

    public Creature getCreature(String name){

        return creature_Map.get(name);
    }
    public Item getItem(String name){

        return item_Map.get(name);
    }
}
