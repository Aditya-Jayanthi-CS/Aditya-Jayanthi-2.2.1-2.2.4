/*
 * Activity 2.2.2
 *
 * The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver
{
  private Player player1;
  private Player player2;
  private Board board;

  public PhraseSolver()
  {
    player1 = new Player();
    player2 = new Player();
    board = new Board();
  }

  public void play()
  {
    Scanner sc = new Scanner(System.in);
    boolean solved = false;
    Player currentPlayer = player1;

    System.out.println("\nGame Start!");

    while (!solved)
    {
      board.setLetterValue();

      System.out.println("\nPhrase: " + board.getSolvedPhrase());
      System.out.println("Letter Value: " + board.getCurrentLetterValue());
      System.out.println(player1.getPlayer() + ": " + player1.getPoints() + " points");
      System.out.println(player2.getPlayer() + ": " + player2.getPoints() + " points");
      System.out.println(currentPlayer.getPlayer() + ", it is your turn.");

      String guess = "";
      boolean valid = false;

      while (!valid)
      {
        System.out.print("Guess a letter: ");
        guess = sc.nextLine();

        if (guess.length() == 1 && Character.isLetter(guess.charAt(0)))
        {
          guess = guess.toLowerCase();
          valid = true;
        }
        else
        {
          System.out.println("Invalid input. Enter ONE letter.");
        }
      }

      String before = board.getSolvedPhrase();

if (board.guessLetter(guess))
{
  String after = board.getSolvedPhrase();
  int count = 0;

  for (int i = 0; i < after.length(); i++)
  {
    if (before.charAt(i) == '_' && Character.isLetter(after.charAt(i)))
    {
      count++;
    }
  }

  System.out.println("Correct guess! Found " + count + " letter(s).");

  currentPlayer.setPoints(
    currentPlayer.getPoints() + count * board.getCurrentLetterValue()
  );

  if (!after.contains("_"))
  {
    solved = true;
  }
}

      else
      {
        System.out.println("Incorrect guess.");
        if (currentPlayer == player1)
        {
          currentPlayer = player2;
        }
        else
        {
          currentPlayer = player1;
        }
      }
    }

    System.out.println("\nPhrase Solved!");
    System.out.println("Final Phrase: " + board.getSolvedPhrase());
    System.out.println(player1.getPlayer() + ": " + player1.getPoints());
    System.out.println(player2.getPlayer() + ": " + player2.getPoints());

    if (player1.getPoints() > player2.getPoints())
    {
      System.out.println("Winner: " + player1.getPlayer());
    }
    else if (player2.getPoints() > player1.getPoints())
    {
      System.out.println("Winner: " + player2.getPlayer());
    }
    else
    {
      System.out.println("It's a tie!");
    }
  }
}
