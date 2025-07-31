package strategies.search;

import models.Room;

import java.util.Date;
import java.util.List;

public interface ISearchStrategy {
    List<Room> search(List<Room> rooms, Integer capacity, Date date, Integer startTime, Integer endTime);
}
