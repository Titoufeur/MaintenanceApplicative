package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

// REFACTOR ME
public class Game implements IGame {
   ArrayList<Player> players = new ArrayList<>();

   LinkedList popQuestions = new LinkedList();
   LinkedList scienceQuestions = new LinkedList();
   LinkedList sportsQuestions = new LinkedList();
   LinkedList rockQuestions = new LinkedList();

   int currentPlayer = 0;
   boolean isGettingOutOfPenaltyBox;

   public Game() {
      for (int i = 0; i < 50; i++) {
         popQuestions.addLast("Pop Question " + i);
         scienceQuestions.addLast(("Science Question " + i));
         sportsQuestions.addLast(("Sports Question " + i));
         rockQuestions.addLast(createRockQuestion(i));
      }
   }

   public String createRockQuestion(int index) {
      return "Rock Question " + index;
   }

   public boolean isPlayable() {
      return (players.size() >= 2);
   }

   public boolean add(String playerName) {
      Player p = new Player(players.size(), playerName, 0);
      players.add(p);

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());

      return true;
   }

   public Player getCurrentPlayer(int nb) {
      return players.get(nb);
   }

   public void roll(int roll) {
      System.out.println(getCurrentPlayer(currentPlayer) + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (getCurrentPlayer(currentPlayer).isInPenaltyBox()) {
         if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;

            System.out.println(getCurrentPlayer(currentPlayer) + " is getting out of the penalty box");
            getCurrentPlayer(currentPlayer).updatePlace(roll); //Ajoute la valeur de roll à la place du joueur
            printStatement(getCurrentPlayer(currentPlayer));  //Donne la place du joueur et la catégorie de la question
            askQuestion();
         } else {
            System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }
      } else {
         getCurrentPlayer(currentPlayer).updatePlace(roll);
         printStatement(getCurrentPlayer(currentPlayer));
         askQuestion();
      }
   }

   public void printStatement(Player p){
      System.out.println(p
              + "'s new location is "
              + p.getPlace());
      System.out.println("The category is " + currentCategory());
   }

   private void askQuestion() {
      if (currentCategory() == "Pop")
         System.out.println(popQuestions.removeFirst());
      if (currentCategory() == "Science")
         System.out.println(scienceQuestions.removeFirst());
      if (currentCategory() == "Sports")
         System.out.println(sportsQuestions.removeFirst());
      if (currentCategory() == "Rock")
         System.out.println(rockQuestions.removeFirst());
   }


   private String currentCategory() {
      int pos = getCurrentPlayer(currentPlayer).getPlace() - 1;
      switch (pos % 4) {
         case 0: return "Pop";
         case 1: return "Science";
         case 2: return "Sports";
         default: return "Rock";
      }
   }

   public boolean handleCorrectAnswer() {
      if (inPenaltyBox[currentPlayer]) {
         if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was corrent!!!!");
            purses[currentPlayer]++;
            System.out.println(players.get(currentPlayer)
                               + " now has "
                               + purses[currentPlayer]
                               + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
         } else {
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;
            return true;
         }


      } else {

         System.out.println("Answer was corrent!!!!");
         purses[currentPlayer]++;
         System.out.println(players.get(currentPlayer)
                            + " now has "
                            + purses[currentPlayer]
                            + " Gold Coins.");

         boolean winner = didPlayerWin();
         currentPlayer++;
         if (currentPlayer == players.size()) currentPlayer = 0;

         return winner;
      }
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
      inPenaltyBox[currentPlayer] = true;

      currentPlayer++;
      if (currentPlayer == players.size()) currentPlayer = 0;
      return true;
   }


   private boolean didPlayerWin() {
      return !(purses[currentPlayer] == 6);
   }
}
