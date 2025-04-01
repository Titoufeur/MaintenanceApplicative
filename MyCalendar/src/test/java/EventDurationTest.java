import CalendarProject.EventDuration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EventDurationTest {

    @Test
    public void testValidDuree() {
        EventDuration duree = new EventDuration(60);
        assertEquals(60, duree.getValue());
    }

    @Test
    public void testZeroDureeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new EventDuration(0);
        });
        assertEquals("La durée doit être positive", exception.getMessage());
    }

    @Test
    public void testNegativeDureeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new EventDuration(-10);
        });
        assertEquals("La durée doit être positive", exception.getMessage());
    }
}
