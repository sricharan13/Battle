package game.model;

import game.gear.GearList;
import game.player.Player;
import game.weapons.WeaponList;

/**
 * Interface for Game. Provides all the functionalities offered by this BattleGame.
 * A Game allows the creation of Players, who will be equipped with weapons and gear
 * and pitting the in Turn Based Battles.
 */
public interface Game {

  /**
   * creates a player with given name. Player name should be unique.
   * @param playerName - name of the player.
   */
  void createPlayer(String playerName);

  /**
   * returns the Player object (copy) of the given player.
   * @param playerName - name of the player.
   * @return - Player object.
   */
  Player getPlayerInfo(String playerName);

  /**
   * Adds 2 players to arena and equips them for battle. the equipment and armory for this
   * arena are the default equipment and armory provided by GearFactory.
   * @param player1Name - name of the 1st player.
   * @param player2Name - name of 2nd player.
   * @return - Results of adding players to arena.
   */
  Result addToArena(String player1Name, String player2Name);

  /**
   * Adds 2 players to arena and equips them for battle. the equipment and armory for this
   * arena are provided by the user.
   * @param player1Name - name of the 1st player.
   * @param player2Name - name of 2nd player.
   * @param equipment - Gear with which Players should be equipped.
   * @param armory - Weapons with which Players should be equipped.
   * @return - Results of adding players to arena.
   */
  public Result addToArena(String player1Name, String player2Name,
                           GearList equipment, WeaponList armory);

  /**
   * Attacking player make their move. Calculations are done and
   * summary of the game, attackPlayer details and opponents details are returned.
   * @return - statistics of the move.
   */
  Result takeBattleTurn();

  /**
   *  returns if battle is over or not.
   *  @return - boolean.
   */
  boolean battleOver();

}
