package CalendarProject;

import java.time.LocalDateTime;

public final class StartDate {
    private final LocalDateTime value;

    public StartDate(LocalDateTime value) {
        if (value == null) {
            throw new IllegalArgumentException("La date de début ne peut pas être null");
        }
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }
}
