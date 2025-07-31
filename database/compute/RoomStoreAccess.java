package database.compute;

import constants.RoomType;
import database.storage.RoomStore;
import models.Room;

import java.util.*;
import java.util.stream.Collectors;

public class RoomStoreAccess {
    private final RoomStore roomStore = RoomStore.getRoomStore();

    public void addRoom(Room room) {
        roomStore.putRoom(room.id, room);
    }

    public Optional<Room> getRoomById(String id) {
        return Optional.ofNullable(roomStore.getRooms().get(id));
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(roomStore.getRooms().values());
    }

    public List<Room> searchRoom(RoomType type, Integer capacity) {
        return roomStore.getRooms().values().stream()
                .filter(r -> (type == null || r.type == type))
                .filter(r -> (capacity == null || r.capacity >= capacity))
                .sorted(Comparator.comparing(room -> room.id))
                .collect(Collectors.toList());
    }
}
