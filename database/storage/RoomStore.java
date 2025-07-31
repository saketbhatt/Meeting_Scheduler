package database.storage;

import models.Room;

import java.util.HashMap;
import java.util.Map;

public final class RoomStore {
    private final Map<String, Room> rooms = new HashMap<>();

    private static volatile RoomStore INSTANCE;

    private RoomStore() {}

    public static RoomStore getRoomStore() {
        if (INSTANCE == null) {
            synchronized (RoomStore.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RoomStore();
                }
            }
        }
        return INSTANCE;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

     public void putRoom(String roomId, Room room) {
        rooms.put(roomId, room);
    }
}
