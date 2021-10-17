import static game.weapons.WeaponFactory.axe;
import static game.weapons.WeaponFactory.broadSword;
import static game.weapons.WeaponFactory.emptyList;
import static game.weapons.WeaponFactory.extendList;
import static game.weapons.WeaponFactory.flail;
import static game.weapons.WeaponFactory.katana;
import static game.weapons.WeaponFactory.twoHandSword;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import game.weapons.Weapon;
import game.weapons.WeaponList;
import org.junit.Test;

/**
 * tests for WeaponList.
 */
public class WeaponListTest {

  WeaponList weaponList;

  private void initializeWeaponList() {
    Weapon a = axe();
    Weapon b = broadSword();
    Weapon f = flail();
    Weapon k = katana();
    Weapon t = twoHandSword();
    weaponList = extendList(a, extendList(b, extendList(f, extendList(
            k, extendList(t, emptyList())))));
  }

  /**
   * test for count.
   */
  @Test
  public void getCount() {
    initializeWeaponList();
    assertEquals(5, weaponList.getCount());
    weaponList = extendList(axe() ,weaponList);
    assertEquals(6, weaponList.getCount());
  }

  /**
   * test weaponAt of WeaponList.
   */
  @Test
  public void getWeaponAt() {
    initializeWeaponList();
    assertTrue(weaponList.getWeaponAt(2).isFlail());
    assertTrue(weaponList.getWeaponAt(3).isKatana());
  }

  /**
   * test if WeaponList copy is valid.
   */
  @Test
  public void getCopy() {
    initializeWeaponList();
    WeaponList copyList = weaponList.getCopy();
    assertEquals(5, weaponList.getCount());
    assertEquals(5, copyList.getCount());
    copyList = extendList(flail(), copyList);
    assertEquals(5, weaponList.getCount());
    assertEquals(6, copyList.getCount());
  }
}