import java.util.List;
import constants.RoomType;
import controllers.BookingController;
import controllers.SearchController;
import database.compute.MeetingStoreAccess;
import database.compute.RoomStoreAccess;
import models.Room;
import services.BookingService;
import services.SearchService;
import strategies.search.LexicographicalSearchStrategy;
import strategies.search.ISearchStrategy;

import java.util.Date;

public class MeetingScheduler {
    private final SearchController searchController;
    private final BookingController bookingController;

    public MeetingScheduler() {
        RoomStoreAccess roomAccess = new RoomStoreAccess();
        MeetingStoreAccess meetingAccess = new MeetingStoreAccess();

        ISearchStrategy searchStrategy = new LexicographicalSearchStrategy();
        SearchService searchService = new SearchService(roomAccess, meetingAccess, searchStrategy);

        BookingService bookingService = new BookingService(roomAccess, meetingAccess);

        this.searchController = new SearchController(searchService);
        this.bookingController = new BookingController(bookingService);
    }

    public List<Room> getAvailableRooms(RoomType roomType, Integer capacity, Date date, Integer startTime, Integer endTime) {
        return searchController.searchRooms(roomType, capacity, date, startTime, endTime);
    }

    public boolean bookRoom(String roomId, Date date, int startTime, int endTime, int numOfPeople) {
        return bookingController.bookRoom(roomId, date, startTime, endTime, numOfPeople);
    }
}
