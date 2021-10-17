package game.model;

import game.gear.GearFactory;
import game.gear.GearList;
import game.player.Player;
import game.player.PlayerFactory;
import game.player.PlayerList;
import game.random.JavaRandom;
import game.random.RandomGenerator;
import game.random.UserRandom;
import game.weapons.WeaponFactory;
import game.weapons.WeaponList;

import java.util.Arrays;

/**
 * Implements the Game model. Holds a list of Players and conducts battles between Players.
 * Responsible for maintaining state of the Game.
 */
public class BattleGame implements Game {

  private PlayerList playerList;
  private Arena arena;
  private boolean battleOver;
  private final RandomGenerator ranGen;


  /**
   * Default mode of BattleGame. Generates Random numbers using Java's Random class.
   */
  public BattleGame() {
    playerList = PlayerFactory.emptyList();
    arena = null;
    ranGen = new JavaRandom();
  }

  /**
   * creates a mock BattleGame that is predictable.
   * @param pseudoRandomNumbers - random numbers to use in-place of Java's Random.
   */
  public BattleGame(int ...pseudoRandomNumbers) {
    playerList = PlayerFactory.emptyList();
    arena = null;
    battleOver = false;
    ranGen = new UserRandom(pseudoRandomNumbers);
  }

  // returns a value between 2 and 6, by rolling a 6-sided die and re-rolling any 1s.
  private static int rollDie(RandomGenerator ranGen) {
    int value = ranGen.getRandomNumber(1, 6);
    while (value == 1) {
      value = ranGen.getRandomNumber(1, 6);
    }
    return value;
  }

  // rolls a die 4 times and returns the sum of 3 highest values.
  private static int calculatePoints(RandomGenerator ranGen) {
    int[] rolls = {rollDie(ranGen), rollDie(ranGen), rollDie(ranGen), rollDie(ranGen)};
    Arrays.sort(rolls);
    return rolls[1] + rolls[2] + rolls[3];
  }

  @Override
  public void createPlayer(String name) {
    // check if name is valid (name not equal to null).
    if (name == null) {
      throw new IllegalArgumentException("Player name can't be null");
    }

    // check if name is valid (player names are unique).
    if (playerList.containsPlayer(name)) {
      throw new IllegalArgumentException("Player name already taken");
    }

    // all checks passed, calculate base ability points and create a new player.
    int strPoints = calculatePoints(ranGen);
    int conPoints = calculatePoints(ranGen);
    int dexPoints = calculatePoints(ranGen);
    int chaPoints = calculatePoints(ranGen);

    playerList = PlayerFactory.extendList(PlayerFactory.battlePlayer(name, strPoints, conPoints,
            dexPoints, chaPoints, GearFactory.emptyList(),
            WeaponFactory.noWeapon()), playerList);
  }

  @Override
  public Player getPlayerInfo(String name) {
    return playerList.getPlayer(name);
  }

  @Override
  public Result addToArena(String p1, String p2) {
    arena = new Arena(GearFactory.listOfDummyGears(), WeaponFactory.listOfDummyWeapons());
    battleOver = false;
    return arena.equipPlayers(playerList.getPlayer(p1), playerList.getPlayer(p2), ranGen);
  }

  @Override
  public Result addToArena(String p1, String p2, GearList equipment, WeaponList armory) {
    arena = new Arena(equipment, armory);
    battleOver = false;
    return arena.equipPlayers(playerList.getPlayer(p1), playerList.getPlayer(p2), ranGen);
  }


  @Override
  public Result takeBattleTurn() {
    if (arena == null) {
      throw new IllegalStateException("No players in arena");
    }
    Result result = arena.nextPlayerAttack(ranGen);
    if (arena.getWinner() || arena.getTurns() > 200) {
      battleOver = true;
    }
    return result;
  }

  @Override
  public boolean battleOver() {
    return battleOver;
  }

}
