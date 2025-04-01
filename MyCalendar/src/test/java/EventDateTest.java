import CalendarProject.EventDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class EventDateTest {

    @Test
    public void testValidDateEvenement() {
        LocalDateTime dt = LocalDateTime.of(2025, 3, 19, 12, 0);
        EventDate dateEvenement = new EventDate(dt);
        assertEquals(dt, dateEvenement.getValue());
    }

    @Test
    public void testNullDateThrowsException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new EventDate(null);
        });
        assertEquals("La date de l'événement ne peut pas être null", exception.getMessage());
    }
}
