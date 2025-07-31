package strategies.search;

import models.Room;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LexicographicalSearchStrategy implements ISearchStrategy {

    @Override
    public List<Room> search(List<Room> rooms, Integer capacity, Date date, Integer startTime, Integer endTime) {
        return rooms.stream()
                .filter(r -> capacity == null || r.capacity >= capacity)
                .sorted(Comparator.comparing(r -> r.id))
                .collect(Collectors.toList());
    }
}
