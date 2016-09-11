package map;

import creature.Creature;
import item.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Room
 */
@SuppressWarnings("ConstantConditions")
public class RoomTest {

    private Room room;
    private Creature creature;
    private Item item;

    private String imageFileName = "imagefile.jpg";
    private String description = "Description";

    @org.junit.Before
    public void setUp() throws Exception {
        // create room
        room = new Room("name", "1-2", "3-4", "Entry", "none", description);

        // create creature
        String creatureName = "name";
        String creatureSpecies = "species";
        String creatureDescription = "description";
        int creatureHp = 10;
        int creatureLevel = 1;
        Item creatureItem = null;
        creature = new Creature(creatureName, creatureSpecies, creatureDescription,
                creatureHp, creatureLevel, creatureItem);

        // create item
        // @// TODO: 10.09.16 Item test still missing.
        //item = new Item();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void creation() throws Exception {
        assertEquals(room.getImageName(), imageFileName);
        assertEquals(room.getDescription(), description);
        assertEquals(room.hasCreature(), false);
        assertEquals(room.hasItem(), false);
        // room can not be looted, as there is no item in it.
//        assertEquals(room.canBeLooted(), false);
//        assertEquals(room.lootRoom(), null);
    }


    @Test
    public void creature() throws Exception {
        room.spawnCreature(creature);
        assertEquals(room.hasCreature(), true);
    }


    @Test
    public void item() throws Exception {
        room.storeItem(item);
        assertEquals(room.hasItem(), true);
    }

    @Test
    public void loot() throws Exception {
        room.storeItem(item);
//        assertEquals(room.canBeLooted(), true); // item, but no creature
//        assertEquals(room.lootRoom(), item);

        room.spawnCreature(creature);
//        assertEquals(room.canBeLooted(), false); // item and creature that is alive

        //@TODO: kill creature and test for looting
        //killCreature();
        //assertEquals(room.canBeLooted(), true); // item and dead creature
    }


}