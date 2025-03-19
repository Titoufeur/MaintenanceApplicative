package CalendarProject;

public class EventPlace {

    private String place;

    public EventPlace(String place) {
        if (place == null) {
            throw new IllegalArgumentException("Le lieu ne peut pas être null");
        }
        if (place.trim().isEmpty()) {
            throw new IllegalArgumentException("Le lieu ne peut pas être vide");
        } else{
            this.place = place;
        }
    }

    public String getPlace(){
        return this.place;
    }
}
