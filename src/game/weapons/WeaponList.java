package game.weapons;

/**
 * Represents a WeaponList and all its functionalities. WeaponList is a list representation
 * of various Weapons.
 */
public interface WeaponList {

  /**
   * Counts the number of weapons in WeaponList and returns the count.
   * @return - number of items in WeaponList.
   */
  int getCount();

  /**
   * Returns a copy of the Weapon at ith position in the WeaponList.
   * @param i - index of the Weapon.
   * @return - copy of ith Weapon.
   */
  Weapon getWeaponAt(int i);

  /**
   * returns a copy of this WeaponList.
   * @return - A WeaponList.
   */
  WeaponList getCopy();
}
