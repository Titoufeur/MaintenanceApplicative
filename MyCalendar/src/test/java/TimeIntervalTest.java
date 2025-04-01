import CalendarProject.EventDate;
import CalendarProject.TimeInterval;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class TimeIntervalTest {

    @Test
    public void testValidTimeInterval() {
        EventDate start = new EventDate(LocalDateTime.of(2025, 3, 19, 10, 0));
        EventDate end = new EventDate(LocalDateTime.of(2025, 3, 19, 11, 0));
        TimeInterval interval = new TimeInterval(start, end);
        assertEquals(start, interval.getStart());
        assertEquals(end, interval.getEnd());
    }

    @Test
    public void testInvalidTimeIntervalThrowsException() {
        EventDate start = new EventDate(LocalDateTime.of(2025, 3, 19, 12, 0));
        EventDate end = new EventDate(LocalDateTime.of(2025, 3, 19, 11, 0));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeInterval(start, end);
        });
        assertEquals("La date de début doit être antérieure à la date de fin", exception.getMessage());
    }

    @Test
    public void testOverlappingIntervals() {
        EventDate start1 = new EventDate(LocalDateTime.of(2025, 3, 19, 10, 0));
        EventDate end1 = new EventDate(LocalDateTime.of(2025, 3, 19, 11, 0));
        TimeInterval interval1 = new TimeInterval(start1, end1);

        EventDate start2 = new EventDate(LocalDateTime.of(2025, 3, 19, 10, 30));
        EventDate end2 = new EventDate(LocalDateTime.of(2025, 3, 19, 11, 30));
        TimeInterval interval2 = new TimeInterval(start2, end2);

        assertTrue(interval1.overlaps(interval2));
    }

    @Test
    public void testNonOverlappingIntervals() {
        EventDate start1 = new EventDate(LocalDateTime.of(2025, 3, 19, 8, 0));
        EventDate end1 = new EventDate(LocalDateTime.of(2025, 3, 19, 9, 0));
        TimeInterval interval1 = new TimeInterval(start1, end1);

        EventDate start2 = new EventDate(LocalDateTime.of(2025, 3, 19, 9, 30));
        EventDate end2 = new EventDate(LocalDateTime.of(2025, 3, 19, 10, 30));
        TimeInterval interval2 = new TimeInterval(start2, end2);

        assertFalse(interval1.overlaps(interval2));
    }
}
