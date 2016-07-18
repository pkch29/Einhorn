package map;

/**
 * This class holds information about how a room is connected to other rooms.
 */
@SuppressWarnings("WeakerAccess")
public class RoomInfo {
    private Room room = null;
    private Integer[] connections = new Integer[4];

    /**
     * Store a room that is not connected to any other room.
     * @param room the room to store
     */
    public RoomInfo(Room room) {
        this(room, null, null, null, null);
    }

    /**
     * Store a rooom that is connected to other rooms
     * @param room the room to store
     * @param northRoomId the id of the room in the north
     * @param eastRoomId the id of the room in the east
     * @param southRoomId the id of the room in the south
     * @param westRoomId the id of the room in the west
     */
    public RoomInfo(Room room, Integer northRoomId, Integer eastRoomId, Integer southRoomId, Integer westRoomId) {
        this.room = room;
        connections[0] = northRoomId;
        connections[1] = eastRoomId;
        connections[2] = southRoomId;
        connections[3] = westRoomId;
    }

    /**
     * Gets the stored room.
     * @return the stored room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Gets the id of the room connected in the given connection.
     * The direction will be normalized to interval [0..3]
     * @param direction the direction to lookup for a room
     * @return the id of the room in the given direction, or null
     */
    public Integer getConnectedRoomId(int direction) {
        return connections[normalizeDirection(direction)];
    }

    /**
     * Connects a given room in the given direction
     * @param direction the direction to connect the given room to
     * @param roomId id of the room to connect to in the given direction
     */
    public void connect(int direction, Integer roomId) {
        connections[normalizeDirection(direction)] = roomId;
    }

    /**
     * Maps a given direction (integer) to the interval [0..3]
     * g in [0..3], k, d: integer, d = g + k*4
     * normalizedDirection(d) = g
     * @param direction a direction to normalize
     * @return the normalized direction
     */
    private static int normalizeDirection(int direction) {
        int dir = direction % 4;
        return dir < 0 ? 4 + dir : dir;
    }
}
