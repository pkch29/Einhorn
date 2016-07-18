package map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomInfoTest {

    Room room;
    RoomInfo info;

    @Before
    public void setUp() throws Exception {
        room = new Room("imageFile.jpg", "description");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    /**
     * Test if on creation the correct data is stored
     */
    public void creation() throws Exception {
        info = new RoomInfo(room);
        assertEquals(info.getRoom(), room);
        assertNull(info.getConnectedRoomId(0));
        assertNull(info.getConnectedRoomId(1));
        assertNull(info.getConnectedRoomId(2));
        assertNull(info.getConnectedRoomId(3));

        info = new RoomInfo(room, 1,2,3,4);
        assertEquals(info.getRoom(), room);
        assertEquals(info.getConnectedRoomId(0).intValue(), 1);
        assertEquals(info.getConnectedRoomId(1).intValue(), 2);
        assertEquals(info.getConnectedRoomId(2).intValue(), 3);
        assertEquals(info.getConnectedRoomId(3).intValue(), 4);
    }

    @Test
    /**
     * Test if the normalization works correctly
     * i.e.: room in direction -1 should be same as room in direction 3
     */
    public void normalization() throws Exception {
        info = new RoomInfo(room, 1,2,3,4);
        assertEquals(info.getConnectedRoomId(-4), info.getConnectedRoomId(0));
        assertEquals(info.getConnectedRoomId(-3), info.getConnectedRoomId(1));
        assertEquals(info.getConnectedRoomId(-2), info.getConnectedRoomId(2));
        assertEquals(info.getConnectedRoomId(-1), info.getConnectedRoomId(3));

        assertEquals(info.getConnectedRoomId(4), info.getConnectedRoomId(0));
        assertEquals(info.getConnectedRoomId(5), info.getConnectedRoomId(1));
        assertEquals(info.getConnectedRoomId(6), info.getConnectedRoomId(2));
        assertEquals(info.getConnectedRoomId(7), info.getConnectedRoomId(3));
    }

    @Test
    /**
     * Test if the new connection is correct
     */
    public void connecting() throws Exception {
        info = new RoomInfo(room);
        info.connect(0, 1);
        info.connect(1, 2);
        info.connect(2, 3);
        info.connect(3, 4);
        assertEquals(info.getConnectedRoomId(0).intValue(), 1);
        assertEquals(info.getConnectedRoomId(1).intValue(), 2);
        assertEquals(info.getConnectedRoomId(2).intValue(), 3);
        assertEquals(info.getConnectedRoomId(3).intValue(), 4);

        info = new RoomInfo(room);
        info.connect(-4, 1);
        info.connect(-3, 2);
        info.connect(-2, 3);
        info.connect(-1, 4);
        assertEquals(info.getConnectedRoomId(0).intValue(), 1);
        assertEquals(info.getConnectedRoomId(1).intValue(), 2);
        assertEquals(info.getConnectedRoomId(2).intValue(), 3);
        assertEquals(info.getConnectedRoomId(3).intValue(), 4);

        info = new RoomInfo(room);
        info.connect(4, 1);
        info.connect(5, 2);
        info.connect(6, 3);
        info.connect(7, 4);
        assertEquals(info.getConnectedRoomId(0).intValue(), 1);
        assertEquals(info.getConnectedRoomId(1).intValue(), 2);
        assertEquals(info.getConnectedRoomId(2).intValue(), 3);
        assertEquals(info.getConnectedRoomId(3).intValue(), 4);
    }





}