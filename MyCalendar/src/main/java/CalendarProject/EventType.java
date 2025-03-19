package CalendarProject;

public abstract class EventType {

    private String type;

    public EventType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
