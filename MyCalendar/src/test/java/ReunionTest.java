import CalendarProject.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ReunionTest {

    @Test
    public void testDescription() {
        EventId id = EventId.generate();
        EventTitle titre = new EventTitle("Réunion Projet");
        EventDate date = new EventDate(LocalDateTime.of(2025, 3, 20, 9, 0));
        EventDuration duree = new EventDuration(60);
        EventPlace lieu = new EventPlace("Bureau 101");
        Participants participants = new Participants(Arrays.asList(new Participant("Alice"), new Participant("Bob")));
        Reunion reunion = new Reunion(id, titre, date, duree, lieu, participants);

        String expectedDescription = "Réunion : " + titre.toString() + " à " + lieu.toString() + " avec " + participants.toString();
        assertEquals(expectedDescription, reunion.description());
    }

    @Test
    public void testConflictsWithNonPeriodique() {
        EventId id1 = EventId.generate();
        EventTitle titre1 = new EventTitle("Réunion A");
        EventDate date1 = new EventDate(LocalDateTime.of(2025, 3, 20, 10, 0));
        EventDuration duree1 = new EventDuration(60);
        EventPlace lieu1 = new EventPlace("Salle A");
        Participants participants1 = new Participants(Arrays.asList(new Participant("Alice")));
        Reunion reunion1 = new Reunion(id1, titre1, date1, duree1, lieu1, participants1);

        EventId id2 = EventId.generate();
        EventTitle titre2 = new EventTitle("Réunion B");
        EventDate date2 = new EventDate(LocalDateTime.of(2025, 3, 20, 10, 30));
        EventDuration duree2 = new EventDuration(30);
        EventPlace lieu2 = new EventPlace("Salle B");
        Participants participants2 = new Participants(Arrays.asList(new Participant("Bob")));
        Reunion reunion2 = new Reunion(id2, titre2, date2, duree2, lieu2, participants2);

        assertTrue(reunion1.conflictsWith(reunion2));
    }
}
