package CalendarProject;

import java.util.Optional;

public final class EventDuration {
    private final int value;

    public EventDuration(int value) {
        this.value = Optional.of(value)
                .filter(v -> v > 0)
                .orElseThrow(() -> new IllegalArgumentException("La durée doit être positive"));
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventDuration)) return false;
        EventDuration that = (EventDuration) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return value + " minutes";
    }
}
