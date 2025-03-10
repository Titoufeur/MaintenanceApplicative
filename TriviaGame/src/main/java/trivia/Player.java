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
}
