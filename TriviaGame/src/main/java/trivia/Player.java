package trivia;

public class Player {
    private int id;
    private int place;
    private String name;
    private int purses;
    private boolean inPenaltyBox;


    public Player(int id, String name, int score) {
        this.id = id;
        this.place = 1;
        this.name = name;
        this.purses = 0;
        this.inPenaltyBox = false;
    }

    public String toString(){
        return this.name;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public int getId() {
        return id;
    }

    public int getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public int getPurses() {
        return purses;
    }

    public void updatePlace(int roll){
        this.place += roll;
        if (this.place > 12){
            this.place -= 12;
        }
    }
}
