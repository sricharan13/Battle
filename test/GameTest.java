import static game.gear.GearFactory.belt;
import static game.gear.GearFactory.emptyList;
import static game.gear.GearFactory.extendList;
import static game.gear.GearFactory.footWear;
import static game.gear.GearFactory.headGear;
import static game.gear.GearFactory.listOfDummyGearsNonNeg;
import static game.gear.GearFactory.potion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import game.gear.Gear;
import game.gear.GearFactory;
import game.gear.GearList;
import game.model.BattleGame;
import game.model.Game;
import game.model.Result;
import game.player.Player;
import game.weapons.WeaponFactory;
import org.junit.Test;


/**
 * tests functionality of Game.
 */
public class GameTest {

  Game game;
  GearList gearList;

  private void initializeGame() {
    game = new BattleGame();
  }

  private void initializeGame(int... pseudoRandomNumbers) {
    game = new BattleGame(pseudoRandomNumbers);
  }

  private void initializeGearList() {
    Gear hg = headGear("HG", 1);
    Gear p = potion("P", -1, 2, -1, 3);
    Gear b = belt("B", GearFactory.BeltSize.SMALL, 0, 1, -1, 0);
    Gear fw = footWear("FW", 1);
    gearList = extendList(fw, extendList(b, extendList(p, extendList(hg, emptyList()))));
  }

  /**
   * tests createPlayer.
   */
  @Test
  public void createPlayer() {
    int[] n = {2, 1, 1, 3, 4, 5, 2, 3, 1, 4, 1, 5, 2, 3, 4, 5, 2, 3, 4, 5,
               3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6};
    initializeGame(n);
    game.createPlayer("P1");
    Player p1 = game.getPlayerInfo("P1");
    assertEquals(12, p1.getStrength());
    assertEquals(12, p1.getConstitution());
    assertEquals(12, p1.getDexterity());
    assertEquals(12, p1.getCharisma());
    assertEquals(48, p1.getHealth());
    game.createPlayer("P2");
    Player p2 = game.getPlayerInfo("P2");
    assertEquals(15, p2.getStrength());
    assertEquals(15, p2.getConstitution());
    assertEquals(15, p2.getDexterity());
    assertEquals(15, p2.getCharisma());
    assertEquals(60, p2.getHealth());
    try {
      game.createPlayer("P2");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Player name already taken", e.getMessage());
    }
    try {
      game.getPlayerInfo("P3");
    }
    catch (IllegalArgumentException e) {
      assertEquals("No player found with name: P3", e.getMessage());
    }
  }

  /**
   * check if player info is correct and values not mutating.
   */
  @Test
  public void getPlayerInfo() {
    int[] n = {2, 1, 1, 3, 4, 5, 2, 3, 1, 4, 1, 5, 2, 3, 4, 5, 2, 3, 4, 5,
               3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6};
    initializeGame(n);
    initializeGearList();
    game.createPlayer("P1");
    Player copy = game.getPlayerInfo("P1");
    copy.setDamageTaken(10);
    assertEquals(38, copy.getHealth());
    assertEquals(48, game.getPlayerInfo("P1").getHealth());
  }

  /**
   * add players to arena and equip them for battle.
   */
  @Test
  public void addToArena() {
    initializeGame();
    initializeGearList();
    game.createPlayer("P1");
    game.createPlayer("P2");
    try {
      Result result = game.addToArena("P1", "P2", null, null);
      fail("should not run");
    }
    catch (IllegalArgumentException e) {
      assertEquals("armory and equipment cant be null", e.getMessage());
    }
    try {
      Result result = game.addToArena("P1", "P2", gearList, WeaponFactory.emptyList());
      fail("should not run");
    }
    catch (IllegalArgumentException e) {
      assertEquals("armory should have atleast 1 weapon of each kind", e.getMessage());
    }
    try {
      Result result = game.addToArena("P1", "P2", gearList, WeaponFactory.listOfDummyWeapons());
      fail("should not run");
    }
    catch (IllegalArgumentException e) {
      assertEquals("A minimum of 5 headgear, 5 footwear, "
              + "15 potion and 15 belt are required", e.getMessage());
    }
    try {
      Result result = game.addToArena("P1", "P2", listOfDummyGearsNonNeg(),
              WeaponFactory.listOfDummyWeapons());
      fail("should not run");
    }
    catch (IllegalArgumentException e) {
      assertEquals("atleast 25% items should have diminishing effect", e.getMessage());
    }
    //
    Result result = game.addToArena("P1", "P2");
    Player attackPlayer = result.getAttackPlayer();
    Player opponent = result.getOpponent();
    assertTrue(attackPlayer.getCharisma() >= opponent.getCharisma());
    assertTrue(validPlayerGear(attackPlayer.getEquipment()));
    assertTrue(validPlayerGear(opponent.getEquipment()));
  }

  // check if a player has more than 1 headgear, 1 footwear and 10 units of belt.
  private boolean validPlayerGear(GearList list) {
    int headGearCount = 0;
    int footWearCount = 0;
    int beltUnits = 0;
    for (int i = 0; i < list.getCount(); i++) {
      Gear gear = list.getGearAt(i);
      if (gear.isHeadGear()) {
        headGearCount += 1;
      }
      if (gear.isFootWear()) {
        footWearCount += 1;
      }
      if (gear.isBelt()) {
        beltUnits += GearFactory.getBeltSize(gear);
      }
    }
    return headGearCount <= 1 && footWearCount <= 1 && beltUnits <= 10;
  }
}