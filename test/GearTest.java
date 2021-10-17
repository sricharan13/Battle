import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import game.gear.Gear;
import game.gear.GearFactory;
import org.junit.Test;

/**
 * tests Gear and it's functionalities.
 */
public class GearTest {

  Gear hg;
  Gear p;
  Gear b;
  Gear fw;

  private void initializeGears() {
    hg = GearFactory.headGear("HG", 1);
    p = GearFactory.potion("P", -1, 2, -1, 3);
    b = GearFactory.belt("B", GearFactory.BeltSize.SMALL, 0, 1, -1, 0);
    fw = GearFactory.footWear("FW", 1);

  }

  /**
   * test if getName is working correctly.
   */
  @Test
  public void getName() {
    try {
      hg = GearFactory.headGear(null, 1);
      fail("error should be thrown");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Gear name cannot be null", e.getMessage());
    }
    try {
      p = GearFactory.potion(null, -1, 2, -1, 3);
      fail("error should be thrown");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Gear name cannot be null", e.getMessage());
    }
    try {
      b = GearFactory.belt(null, GearFactory.BeltSize.SMALL, 0, 1, -1, 0);
      fail("error should be thrown");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Gear name cannot be null", e.getMessage());
    }
    try {
      b = GearFactory.belt("B", GearFactory.BeltSize.SMALL, 0, 1, -1, 1);
      fail("error should be thrown");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid effects", e.getMessage());
    }
    try {
      fw = GearFactory.footWear(null, 1);
      fail("error should be thrown");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Gear name cannot be null", e.getMessage());
    }
    initializeGears();
    assertEquals("HG", hg.getName());
    assertEquals("P", p.getName());
    assertEquals("B", b.getName());
    assertEquals("FW", fw.getName());
  }

  /**
   * test that the effect on strength ability is correct.
   */
  @Test
  public void getEffectOnStrength() {
    initializeGears();
    assertEquals(0, hg.getEffectOnStrength());
    assertEquals(-1, p.getEffectOnStrength());
    assertEquals(0, b.getEffectOnStrength());
    assertEquals(0, fw.getEffectOnStrength());
  }

  /**
   * test that the effect on constitution ability is correct.
   */
  @Test
  public void getEffectOnConstitution() {
    initializeGears();
    assertEquals(1, hg.getEffectOnConstitution());
    assertEquals(2, p.getEffectOnConstitution());
    assertEquals(1, b.getEffectOnConstitution());
    assertEquals(0, fw.getEffectOnConstitution());
  }

  /**
   * test that the effect on dexterity ability is correct.
   */
  @Test
  public void getEffectOnDexterity() {
    initializeGears();
    assertEquals(0, hg.getEffectOnDexterity());
    assertEquals(-1, p.getEffectOnDexterity());
    assertEquals(-1, b.getEffectOnDexterity());
    assertEquals(1, fw.getEffectOnDexterity());
  }

  /**
   * test that the effect on charisma ability is correct.
   */
  @Test
  public void getEffectOnCharisma() {
    initializeGears();
    assertEquals(0, hg.getEffectOnCharisma());
    assertEquals(3, p.getEffectOnCharisma());
    assertEquals(0, b.getEffectOnCharisma());
    assertEquals(0, fw.getEffectOnCharisma());
  }

  /**
   * test if copy is the correct copy.
   */
  @Test
  public void getCopy() {
    initializeGears();
    Gear hg1 = hg.getCopy();
    assertEquals("HG", hg1.getName());
    Gear p1 = p.getCopy();
    assertTrue(p1.isPotion());
    Gear b1 = b.getCopy();
    assertEquals(0, b1.getEffectOnCharisma());
    Gear fw1 = fw.getCopy();
    assertEquals(1, fw1.getEffectOnDexterity());
  }

  /**
   * check if gear is a belt.
   */
  @Test
  public void isBelt() {
    initializeGears();
    assertFalse(hg.isBelt());
    assertFalse(p.isBelt());
    assertTrue(b.isBelt());
    assertFalse(fw.isBelt());
  }

  /**
   * check if gear is a headgear.
   */
  @Test
  public void isHeadGear() {
    initializeGears();
    assertTrue(hg.isHeadGear());
    assertFalse(p.isHeadGear());
    assertFalse(b.isHeadGear());
    assertFalse(fw.isHeadGear());
  }

  /**
   * check if gear is a footwear.
   */
  @Test
  public void isFootWear() {
    initializeGears();
    assertFalse(hg.isFootWear());
    assertFalse(p.isFootWear());
    assertFalse(b.isFootWear());
    assertTrue(fw.isFootWear());
  }

  /**
   * check if gear is a potion.
   */
  @Test
  public void isPotion() {
    initializeGears();
    assertFalse(hg.isPotion());
    assertTrue(p.isPotion());
    assertFalse(b.isPotion());
    assertFalse(fw.isPotion());
  }
}