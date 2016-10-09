package map;

import creature.Creature;
import creature.Player;
import dice.Dice;
import item.Gold;
import item.Weapon;
import messenger.GermanMessenger;
import messenger.Messenger;
import org.junit.Test;

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
    private final String roomDescription = "roomDescription";
    private final String roomDefaultImageFileName = Room.DEFAULT_IMAGE;

    private final String weaponName = "weaponName";
    private final String weaponDescription = "weaponDescription";
    private final int    weaponForce = 10;

    private final String creatureName = "creatureName";
    private final String creatureSpecies = "CreatureSpecies";
    private final String creatureDescription = "creaturDescription";
    private final int    creatureHp = 20;
    private final int    creatureLevel = 3;

    private final String goldName = "goldName";
    private final String goldDescription = "goldDescription";
    private final int    goldAmount = 100;

    private Room room;
    private Creature creature;
    private Creature beast;
    private Gold gold;
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
        gold = new Gold(goldName, goldDescription, goldAmount);
        messenger = new GermanMessenger();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    /**
     * Test static methods
     * normalizeDirection:
     *   normalizes a direction to the interval [0, 3]
     * @throws Exception Default exception for Assert.*
     */
    @Test
    public void staticMethods() throws Exception {
        int[] num = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        int[] direction = {3,0,1,2,3,0,1,2,3,0,1};
        for (int i=0; i<11; i++) {
            assertEquals(Room.normalizeDirection(num[i]),direction[i]);
        }
    }

    /**
     * Test getters
     *  all getters used for room, creature, weapon and gold
     * @throws Exception Default exception for Assert.*
     */
    @Test
    public void getters() throws Exception {
        assertEquals(room.getDescription(), roomDescription);
        assertEquals(room.getImageName(), roomDefaultImageFileName);
        assertEquals(room.getName(), roomName);
        assertEquals(room.getRoomNameInDirection(0), roomNorth);
        assertEquals(room.getRoomNameInDirection(1), roomEast);
        assertEquals(room.getRoomNameInDirection(2), roomSouth);
        assertEquals(room.getRoomNameInDirection(3), roomWest);
        room.spawnCreature(creature);
        assertEquals(room.getCreatureDescription(), creatureDescription);
        assertEquals(room.getCreatureName(), creatureName);
        assertEquals(room.getCreatureSpecies(), creatureSpecies);
        assertEquals(room.getCreatureWeaponName(), weaponName);
        room.storeWeapon(weapon);
        assertEquals(room.getWeaponName(), weaponName);
        assertEquals(room.getWeaponDescription(), weaponDescription);
        assertEquals(room.getItemName(), weaponName);
        room.storeGold(gold);
        assertEquals(room.getTreasureName(), goldName);
        assertEquals(room.getTreasureDescription(), goldDescription);
    }

    /**
     * Test spawning of creature
     * @throws Exception Default exception for Assert.*
     */
    @Test
    public void creature() throws Exception {
        // remove creature by storing a wepaon
        room.storeWeapon(weapon);
        assertEquals(room.hasCreature(), false);
        room.spawnCreature(creature);
        assertEquals(room.hasCreature(), true);
    }

    /**
     * Test storing a weapon
     * Stores a weapon and gives the weapon to the player
     * @throws Exception Default exception for Assert.*
     */
    @Test
    public void weapon() throws Exception {
        // remove weapon by spawning a creature
        room.spawnCreature(creature);
        assertEquals(room.hasWeapon(), false);
        room.storeWeapon(weapon);
        assertEquals(room.hasWeapon(), true);
        room.giveWeaponToPlayer(messenger, player);
        assertEquals(room.hasWeapon(), false);
        assertEquals(player.getWeapon(), weapon);
    }

    /**
     * Test if room knows neighbouring rooms
     * @throws Exception Default exception for Assert.*
     */
    @Test
    public void directions() throws Exception {
        assertEquals(room.hasRoomInDirection(0), true);
        assertEquals(room.hasRoomInDirection(1), false);
        assertEquals(room.hasRoomInDirection(2), true);
        assertEquals(room.hasRoomInDirection(3), true);
    }

    /**
     * Test fighting.
     * Simulates two (unfair) fights. First fight will be won
     * by the player, second one by the creature.
     * @throws Exception Default exception for Assert.*
     */
    @Test
    public void fighting() throws Exception {
        room.storeWeapon(strongWeapon);
        room.giveWeaponToPlayer(messenger, player);
        room.spawnCreature(creature);
        creature.defend(creature.getHP()-1);
        while(player.isAlive() && creature.isAlive()) {
            room.attackCreature(messenger, player, dice);
        }
        assertEquals(player.isAlive(), true);
        assertEquals(creature.isAlive(), false);

        room.storeWeapon(weapon);
        room.giveWeaponToPlayer(messenger, player);
        room.spawnCreature(beast);
        player.defend(player.getHP()-1);
        while(player.isAlive() && beast.isAlive()) {
            room.attackCreature(messenger, player, dice);
        }
        assertEquals(player.isAlive(), false);
        assertEquals(beast.isAlive(), true);
    }

}