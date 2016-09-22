package map;

import creature.Creature;
import creature.Player;
import dice.Dice;
import item.Item;
import item.Weapon;
import messenger.GermanMessenger;
import messenger.Messenger;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test for class Room
 */
@SuppressWarnings("ConstantConditions, FieldCanBeLocal")
public class RoomTest {

    private final String roomName = "room";
    private final String roomNorth = "1-2";
    private final String roomEast = Room.NONE;
    private final String roomSouth = Room.ENTRY;
    private final String roomWest = "3-4";
    private final String roomDescription = "description";
    private final String roomDefaultImageFileName = "Lothofiedus.jpg";

    private final String weaponName = "weapon";
    private final String weaponDescription = "description";
    private final int    weaponForce = 10;

    private final String creatureName = "name";
    private final String creatureSpecies = "species";
    private final String creatureDescription = "description";
    private final int    creatureHp = 20;
    private final int    creatureLevel = 3;

    private final String playerName = "name";
    private final int    playerLevel = 1;
    private final int    playerHp = 10;

    private Room room;
    private Creature creature;
    private Creature beast;
    private Weapon weapon;
    private Weapon strongWeapon;
    private Player player;
    private Dice dice;
    private Messenger messenger;

    @org.junit.Before
    public void setUp() throws Exception {
        weapon = new Weapon(weaponName, weaponDescription, weaponForce);
        strongWeapon = new Weapon(weaponName, weaponDescription, weaponForce+1);
        creature = new Creature(creatureName, creatureSpecies, creatureDescription, creatureHp, creatureLevel, weapon);
        beast = new Creature(creatureName, creatureSpecies, creatureDescription, creatureHp, creatureLevel+10, strongWeapon);
        room = new Room(roomName, roomNorth, roomEast, roomSouth, roomWest, roomDescription);
        player = new Player(creature);
        dice = new Dice();
        messenger = new GermanMessenger();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void staticMethods() throws Exception {
        int[] num = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        int[] mod = {3,0,1,2,3,0,1,2,3,0,1};
        for (int i=0; i<11; i++) {
            assertEquals(room.normalizeDirection(num[i]),mod[i]);
        }
    }

    @Test
    public void getters() throws Exception {
        assertEquals(room.getDescription(), roomDescription);
        assertEquals(room.getImageName(), roomDefaultImageFileName);
        assertEquals(room.getName(), roomName);
        assertEquals(room.getRoomNameInDirection(0), roomNorth);
        assertEquals(room.getRoomNameInDirection(1), roomEast);
        assertEquals(room.getRoomNameInDirection(2), roomSouth);
        assertEquals(room.getRoomNameInDirection(3), roomWest);
    }

    @Test
    public void creature() throws Exception {
        room.storeWeapon(weapon);
        assertEquals(room.hasCreature(), false);
        room.spawnCreature(creature);
        assertEquals(room.hasCreature(), true);
    }

    @Test
    public void weapon() throws Exception {
        room.spawnCreature(creature);
        assertEquals(room.hasWeapon(), false);
        room.storeWeapon(weapon);
        assertEquals(room.hasWeapon(), true);
        room.takeWeapon();
        assertEquals(room.hasWeapon(), false);
        room.storeWeapon(strongWeapon);
        room.giveWeaponToPlayer(player);
        assertEquals(room.hasWeapon(), false);
        assertEquals(player.getWeapon(), strongWeapon);
    }

    @Test
    public void directions() throws Exception {
        assertEquals(room.hasRoomInDirection(0), true);
        assertEquals(room.hasRoomInDirection(1), false);
        assertEquals(room.hasRoomInDirection(2), true);
        assertEquals(room.hasRoomInDirection(3), true);
    }

    @Test
    public void fighting() throws Exception {
        room.storeWeapon(strongWeapon);
        room.giveWeaponToPlayer(player);
        room.spawnCreature(creature);
        creature.setHp(1);
        player.setHp(Integer.MAX_VALUE);
        while(player.isAlive() && creature.isAlive()) {
            room.attackCreature(messenger, player, dice);
        }
        assertEquals(player.isAlive(), true);
        assertEquals(creature.isAlive(), false);

        room.storeWeapon(weapon);
        room.giveWeaponToPlayer(player);
        room.spawnCreature(beast);
        beast.setHp(Integer.MAX_VALUE);
        player.setHp(1);
        while(player.isAlive() && beast.isAlive()) {
            room.attackCreature(messenger, player, dice);
        }
        assertEquals(player.isAlive(), false);
        assertEquals(beast.isAlive(), true);
    }


}