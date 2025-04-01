import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import CalendarProject.EventTitle;

class EventTitleTest {

    @Test
    void testValidTitre() {
        EventTitle titre = new EventTitle("Event 1");
        assertEquals("Event 1", titre.getValue());
    }

    @Test
    void testEmptyTitreShouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new EventTitle("");
        });
        assertEquals("Le titre ne peut pas être null", exception.getMessage());
    }

    @Test
    void testNullTitreShouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new EventTitle(null);
        });
        assertEquals("Le titre ne peut pas être null", exception.getMessage());
    }
}
