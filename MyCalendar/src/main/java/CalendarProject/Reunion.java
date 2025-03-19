package CalendarProject;

import java.util.ArrayList;

public class Reunion extends EventType {

    private ArrayList<String> participants;
    private EventPlace place;

    public Reunion(String place) {
        this.participants = new ArrayList<>();
        this.place = new EventPlace(place);
    }

    public void addParticipant(String participant){
        if (!participants.contains(participant) && !(participant.isEmpty())){
            this.participants.add(participant);
        }
    }

    public String getDesc(EventTitle title){
        return "Réunion : " + title + "à " + this.place.getPlace() + " avec " + this.participants;
    }
}
