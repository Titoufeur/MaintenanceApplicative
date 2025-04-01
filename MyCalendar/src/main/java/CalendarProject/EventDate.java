package CalendarProject;

import java.time.LocalDateTime;
import java.util.Objects;

public final class EventDate {
    private final LocalDateTime value;

    public EventDate(LocalDateTime value) {
        this.value = Objects.requireNonNull(value, "La date de l'événement ne peut pas être null");
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventDate)) return false;
        EventDate that = (EventDate) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
