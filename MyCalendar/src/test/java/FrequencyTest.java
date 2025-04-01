import CalendarProject.Frequency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FrequencyTest {

    @Test
    public void testValidFrequence() {
        Frequency frequence = new Frequency(7);
        assertEquals(7, frequence.getValue());
    }

    @Test
    public void testZeroFrequenceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Frequency(0);
        });
        assertEquals("La fréquence doit être positive", exception.getMessage());
    }

    @Test
    public void testNegativeFrequenceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Frequency(-3);
        });
        assertEquals("La fréquence doit être positive", exception.getMessage());
    }
}
