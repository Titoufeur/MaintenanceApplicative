import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class StartDateTest {

    @Test
    public void testValidStartDate() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 19, 12, 0);
        StartDate startDate = new StartDate(dateTime);
        // Vérifie que la valeur stockée est bien celle passée en paramètre.
        assertEquals(dateTime, startDate.getValue(), "La valeur de startDate doit correspondre à la date fournie");
    }

    @Test
    public void testNullStartDateShouldThrowException() {
        // Vérifie que le constructeur lève une exception si la date est null.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StartDate(null);
        });
        assertEquals("La date de début ne peut pas être null", exception.getMessage());
    }
}
