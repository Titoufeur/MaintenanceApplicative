package CalendarProject;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        List<Participant> list = Collections.unmodifiableList(
                Objects.requireNonNull(participants, "La liste de participants ne peut pas être null"));
        this.participants = Optional.of(list)
                .filter(l -> !l.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("Il faut au moins un participant"));
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Participants)) return false;
        Participants that = (Participants) o;
        return participants.equals(that.participants);
    }

    @Override
    public int hashCode() {
        return participants.hashCode();
    }

    @Override
    public String toString() {
        return String.join(", ", participants.stream().map(Participant::toString).toArray(String[]::new));
    }
}
