
package models;

import constants.RoomType;

public class Room {
    public String id;
    public RoomType type;
    public int capacity;

    public Room(String id, RoomType type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }
}
