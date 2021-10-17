package game.model;

import game.player.Player;

/**
 * Result of a Battle turn.
 */
public class Result {
  private final Player attackPlayer;
  private final Player opponent;
  private final String summary;

  /**
   * initializes Results.
   * @param attackPlayer - attacking player fot this turn.
   * @param opponent - opponent for this turn;
   * @param summary - turn summary.
   */
  public Result(Player attackPlayer, Player opponent, String summary) {
    if (attackPlayer == null || opponent == null || summary == null) {
      throw new IllegalArgumentException("players/summary cannot be null");
    }
    this.attackPlayer = attackPlayer;
    this.opponent = opponent;
    this.summary = summary;
  }


  public Player getAttackPlayer() {
    return attackPlayer;
  }

  public Player getOpponent() {
    return opponent;
  }

  public String getSummary() {
    return summary;
  }
}
