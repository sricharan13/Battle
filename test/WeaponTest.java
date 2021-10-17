import static game.weapons.WeaponFactory.axe;
import static game.weapons.WeaponFactory.broadSword;
import static game.weapons.WeaponFactory.flail;
import static game.weapons.WeaponFactory.katana;
import static game.weapons.WeaponFactory.noWeapon;
import static game.weapons.WeaponFactory.twoHandSword;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import game.random.JavaRandom;
import game.random.RandomGenerator;
import game.weapons.Weapon;
import org.junit.Test;

/**
 * test the functionality of a weapon.
 */
public class WeaponTest {

  Weapon a;
  Weapon b;
  Weapon f;
  Weapon k;
  Weapon t;
  Weapon n;

  private void initializeWeapons() {
    a = axe();
    b = broadSword();
    f = flail();
    k = katana();
    t = twoHandSword();
    n = noWeapon();
  }

  /**
   * test the damage caused by a weapon.
   */
  @Test
  public void getDamage() {
    initializeWeapons();
    RandomGenerator ranGen = new JavaRandom();
    int damage = a.getDamage(ranGen);
    assertTrue(damage >= 6 && damage <= 10);
    damage = b.getDamage(ranGen);
    assertTrue(damage >= 6 && damage <= 10);
    damage = f.getDamage(ranGen);
    assertTrue(damage >= 8 && damage <= 12);
    damage = k.getDamage(ranGen);
    assertTrue(damage >= 8 && damage <= 12);
    damage = t.getDamage(ranGen);
    assertTrue(damage >= 8 && damage <= 12);

  }

  /**
   * check if a weapon is a flail.
   */
  @Test
  public void isFlail() {
    initializeWeapons();
    assertFalse(f.isAxe());
    assertFalse(f.isBroadSword());
    assertTrue(f.isFlail());
    assertFalse(f.isKatana());
    assertFalse(f.isTwoHandSword());
  }

  /**
   * check if a weapon is a two hand sword.
   */
  @Test
  public void isTwoHandSword() {
    initializeWeapons();
    assertFalse(t.isAxe());
    assertFalse(t.isBroadSword());
    assertFalse(t.isFlail());
    assertFalse(t.isKatana());
    assertTrue(t.isTwoHandSword());
  }

  /**
   * check if a weapon is a katana.
   */
  @Test
  public void isKatana() {
    initializeWeapons();
    assertFalse(k.isAxe());
    assertFalse(k.isBroadSword());
    assertFalse(k.isFlail());
    assertTrue(k.isKatana());
    assertFalse(k.isTwoHandSword());
  }

  /**
   * check if a weapon is an axe.
   */
  @Test
  public void isAxe() {
    initializeWeapons();
    assertTrue(a.isAxe());
    assertFalse(a.isBroadSword());
    assertFalse(a.isFlail());
    assertFalse(a.isKatana());
    assertFalse(a.isTwoHandSword());
  }

  /**
   * check if a weapon is a broadsword.
   */
  @Test
  public void isBroadSword() {
    initializeWeapons();
    assertFalse(b.isAxe());
    assertTrue(b.isBroadSword());
    assertFalse(b.isFlail());
    assertFalse(b.isKatana());
    assertFalse(b.isTwoHandSword());


  }

  /**
   * test that the returned weapon is a copy of this weapon.
   */
  @Test
  public void getCopy() {
    initializeWeapons();
    Weapon w1 = a.getCopy();
    assertTrue(w1.isAxe());
    Weapon w2 = b.getCopy();
    assertTrue(w2.isBroadSword());
    Weapon w3 = f.getCopy();
    assertTrue(w3.isFlail());
    Weapon w4 = k.getCopy();
    assertTrue(w4.isKatana());
    Weapon w5 = t.getCopy();
    assertTrue(w5.isTwoHandSword());
  }
}