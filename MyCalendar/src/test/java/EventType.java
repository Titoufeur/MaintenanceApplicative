import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import CalendarProject.EventTitle;

public class EventType {

    @Test
    public void testValidType(){
        EventType ev = new EventType("REUNION");
        assertEquals("REUNION", ev.getValue());
    }

    @Test
    public void testExceptions(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new EventType("");
        });
        assertEquals("Le titre ne peut pas être vide", exception.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new EventTitle(null);
        });
        assertEquals("Le titre ne peut pas être null", exception2.getMessage());
    }
}
