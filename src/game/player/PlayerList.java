package game.player;

/**
 * Represents a list of Players.
 */
public interface PlayerList {

  /**
   * Finds and returns Player with given name.
   * @param name - name of the Player.
   * @return - Player.
   */
  public Player getPlayer(String name);

  /**
   * Returns true if a player with given name exists.
   * @param name - name of the Player.
   * @return - boolean (true if player exists, false otherwise).
   */
  public boolean containsPlayer(String name);
}
