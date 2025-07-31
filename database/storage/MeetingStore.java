package database.storage;

import models.Meeting;

import java.util.ArrayList;
import java.util.List;

public final class MeetingStore {
    private final List<Meeting> meetings = new ArrayList<>();

    private static volatile MeetingStore INSTANCE;

    private MeetingStore() {}

    public static MeetingStore getMeetingStore() {
        if (INSTANCE == null) {
            synchronized (MeetingStore.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MeetingStore();
                }
            }
        }
        return INSTANCE;
    }

    public List<Meeting> getAllMeetings() {
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }
}
