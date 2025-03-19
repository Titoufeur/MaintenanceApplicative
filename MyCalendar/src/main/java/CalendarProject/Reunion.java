package CalendarProject;

import java.util.ArrayList;

public class Reunion extends EventType {

    private ArrayList<String> participants;

    public Reunion() {
        super("REUNION");
        this.participants = new ArrayList<>();
    }

    public void addParticipant(String participant){
        if (!participants.contains(participant) && !(participant.isEmpty())){
            this.participants.add(participant);
        }
    }

    public getDesc(EventTitle title, EventPlace place){
        return "Réunion : " + title + "à " + place.getPlace() + " avec " + this.participants;
    }
}
