package CalendarProject;

import java.util.ArrayList;

public class Reunion extends EventType {

    private ArrayList<String> participants;
    private EventPlace lieu;

    public Reunion(String place) {
        this.participants = new ArrayList<>();
        this.lieu = new EventPlace(place);
    }

    public void addParticipant(String participant){
        if (!participants.contains(participant) && !(participant.isEmpty())){
            this.participants.add(participant);
        }
    }
/*
    public getDesc(EventTitle title){
        return "Réunion : " + title + "à " + place.getPlace() + " avec " + this.participants;
    }*/
}
