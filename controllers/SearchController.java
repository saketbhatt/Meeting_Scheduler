package controllers;

import constants.RoomType;
import models.Room;
import services.SearchService;
import java.util.*;

public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    public List<Room> searchRooms(RoomType type, Integer capacity, Date date, Integer startTime, Integer endTime) {
        return searchService.searchRooms(type, capacity, date, startTime, endTime);
    }
}
