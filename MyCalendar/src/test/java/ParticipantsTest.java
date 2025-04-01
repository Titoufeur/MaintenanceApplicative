import CalendarProject.Participant;
import CalendarProject.Participants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantsTest {

    @Test
    public void testValidParticipants() {
        List<Participant> list = new ArrayList<>();
        list.add(new Participant("Alice"));
        list.add(new Participant("Bob"));
        Participants participants = new Participants(list);
        assertEquals("Alice, Bob", participants.toString());
    }

    @Test
    public void testEmptyParticipantsThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Participants(new ArrayList<>());
        });
        assertEquals("Il faut au moins un participant", exception.getMessage());
    }

    @Test
    public void testNullParticipantsThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            new Participants(null);
        });
    }
}
