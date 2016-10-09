package storage;

import creature.Creature;
import item.Gold;
import item.Weapon;
import map.Room;
import reader.Reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A container class that holds all game objects.
 * This class holds all game objects like creatures, rooms, weapons and gold.
 * Each room and creature object can be retrieved by its name.
 */
public class Storage {

    private Map<String, Creature> creature_Map = new HashMap<>();
    private Map<String, Gold> gold_Map = new HashMap<>();
    private Map<String, Weapon> weapon_Map = new HashMap<>();
    private Map<String, Room> room_Map = new HashMap<>();

    /**
     * Default constructor, reads configuration files and creates game objects.
     * @throws IOException Pass through of Exception received from Reader class.
     */
    public Storage() throws IOException {
        fill_weapon_map();
        fill_creature_map();
        fill_gold_map();
        fill_room_map();
    }

    /**
     * Reads weapons' configuration, creates objects and stores them in a Map.
     * @throws IOException Pass through of Exception received from Reader class.
     */
    private void fill_weapon_map() throws IOException {

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
                Weapon w = new Weapon(name, description, force);
                weapon_Map.put(name, w);
                counter = 0;
            }
            counter++;
        }
    }

    /**
     * Reads gold's configuration, creates objects and stores them in a Map.
     * @throws IOException Pass through of Exception received from Reader class.
     */
    private void fill_gold_map() throws IOException {

        List<String> items = Reader.read("gold.txt");
        int counter = 1;
        String name = "";
        String description = "";
        int amount = 0;
        for (String val : items) {
            switch (counter) {
                case 1:
                    name = val;
                    break;
                case 2:
                    description = val;
                    break;
                case 3:
                    amount = Integer.parseInt(val);
                    break;
            }

            if (counter == 3) {
                Gold g = new Gold(name, description, amount);
                gold_Map.put(name, g);
                counter = 0;
            }
            counter++;
        }
    }

    /**
     * Reads creatures' configuration, creates objects and stores them in a Map.
     * @throws IOException Pass through of Exception received from Reader class.
     */
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
                Creature c = new Creature(name, species, description, experience, hp, weapon_Map.get(weapon));
                creature_Map.put(name,c);
                counter =0;
            }
            counter++;
        }
    }

    /**
     * Reads room's configuration, creates objects and stores them in a Map.
     * @throws IOException If anything went wrong while reading or parsing the text file.
     */
    private void fill_room_map() throws IOException {
        List<String> data = Reader.read("rooms.txt");

        final int recordSize = 7;
        final int numRecords = data.size() / recordSize;
        Weapon weapon;
        Creature creature;
        Gold gold;
        if (data.size() != numRecords * recordSize) {
            throw new IOException("rooms.text has wrong number of entries.");
        }

        Room room;
        int index = 0;
        for (int i=0; i<numRecords; i++) {
            String name = data.get(index++);
            String roomN = data.get(index++);
            String roomE = data.get(index++);
            String roomS = data.get(index++);
            String roomW = data.get(index++);
            String description = data.get(index++);
            String content = data.get(index++);

            room = new Room(name, roomN, roomE, roomS, roomW, description);

            if (! content.contentEquals("none")) {
                if ((weapon = weapon_Map.get(content)) != null) {
                    room.storeWeapon(weapon);
                } else if ((creature = creature_Map.get(content)) != null) {
                    room.spawnCreature(creature);
                } else if ((gold = gold_Map.get(content)) != null) {
                    room.storeGold(gold);
                } else {
                    throw new IOException("Room " + name + " has undefined content.");
                }
            }
            room_Map.put(name, room);
        }

        room = room_Map.get("Entry");
        if (room == null) {
            throw new IOException("Unable to find entry to dungeon.");
        }
    }

    /**
     * Get the creature with the given name.
     * @param name name of the creature
     * @return the creature with the given name.
     */
    public Creature getCreature(String name){
        return creature_Map.get(name);
    }

    /**
     * Get the room with the given name.
     * @param name name of the room
     * @return the room with the given name.
     */
    public Room getRoom(String name) {
        return room_Map.get(name);
    }
}
