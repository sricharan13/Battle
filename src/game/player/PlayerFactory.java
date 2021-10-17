package game.player;

import game.gear.GearList;
import game.weapons.Weapon;

/**
 * A factory for PlayerList generates a list of Players.
 */
public class PlayerFactory {

  /**
   * returns an empty Player List.
   * @return - new NoPlayerNode object.
   */
  public static PlayerList emptyList() {
    return new EmptyPlayerNode();
  }

  /**
   * Extends the given PlayerList by adding a new Player at the beginning
   * and returns the new PlayerList.
   * @param player - A Player object.
   * @param rest   - rest of the PlayerList.
   * @return - new PlayerList object.
   */
  public static PlayerList extendList(Player player, PlayerList rest) {
    return new PlayerNode(player, rest);
  }

  /**
   * Copy constructor for Player, creates a deep copy of given Player.
   *
   * @param player - player to be copied.
   */
  public static BattlePlayer battlePlayer(Player player) {
    return new BattlePlayer(player);
  }

  /**
   * Creates a new Player with given details.
   *
   * @param name         - name of the Player.
   * @param strength     - Player's strength points.
   * @param constitution Player's constitution points.
   * @param dexterity    - Player's dexterity points.
   * @param charisma     - Player's charisma points.
   */
  public static BattlePlayer battlePlayer(String name, int strength, int constitution,
                                          int dexterity, int charisma,
                                          GearList equipment, Weapon weapon) {
    return new BattlePlayer(name, strength, constitution, dexterity, charisma, equipment, weapon);
  }




}
