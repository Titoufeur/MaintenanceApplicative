import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import CalendarProject.StartDate;

public class StartDateTest {

    @Test
    public void testValidStartDateAndDuration() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 19, 12, 0);
        int dureeMinutes = 90; // Exemple de durée positive
        StartDate startDate = new StartDate(dateTime, dureeMinutes);
        assertEquals(dateTime, startDate.getStartDate(), "La date doit correspondre à celle fournie");
        assertEquals(dureeMinutes, startDate.getDureeMinutes(), "La durée doit correspondre");
    }

    @Test
    public void testNullStartDateShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StartDate(null, 90);
        });
        assertEquals("La date de début ne peut pas être null", exception.getMessage());
    }

    @Test
    public void testNegativeDurationShouldThrowException() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 19, 12, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StartDate(dateTime, -10);
        });
        assertEquals("La durée doit être positive", exception.getMessage());
    }

    @Test
    public void testZeroDurationShouldThrowException() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 19, 12, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StartDate(dateTime, 0);
        });
        assertEquals("La durée doit être positive", exception.getMessage());
    }
}
