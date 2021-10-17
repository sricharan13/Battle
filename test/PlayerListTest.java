import static game.player.PlayerFactory.battlePlayer;
import static game.player.PlayerFactory.emptyList;
import static game.player.PlayerFactory.extendList;
import static game.weapons.WeaponFactory.noWeapon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import game.gear.GearFactory;
import game.player.Player;
import game.player.PlayerList;
import org.junit.Test;


/**
 * test for PlayerList.
 */
public class PlayerListTest {

  private PlayerList list;

  private void initializePlayerList() {
    Player p1 = battlePlayer("P1", 10, 20, 15, 8, GearFactory.emptyList(), noWeapon());
    Player p2 = battlePlayer("P2", 10, 20, 15, 8, GearFactory.emptyList(), noWeapon());
    Player p3 = battlePlayer("P3", 10, 20, 15, 8, GearFactory.emptyList(), noWeapon());
    list = extendList(p1, extendList(p2, extendList(p3, emptyList())));
  }

  /**
   * check if getPlayer works correctly.
   */
  @Test
  public void getPlayer() {
    initializePlayerList();
    Player p1 = list.getPlayer("P1");
    assertEquals(10, p1.getStrength());
    try {
      list.getPlayer("P4");
      fail("should fail");
    }
    catch (IllegalArgumentException e) {
      assertEquals("No player found with name: P4", e.getMessage());
    }
  }

  /**
   * test if containsPlayer works correctly.
   */
  @Test
  public void containsPlayer() {
    initializePlayerList();
    assertTrue(list.containsPlayer("P1"));
    assertTrue(list.containsPlayer("P2"));
    assertTrue(list.containsPlayer("P3"));
    assertFalse(list.containsPlayer("P4"));
  }
}