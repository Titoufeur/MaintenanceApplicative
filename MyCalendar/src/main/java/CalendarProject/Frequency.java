package CalendarProject;

import java.util.Optional;

public final class Frequency {
    private final int value;

    public Frequency(int value) {
        this.value = Optional.of(value)
                .filter(v -> v > 0)
                .orElseThrow(() -> new IllegalArgumentException("La fréquence doit être positive"));
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Frequency)) return false;
        Frequency that = (Frequency) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return "tous les " + value + " jours";
    }
}
