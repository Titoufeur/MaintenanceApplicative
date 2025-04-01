import CalendarProject.Participant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParticipantTest {

    @Test
    public void testValidParticipant() {
        Participant participant = new Participant("Alice");
        assertEquals("Alice", participant.getName());
    }

    @Test
    public void testNullParticipantThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Participant(null);
        });
        assertEquals("Le nom du participant ne peut pas être null ou vide", exception.getMessage());
    }

    @Test
    public void testEmptyParticipantThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Participant(" ");
        });
        assertEquals("Le nom du participant ne peut pas être null ou vide", exception.getMessage());
    }
}
