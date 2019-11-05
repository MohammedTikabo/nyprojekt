import java.util.*;
class SimpleDiceGame{

  public static void main(String[] args){

    ArrayList<Player> players = initialize();

    for(int i = 0;i<5;i++){
      System.out.println("\nSpelnummer "+(i+1)+":");
      takeTurn(players);
    }
    players = getWinners(players);
    System.out.println("\nGrattis! Följande har vunnit:");
    for(Player player : players){
      System.out.println(player.getName()+" vann med "+player.getScore()+" poäng");
    }
  }
  private static ArrayList<Player> initialize(){
    Scanner input = new Scanner(System.in);
    int playerCount = 0;
    int diceCount = 0;
    int diceSides = 0;
    ArrayList<Player> players = new ArrayList<Player>();
    System.out.println("Välkommen till Dice-spelet!");
    System.out.println("Välj antal spelare som ska spela:");
    playerCount = input.nextInt();
    System.out.println("Antal spelare vald: "+playerCount+"\n");
    System.out.println("Välj antal tärningar varje spelare ska ha:");
    diceCount = input.nextInt();
    System.out.println("Antal tärningar/person vald: "+diceCount+"\n");
    System.out.println("Välj antal sidor varje tärning ska ha:");
    diceSides = input.nextInt();
    System.out.println("Antal sidor vald: "+diceSides+"\n");
    String[] playerNames = new String[playerCount];
    input.nextLine();
    System.out.println("Fyll i ett namn för varje spelare:");
    for(int i = 0;i<playerNames.length;i++){
      System.out.println("Spelare "+(i+1)+" : ");
      playerNames[i] = input.nextLine();
    }
    for(int i = 0;i<playerNames.length;i++){
      players.add(new Player(playerNames[i]));
    }
    for(Player player : players){
      for(int j = 0;j<diceCount;j++){
        player.addDie(diceSides);
      }
    }
    return players;
  }
  private static void takeTurn(ArrayList<Player> players){
    Scanner input = new Scanner(System.in);
    int[] guessRoundScore = new int[players.size()];
    System.out.println("Ny runda startas...");
    for(Player player : players){
      player.rollDice();
    }
    System.out.println("Dags att gissa svaret på tärningarna:");
    for(int i = 0;i<guessRoundScore.length;i++){
      System.out.println("Spelare "+(i+1)+":");
      guessRoundScore[i] = input.nextInt();
    }

    for(int i = 0;i<players.size();i++){
      System.out.println("Spelare "+(i+1)+":");
      if(players.get(i).getDieValue() == guessRoundScore[i]){
        System.out.println("SCORE! Du gissade det rätta svaret! Svar: "+guessRoundScore[i]);
        players.get(i).increaseScore();
      } else {
        System.out.println("Du gissade fel. Det rätta svaret var: "+players.get(i).getDieValue());
      }
    }
    for(Player player : players){
      System.out.println(player.getName()+": "+player.getScore()+" poäng");
    }
  }
  private static ArrayList<Player> getWinners(ArrayList<Player> players){
    ArrayList<Integer> scores = new ArrayList<Integer>();
    int maxValue = 0;
    for(int i = 0;i<players.size();i++){
      scores.add(i,players.get(i).getScore());
    }

    maxValue = Collections.max(scores);
    for(int i = 0;i<scores.size();i++){
      if(scores.get(i) < maxValue){
        scores.remove(i);
        players.remove(i);
        i--;
      }
    }


      return players;
  }
}
