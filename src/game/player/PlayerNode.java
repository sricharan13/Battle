package game.player;

import static game.player.PlayerFactory.battlePlayer;

// package private class. Represents a player node in PlayerList.
class PlayerNode implements PlayerList {

  private final Player player;
  private final PlayerList rest;

  // package-private constructor.
  PlayerNode(Player player, PlayerList rest) {
    // check if player is valid.
    if (player == null) {
      throw new IllegalArgumentException("Player can't be null");
    }
    if (rest == null) {
      throw new IllegalArgumentException("ListOfPlayer can't be null");
    }
    this.player = player;
    this.rest = rest;
  }

  @Override
  public Player getPlayer(String name) {
    if (name == null) {
      throw new IllegalArgumentException("name can't be null");
    }
    if (player.getName().equals(name)) {
      return battlePlayer(player);
    }
    else {
      return rest.getPlayer(name);
    }
  }

  @Override
  public boolean containsPlayer(String name) {
    if (name == null) {
      throw new IllegalArgumentException("name can't be null");
    }
    if (player.getName().equals(name)) {
      return true;
    }
    else {
      return rest.containsPlayer(name);
    }
  }

  @Override
  public String toString() {
    return String.format("%s%s", player, rest);
  }
}
