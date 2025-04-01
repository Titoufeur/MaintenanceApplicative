package CalendarProject;

import java.util.UUID;

public final class EventId {
    private final UUID value;

    private EventId(UUID value) {
        this.value = value;
    }

    public static EventId generate() {
        return new EventId(UUID.randomUUID());
    }

    public static EventId fromString(String s) {
        return new EventId(UUID.fromString(s));
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventId)) return false;
        EventId other = (EventId) o;
        return value.equals(other.value);
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
