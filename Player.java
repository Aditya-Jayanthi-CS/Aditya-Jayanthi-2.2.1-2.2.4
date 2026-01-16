/*
 * Activity 2.2.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;
  /* your code here - constructor(s) 
  prompt the user to input the player’s name;
  
  save the player's name to the instance variable;

  set their points to 0; and

  print a message welcoming the player, by name, to the game.*/ 
  public Player(){
    Scanner sc = new Scanner(System.in);
    String inputName = "";
    while (true)
    {
      System.out.println("Enter Your Name (letters and spaces only):");
      inputName = sc.nextLine().trim();
      if (inputName.length() > 0 && inputName.matches("[A-Za-z ]+"))
      {
        break;
      }
      System.out.println("Invalid name. Please use letters and spaces only.");
    }
    name = inputName;
    points = 0;
    System.out.println("Welcome " + name);
  }

  public Player(String inputName){
    name = inputName;
    points = 0;
    System.out.println("Welcome " + name);
  }
  
  /* your code here - accessor(s) */ 
  public String getPlayer() {
    return name;
  }

  public int getPoints() {
    return points;
  }
  /* your code here - mutator(s) */ 
  public void setPoints(int p) {
    points = p;
  }

}
