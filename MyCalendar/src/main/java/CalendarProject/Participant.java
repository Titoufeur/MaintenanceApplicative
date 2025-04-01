package CalendarProject;

import java.util.Optional;

public final class Participant {
    private final String name;

    public Participant(String name) {
        this.name = Optional.ofNullable(name)
                .filter(n -> !n.trim().isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("Le nom du participant ne peut pas être null ou vide"));
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
