package CalendarProject;

import java.util.Optional;

public final class TimeInterval {
    private final EventDate start;
    private final EventDate end;

    public TimeInterval(EventDate start, EventDate end) {
        this.start = start;
        this.end = end;
        Optional.of(start.getValue())
                .filter(s -> s.isBefore(end.getValue()))
                .orElseThrow(() -> new IllegalArgumentException("La date de début doit être antérieure à la date de fin"));
    }

    public EventDate getStart() {
        return start;
    }

    public EventDate getEnd() {
        return end;
    }

    public boolean overlaps(TimeInterval other) {
        return start.getValue().isBefore(other.end.getValue()) && end.getValue().isAfter(other.start.getValue());
    }

    @Override
    public String toString() {
        return "De " + start.toString() + " à " + end.toString();
    }
}
