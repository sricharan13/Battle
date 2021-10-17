import static game.gear.GearFactory.BeltSize;
import static game.gear.GearFactory.belt;
import static game.gear.GearFactory.emptyList;
import static game.gear.GearFactory.extendList;
import static game.gear.GearFactory.footWear;
import static game.gear.GearFactory.headGear;
import static game.gear.GearFactory.potion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import game.gear.Gear;
import game.gear.GearList;
import org.junit.Test;

/**
 * tests GearList and it's functionalities.
 */
public class GearListTest {

  GearList gearList;

  private void initializeGearList() {
    Gear hg = headGear("HG", 1);
    Gear p = potion("P", -1, 2, -1, 3);
    Gear b = belt("B", BeltSize.SMALL, 0, 1, -1, 0);
    Gear fw = footWear("FW", 1);
    gearList = extendList(fw, extendList(b, extendList(p, extendList(hg, emptyList()))));
  }

  /**
   * test count of GearList.
   */
  @Test
  public void getCount() {
    initializeGearList();
    assertEquals(4, gearList.getCount());
    gearList = extendList(headGear("HG1", -3), gearList);
    assertEquals(5, gearList.getCount());
  }

  /**
   * test getGearAt of GearList.
   */
  @Test
  public void getGearAt() {
    initializeGearList();
    Gear gear = gearList.getGearAt(2);
    assertEquals("P", gear.getName());
    try {
      gearList.getGearAt(5);
      fail("error should occur");
    }
    catch (IndexOutOfBoundsException e) {
      assertEquals("Index out of range: 5", e.getMessage());
    }
  }

  /**
   * test the total effect on strength caused by all gears in GearList.
   */
  @Test
  public void getTotalEffectOnStrength() {
    initializeGearList();
    assertEquals(-1, gearList.getTotalEffectOnStrength());
    gearList = extendList(potion("P1", 4, 0, 0, 0), gearList);
    assertEquals(3, gearList.getTotalEffectOnStrength());
  }

  /**
   * test the total effect on constitution caused by all gears in GearList.
   */
  @Test
  public void getTotalEffectOnConstitution() {
    initializeGearList();
    assertEquals(4, gearList.getTotalEffectOnConstitution());
    gearList = extendList(potion("P1", 4, -5, 0, 0), gearList);
    assertEquals(-1, gearList.getTotalEffectOnConstitution());
  }

  /**
   * test the total effect on dexterity caused by all gears in GearList.
   */
  @Test
  public void getTotalEffectOnDexterity() {
    initializeGearList();
    assertEquals(-1, gearList.getTotalEffectOnDexterity());
    gearList = extendList(potion("P1", 4, -5, 6, 0), gearList);
    assertEquals(5, gearList.getTotalEffectOnDexterity());
  }

  /**
   * test the total effect on charisma caused by all gears in GearList.
   */
  @Test
  public void getTotalEffectOnCharisma() {
    initializeGearList();
    assertEquals(3, gearList.getTotalEffectOnCharisma());
    gearList = extendList(potion("P1", 4, -5, 6, -5), gearList);
    assertEquals(-2, gearList.getTotalEffectOnCharisma());
  }

  /**
   * test if GearList copy is valid.
   */
  @Test
  public void getCopy() {
    initializeGearList();
    String name = gearList.getGearAt(0).getName();
    assertEquals("FW", name);
    GearList copyList = gearList.getCopy();
    assertEquals(name, copyList.getGearAt(0).getName());
    copyList = extendList(headGear("HG1", 1), copyList);
    assertNotEquals(gearList.getCount(), copyList.getCount());
  }

  /**
   * test sorted values of GearList.
   */
  @Test
  public void sort() {
    initializeGearList();
    String[] initialOrder = {"FW", "B", "P", "HG"};
    for (int i = 0; i < gearList.getCount(); i++) {
      assertEquals(initialOrder[i], gearList.getGearAt(i).getName());
    }
    String[] expected = {"HG", "P", "B", "FW"};
    GearList sorted = gearList.sort();
    for (int i = 0; i < sorted.getCount(); i++) {
      assertEquals(expected[i], sorted.getGearAt(i).getName());
    }
  }

  /**
   * check if inserting into list in sorted order.
   */
  @Test
  public void insert() {
    initializeGearList();
    GearList sorted = gearList.sort();
    sorted = sorted.insert(headGear("HG1", 3));
    String[] expected = {"HG", "HG1", "P", "B", "FW"};
    for (int i = 0; i < sorted.getCount(); i++) {
      assertEquals(expected[i], sorted.getGearAt(i).getName());
    }
  }
}