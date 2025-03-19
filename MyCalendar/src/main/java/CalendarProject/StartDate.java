package CalendarProject;

import java.time.LocalDateTime;

public final class StartDate {
    private final LocalDateTime startDate;
    private final int dureeMinutes;

    public StartDate(LocalDateTime value, int dureeMinutes) {
        if (value == null) {
            throw new IllegalArgumentException("La date de début ne peut pas être null");
        }
        if (dureeMinutes <= 0) {
            throw new IllegalArgumentException("La durée doit être positive");
        }
        this.startDate = value;
        this.dureeMinutes = dureeMinutes;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StartDate)) return false;
        StartDate that = (StartDate) o;
        return dureeMinutes == that.dureeMinutes &&
                startDate.equals(that.startDate);
    }

    @Override
    public int hashCode() {
        return 31 * startDate.hashCode() + dureeMinutes;
    }
}
