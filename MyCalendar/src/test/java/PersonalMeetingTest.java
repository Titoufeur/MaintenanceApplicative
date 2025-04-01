import CalendarProject.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class PersonalMeetingTest {

    @Test
    public void testDescription() {
        EventId id = EventId.generate();
        EventTitle titre = new EventTitle("Consultation");
        EventDate date = new EventDate(LocalDateTime.of(2025, 3, 19, 14, 0));
        EventDuration duree = new EventDuration(30);
        PersonalMeeting rdv = new PersonalMeeting(id, titre, date, duree);
        String expectedDescription = "RDV : " + titre.toString() + " à " + date.toString() + " pendant " + duree.toString();
        assertEquals(expectedDescription, rdv.description());
    }

    @Test
    public void testConflictsWithNonPeriodique() {
        EventId id1 = EventId.generate();
        EventTitle titre1 = new EventTitle("RDV 1");
        EventDate date1 = new EventDate(LocalDateTime.of(2025, 3, 19, 10, 0));
        EventDuration duree1 = new EventDuration(60);
        PersonalMeeting rdv1 = new PersonalMeeting(id1, titre1, date1, duree1);

        EventId id2 = EventId.generate();
        EventTitle titre2 = new EventTitle("RDV 2");
        EventDate date2 = new EventDate(LocalDateTime.of(2025, 3, 19, 10, 30));
        EventDuration duree2 = new EventDuration(30);
        PersonalMeeting rdv2 = new PersonalMeeting(id2, titre2, date2, duree2);

        assertTrue(rdv1.conflictsWith(rdv2));
    }
}
