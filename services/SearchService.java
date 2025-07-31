package services;

import database.compute.MeetingStoreAccess;
import database.compute.RoomStoreAccess;
import models.Room;
import strategies.search.ISearchStrategy;

import java.util.*;
import constants.RoomType;

public class SearchService {
    private final RoomStoreAccess roomStoreAccess;
    private final ISearchStrategy searchStrategy;

    public SearchService(RoomStoreAccess roomStoreAccess, MeetingStoreAccess meetingStoreAccess, ISearchStrategy searchStrategy) {
        this.roomStoreAccess = roomStoreAccess;
        this.searchStrategy = searchStrategy;
    }

    public List<Room> searchRooms(RoomType type, Integer capacity, Date date, Integer startTime, Integer endTime) {
        List<Room> baseRooms = roomStoreAccess.searchRoom(type, null);
        return searchStrategy.search(baseRooms, capacity, date, startTime, endTime);
    }
}
