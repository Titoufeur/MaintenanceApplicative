import CalendarProject.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CalendarManagerTest {

    @Test
    public void testAjouterEtAfficherEvenements() {
        CalendarManager calendar = new CalendarManager();

        // Ajout d'un RDV personnel
        EventId id1 = EventId.generate();
        EventTitle titre1 = new EventTitle("Consultation");
        EventDate date1 = new EventDate(LocalDateTime.of(2025, 3, 19, 14, 0));
        EventDuration duree1 = new EventDuration(30);
        PersonalMeeting rdv = new PersonalMeeting(id1, titre1, date1, duree1);
        calendar.ajouterEvenement(rdv);

        // Ajout d'une réunion
        EventId id2 = EventId.generate();
        EventTitle titre2 = new EventTitle("Réunion Projet");
        EventDate date2 = new EventDate(LocalDateTime.of(2025, 3, 20, 9, 0));
        EventDuration duree2 = new EventDuration(60);
        EventPlace lieu = new EventPlace("Bureau 101");
        Participants participants = new Participants(Arrays.asList(new Participant("Alice"), new Participant("Bob")));
        Reunion reunion = new Reunion(id2, titre2, date2, duree2, lieu, participants);
        calendar.ajouterEvenement(reunion);

        // Création d'une période couvrant ces événements
        EventDate periodStart = new EventDate(LocalDateTime.of(2025, 3, 18, 0, 0));
        EventDate periodEnd = new EventDate(LocalDateTime.of(2025, 3, 21, 23, 59));
        TimeInterval period = new TimeInterval(periodStart, periodEnd);

        List<Event> eventsInPeriod = calendar.getEvenementsDansPeriode(period);
        assertEquals(2, eventsInPeriod.size());
    }

    @Test
    public void testSupprimerEvenement() {
        CalendarManager calendar = new CalendarManager();

        // Ajout d'un RDV personnel
        EventId id = EventId.generate();
        EventTitle titre = new EventTitle("Consultation");
        EventDate date = new EventDate(LocalDateTime.of(2025, 3, 19, 14, 0));
        EventDuration duree = new EventDuration(30);
        PersonalMeeting rdv = new PersonalMeeting(id, titre, date, duree);
        calendar.ajouterEvenement(rdv);

        // Vérification qu'il est présent
        EventDate periodStart = new EventDate(LocalDateTime.of(2025, 3, 18, 0, 0));
        EventDate periodEnd = new EventDate(LocalDateTime.of(2025, 3, 21, 23, 59));
        TimeInterval period = new TimeInterval(periodStart, periodEnd);
        List<Event> eventsInPeriod = calendar.getEvenementsDansPeriode(period);
        assertEquals(1, eventsInPeriod.size());

        // Suppression de l'événement
        calendar.supprimerEvenement(id);
        eventsInPeriod = calendar.getEvenementsDansPeriode(period);
        assertEquals(0, eventsInPeriod.size());
    }
}
