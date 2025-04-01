package CalendarProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CalendarManager {
    private final List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvenement(Event e) {
        events.add(e);
    }

    public List<Event> getEvenementsDansPeriode(TimeInterval period) {
        return events.stream()
                .filter(e -> e.occursInPeriod(period))
                .collect(Collectors.toList());
    }

    public boolean conflit(Event e1, Event e2) {
        return e1.conflictsWith(e2);
    }

    public void supprimerEvenement(EventId id) {
        events.removeIf(e -> e.getId().equals(id));
    }

    public void afficherEvenements() {
        events.forEach(e -> System.out.println(e.description()));
    }
}
