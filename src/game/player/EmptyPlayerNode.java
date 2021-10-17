package game.player;

/**
 * Represents an empty Player node in PlayerList.
 */
class EmptyPlayerNode implements PlayerList {

  @Override
  public Player getPlayer(String name) {
    throw new IllegalArgumentException("No player found with name: " + name);
  }

  @Override
  public boolean containsPlayer(String name) {
    return false;
  }
}
