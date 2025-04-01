package CalendarProject;

import java.util.Optional;

public final class EventPlace {
    private final String value;

    public EventPlace(String value) {
        this.value = Optional.ofNullable(value)
                .filter(v -> !v.trim().isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("Le lieu ne peut pas être null ou vide"));
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventPlace)) return false;
        EventPlace that = (EventPlace) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
