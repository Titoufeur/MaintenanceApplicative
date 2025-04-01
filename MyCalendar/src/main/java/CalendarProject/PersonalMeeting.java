package CalendarProject;

public final class PersonalMeeting extends Event implements NonPeriodicEvent {

    public PersonalMeeting(EventId id, EventTitle titre, EventDate date, EventDuration duree) {
        super(id, titre, date, duree);
    }

    @Override
    public String description() {
        return "RDV : " + titre.toString() + " à " + date.toString() + " pendant " + duree.toString();
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
