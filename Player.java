import java.util.*;
public class Player{
  private String name;
  private int score;
  private ArrayList<Die> listOfDice = new ArrayList<Die>();

  public Player(String name){
    this.name = name;

  }

  public String getName(){
    return this.name;
  }
  public int getScore(){
    return this.score;
  }
  public void rollDice(){
    for(Die die : this.listOfDice){
      die.roll();
    }
  }
  public int getDieValue(){
    int sum = 0;
    for(Die die : this.listOfDice){
      sum += die.getcurrentNum();
    }
    return sum;
  }
  public void increaseScore(){
    this.score++;
  }

public void addDie(int sides){
  this.listOfDice.add(new Die(sides));
}
}
