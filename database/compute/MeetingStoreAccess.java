package database.compute;

import database.storage.MeetingStore;
import models.Meeting;

import java.util.*;
import java.util.stream.Collectors;

import static utils.TruncateToDate.truncateToDate;

public class MeetingStoreAccess {
    private final MeetingStore meetingStore = MeetingStore.getMeetingStore();

    private void cleanupExpiredMeetings() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);
        Date today = truncateToDate(now);

        meetingStore.getAllMeetings().removeIf(m ->
            m.date.before(today) ||
            (m.date.equals(today) && m.endTime <= currentHour)
        );
    }

    private List<Meeting> findByRoomAndDate(String roomId, Date date) {
        cleanupExpiredMeetings();
        return meetingStore.getAllMeetings().stream()
                .filter(m -> m.roomId.equals(roomId) && m.date.equals(date))
                .collect(Collectors.toList());
    }

    public void addMeeting(Meeting meeting) {
        cleanupExpiredMeetings();
        meetingStore.addMeeting(meeting);
    }

    public boolean isRoomAvailable(String roomId, Date date, int startTime, int endTime) {
        return findByRoomAndDate(roomId, date).stream()
                .noneMatch(m -> !(endTime <= m.startTime || startTime >= m.endTime));
    }
}
