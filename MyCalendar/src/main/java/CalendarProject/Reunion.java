package CalendarProject;

public final class Reunion extends Event implements NonPeriodicEvent {
    private final EventPlace eventPlace;
    private final Participants participants;

    public Reunion(EventId id, EventTitle titre, EventDate date, EventDuration duree, EventPlace eventPlace, Participants participants) {
        super(id, titre, date, duree);
        this.eventPlace = eventPlace;
        this.participants = participants;
    }

    public EventPlace getLieu() {
        return eventPlace;
    }

    public Participants getParticipants() {
        return participants;
    }

    @Override
    public String description() {
        return "Réunion : " + titre.toString() + " à " + eventPlace.toString() + " avec " + participants.toString();
    }

    @Override
    public boolean conflictsWith(Event other) {
        return other.conflictsWithNonPeriodique(this);
    }

    @Override
    public boolean conflictsWithNonPeriodique(NonPeriodicEvent e) {
        return this.getTimeInterval().overlaps(((Event) e).getTimeInterval());
    }

    @Override
    public boolean conflictsWithPeriodique(PeriodicEvent e) {
        return false;
    }

    @Override
    public boolean occursInPeriod(TimeInterval period) {
        return getTimeInterval().overlaps(period);
    }
}
