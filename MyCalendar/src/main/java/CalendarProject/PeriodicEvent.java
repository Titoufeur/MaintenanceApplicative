package CalendarProject;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public final class PeriodicEvent extends Event {
    private final Frequency frequency;

    public PeriodicEvent(EventId id, EventTitle titre, EventDate date, EventDuration duree, Frequency frequency) {
        super(id, titre, date, duree);
        this.frequency = frequency;
    }

    public Frequency getFrequence() {
        return frequency;
    }

    @Override
    public String description() {
        return "Événement périodique : " + titre.toString() + " " + frequency.toString();
    }

    // Pour les événements périodiques, on suppose qu'ils ne causent pas de conflit
    @Override
    public boolean conflictsWith(Event other) {
        return other.conflictsWithPeriodique(this);
    }

    @Override
    public boolean conflictsWithNonPeriodique(NonPeriodicEvent e) {
        return false;
    }

    @Override
    public boolean conflictsWithPeriodique(PeriodicEvent e) {
        return false;
    }

    @Override
    public boolean occursInPeriod(TimeInterval period) {
        LocalDateTime periodEnd = period.getEnd().getValue();
        // Génération d'un stream d'occurrences à partir de la date initiale, espacées par la fréquence
        return Stream.iterate(date.getValue(), d -> d.plusDays(frequency.getValue()))
                .limit(1000) // limite arbitraire pour éviter une boucle infinie
                .anyMatch(occurrence -> {
                    LocalDateTime occurrenceEnd = occurrence.plusMinutes(duree.getValue());
                    TimeInterval occurrenceInterval = new TimeInterval(new EventDate(occurrence), new EventDate(occurrenceEnd));
                    return occurrenceInterval.overlaps(period);
                });
    }
}
