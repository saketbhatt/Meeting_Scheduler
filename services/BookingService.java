
package services;

import database.compute.MeetingStoreAccess;
import database.compute.RoomStoreAccess;
import models.Meeting;
import models.Room;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class BookingService {
    private final RoomStoreAccess roomStoreAccess;
    private final MeetingStoreAccess meetingStoreAccess;

    public BookingService(RoomStoreAccess roomAccess, MeetingStoreAccess meetingAccess) {
        this.roomStoreAccess = roomAccess;
        this.meetingStoreAccess = meetingAccess;
    }

    public boolean bookMeeting(String roomId, Date date, int startTime, int endTime, int participants) {
        Optional<Room> roomOpt = roomStoreAccess.getRoomById(roomId);
        if (roomOpt.isEmpty()) return false;

        Room room = roomOpt.get();
        if (participants > room.capacity) return false;

        if (!meetingStoreAccess.isRoomAvailable(roomId, date, startTime, endTime)) return false;

        Meeting meeting = new Meeting(UUID.randomUUID().toString(), roomId, date, startTime, endTime, participants);
        meetingStoreAccess.addMeeting(meeting);
        return true;
    }
}
