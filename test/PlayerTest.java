import static game.gear.GearFactory.belt;
import static game.gear.GearFactory.emptyList;
import static game.gear.GearFactory.extendList;
import static game.gear.GearFactory.footWear;
import static game.gear.GearFactory.headGear;
import static game.gear.GearFactory.potion;
import static game.player.PlayerFactory.battlePlayer;
import static game.weapons.WeaponFactory.axe;
import static game.weapons.WeaponFactory.broadSword;
import static game.weapons.WeaponFactory.flail;
import static game.weapons.WeaponFactory.katana;
import static game.weapons.WeaponFactory.noWeapon;
import static game.weapons.WeaponFactory.twoHandSword;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import game.gear.Gear;
import game.gear.GearFactory;
import game.gear.GearList;
import game.player.Player;
import game.random.JavaRandom;
import game.random.RandomGenerator;
import game.weapons.Weapon;

import org.junit.Test;

/**
 * tests for Player functionalities.
 */
public class PlayerTest {

  Player player;
  GearList gearList;
  RandomGenerator ranGen;
  Weapon a;
  Weapon bs;
  Weapon f;
  Weapon k;
  Weapon t;
  Weapon n;

  private void initialize() {
    Gear hg = headGear("HG", 1);
    Gear p = potion("P", -1, 2, -1, 3);
    Gear b = belt("B", GearFactory.BeltSize.SMALL, 0, 1, -1, 0);
    Gear fw = footWear("FW", 1);
    gearList = extendList(fw, extendList(b, extendList(p, extendList(hg, emptyList()))));
    a = axe();
    bs = broadSword();
    f = flail();
    k = katana();
    t = twoHandSword();
    n = noWeapon();
    player = battlePlayer("P1", 10, 20, 15, 8, emptyList(), a);
  }

  /**
   * check if player's equipment is set properly.
   */
  @Test
  public void setEquipment() {
    initialize();
    assertEquals(player.getEquipment(), emptyList());
    player.setEquipment(gearList);
    assertNotEquals(player.getEquipment(), emptyList());
    assertTrue(player.getEquipment().getGearAt(0).isFootWear());
    assertTrue(player.getEquipment().getGearAt(1).isBelt());
    assertTrue(player.getEquipment().getGearAt(2).isPotion());
    assertTrue(player.getEquipment().getGearAt(3).isHeadGear());
    try {
      player.setEquipment(null);
    }
    catch (IllegalArgumentException e) {
      assertEquals("equipment cant be null", e.getMessage());
    }
  }

  /**
   * check if get name returns the correct name.
   */
  @Test
  public void getName() {
    initialize();
    assertEquals("P1", player.getName());
  }

  /**
   * check if get strength returns the current strength.
   */
  @Test
  public void getStrength() {
    initialize();
    assertEquals(10, player.getStrength());
  }

  /**
   * check if get constitution returns the current constitution.
   */
  @Test
  public void getConstitution() {
    initialize();
    assertEquals(20, player.getConstitution());
  }

  /**
   * check if get dexterity returns the current dexterity.
   */
  @Test
  public void getDexterity() {
    initialize();
    assertEquals(15, player.getDexterity());
  }

  /**
   * check if get charisma returns the current charisma.
   */
  @Test
  public void getCharisma() {
    initialize();
    assertEquals(8, player.getCharisma());
  }

  /**
   * check if get damage returns the current damage.
   */
  @Test
  public void getDamageTaken() {
    initialize();
    assertEquals(0, player.getDamageTaken());
  }

  /**
   * check if get weapon returns the correct weapon.
   */
  @Test
  public void getWeapon() {
    initialize();
    assertTrue(player.getWeapon().isAxe());
    try {
      player.setWeapon(null);
      fail("should fail");
    }
    catch (IllegalArgumentException e) {
      assertEquals("weapon cant be null", e.getMessage());
    }
    player.setWeapon(flail());
    assertTrue(player.getWeapon().isFlail());
  }

  /**
   * check if get health returns the current health.
   */
  @Test
  public void getHealth() {
    initialize();
    assertEquals(53, player.getHealth());
    player.setEquipment(gearList);
    assertEquals(58, player.getHealth());
  }

  /**
   * check if get strike power returns the correct strike power.
   */
  @Test
  public void getStrikePower() {
    initialize();
    int damage = player.getStrikePower(new JavaRandom());
    assertTrue(damage >= 10 + 1 && damage <= 10 + 10);
  }

  /**
   * check if avoidance ability returns the correct avoidance ability.
   */
  @Test
  public void getAvoidanceAbility() {
    initialize();
    int damage = player.getAvoidanceAbility(new JavaRandom());
    assertTrue(damage >= 15 + 1 && damage <= 15 + 6);
  }

  /**
   * check if get weapon damage returns the correct weapon damage.
   */
  @Test
  public void getWeaponDamage() {
    initialize();
    int damage = player.getWeaponDamage(new JavaRandom());
    assertTrue(damage >= 6 && damage <= 10);
  }
}