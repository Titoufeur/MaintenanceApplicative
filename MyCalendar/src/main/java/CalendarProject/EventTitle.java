package CalendarProject;

import java.util.Optional;

public final class EventTitle {
    private final String value;

    public EventTitle(String value) {
        this.value = Optional.ofNullable(value)
                .filter(v -> !v.trim().isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("Le titre ne peut pas être null ou vide"));
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventTitle)) return false;
        EventTitle that = (EventTitle) o;
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
