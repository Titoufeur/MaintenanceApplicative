import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import CalendarProject.EventTitle;
import CalendarProject.EventPlace;

public class EventPlaceTest {

    @Test
    public void testValidPlace(){
        EventPlace place = new EventPlace("Paris");
        assertEquals("Paris", place.getValue());
    }

    @Test
    void testEmptyPlaceShouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new EventPlace("");
        });
        assertEquals("Le lieu ne peut pas être vide", exception.getMessage());
    }

    @Test
    void testNullPlaceShouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new EventPlace(null);
        });
        assertEquals("Le lieu ne peut pas être vide", exception.getMessage());
    }
}
