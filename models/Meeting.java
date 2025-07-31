
package models;

import java.util.Date;

public class Meeting {
    public String id;
    public String roomId;
    public Date date;
    public int startTime;
    public int endTime;
    public int participants;

    public Meeting(String id, String roomId, Date date, int startTime, int endTime, int participants) {
        this.id = id;
        this.roomId = roomId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.participants = participants;
    }
}
