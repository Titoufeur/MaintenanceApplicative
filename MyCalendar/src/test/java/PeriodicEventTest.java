import CalendarProject.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class PeriodicEventTest {

    @Test
    public void testDescription() {
        EventId id = EventId.generate();
        EventTitle titre = new EventTitle("Maintenance");
        EventDate date = new EventDate(LocalDateTime.of(2025, 3, 21, 8, 0));
        EventDuration duree = new EventDuration(120);
        Frequency frequence = new Frequency(30);
        PeriodicEvent evenement = new PeriodicEvent(id, titre, date, duree, frequence);

        String expectedDescription = "Événement périodique : " + titre.toString() + " " + frequence.toString();
        assertEquals(expectedDescription, evenement.description());
    }

    @Test
    public void testOccursInPeriod() {
        // L'événement périodique commence le 21 mars 2025, se répète tous les 30 jours.
        EventId id = EventId.generate();
        EventTitle titre = new EventTitle("Maintenance");
        EventDate date = new EventDate(LocalDateTime.of(2025, 3, 21, 8, 0));
        EventDuration duree = new EventDuration(60);
        Frequency frequence = new Frequency(30);
        PeriodicEvent evenement = new PeriodicEvent(id, titre, date, duree, frequence);

        // Création d'une période qui devrait contenir une occurrence de l'événement.
        EventDate periodStart = new EventDate(LocalDateTime.of(2025, 4, 20, 0, 0));
        EventDate periodEnd = new EventDate(LocalDateTime.of(2025, 4, 22, 23, 59));
        TimeInterval period = new TimeInterval(periodStart, periodEnd);

        assertTrue(evenement.occursInPeriod(period));
    }
}
