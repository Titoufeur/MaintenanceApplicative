package CalendarProject;

public abstract class Event {
    protected final EventId id;
    protected final EventTitle titre;
    protected final EventDate date;
    protected final EventDuration duree;

    public Event(EventId id, EventTitle titre, EventDate date, EventDuration duree) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.duree = duree;
    }

    public EventId getId() {
        return id;
    }

    public EventTitle getTitre() {
        return titre;
    }

    public EventDate getDate() {
        return date;
    }

    public EventDuration getDuree() {
        return duree;
    }

    // On calcule l'intervalle de temps à partir de la date et de la durée
    public TimeInterval getTimeInterval() {
        EventDate end = new EventDate(date.getValue().plusMinutes(duree.getValue()));
        return new TimeInterval(date, end);
    }

    public abstract String description();

    // Détection des conflits par double dispatch
    public abstract boolean conflictsWith(Event other);
    public abstract boolean conflictsWithNonPeriodique(NonPeriodicEvent e);
    public abstract boolean conflictsWithPeriodique(PeriodicEvent e);

    // Vérifie si l'événement se produit dans la période donnée
    public abstract boolean occursInPeriod(TimeInterval period);
}
