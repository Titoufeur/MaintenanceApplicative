package CalendarProject;

public class EventTitle {

    private String title;

    public EventTitle(String title){
        if (title == null) {
            throw new IllegalArgumentException("Le titre ne peut pas être null");
        }
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        } else{
            this.title = title;
        }
    }

    public String getValue(){
        return this.title;
    }
}
