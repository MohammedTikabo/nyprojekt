import java.util.*;
public class Die{

  private int currentNum;
  private int numSides;
  private static Random randomGen = new Random();


  public Die(int numSides){
    this.numSides = numSides;

  }
  public int getNumSides(){
    return this.numSides;
  }

  public int getcurrentNum(){
    return this.currentNum;
  }

  public void roll(){
    this.currentNum = this.randomGen.nextInt(this.numSides) + 1;
  }

}
