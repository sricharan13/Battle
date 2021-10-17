import game.model.BattleGame;
import game.model.Game;
import game.model.Result;

import java.util.Scanner;

/**
 * Driver class for battle.
 */
public class Driver {

  /**
   * main method. Demonstrates the working of battle arena.
   */
  public static void main(String[] args) {
    System.out.println("\n================================================");
    System.out.println("\nWelcome to V's Battle Arena");
    System.out.println("\n================================================");
    System.out.println("\nCreating Player - P1");
    System.out.println("\nCreating Player - P2");
    Game myGame = new BattleGame();
    myGame.createPlayer("P1");
    myGame.createPlayer("P2");

    boolean flag = true;
    while (flag) {
      System.out.println("\n================================================");
      System.out.println("Player 1's Base Stats:");
      System.out.println(myGame.getPlayerInfo("P1").toString());
      System.out.println("\n================================================");
      System.out.println("Player 2's Base Stats:");
      System.out.println(myGame.getPlayerInfo("P2").toString());
      System.out.println("\n================================================");
      System.out.println("\n****Adding Players to Arena****");
      Result equipResult = myGame.addToArena("P1", "P2");
      System.out.println("\nEquipped Players, The following Armory and Gear are assigned:");
      System.out.println("\n--------Attacking Player--------\n" + equipResult.getAttackPlayer());
      System.out.println("\n--------Opponent Player--------\n" + equipResult.getOpponent());
      System.out.println("\n\n****Starting Battle****\n\n");
      while (!myGame.battleOver()) {
        try {
          Result result = myGame.takeBattleTurn();
          System.out.println("Turn Summary:\n" + result.getSummary());
          System.out.println("------------------------------------------------\n");
        }
        catch (IllegalStateException e) {
          System.out.println(e.getMessage());
          break;
        }
      }
      Scanner sc = new Scanner(System.in);
      System.out.println("\nDo you want to continue, Enter y if yes:");
      String  input = sc.next();
      if (input.charAt(0) != 'y') {
        flag = false;
      }
    }
  }
}
