package game.weapons;

/**
 * A WeaponFactory that creates and returns different Weapons.
 */
public class WeaponFactory {

  /**
   * returns a new Axe. An Axe causes 6 - 10 points damage.
   * @return - new Axe object.
   */
  public static Weapon axe() {
    return new Axe();
  }

  /**
   * returns a new BroadSword. A BroadSword causes 6 - 10 points damage.
   * @return - new BroadSword object.
   */
  public static Weapon broadSword() {
    return new BroadSword();
  }

  /**
   * returns a new Katana. A Katana is a dual wield sword.
   * each Katana causes 4 - 6 points damage, resulting in a 8 - 12 damage.
   * @return - new Katana object.
   */
  public static Weapon katana() {
    return new Katana();
  }

  /**
   * returns a new Flail. A Flail causes 8 - 12 points damage If Player's dexterity is > 14.
   * If Players dexterity is less than 14, it causes half the damage.
   * @return - new Flail object.
   */
  public static Weapon flail() {
    return new Flail();
  }

  /**
   * returns a new TwoHandSword. A TwoHandSword causes 8 - 12 points damage If Player's
   * strength is > 14. If Players strength is less than 14, it causes half the damage.
   * @return - new TwoHandSword object.
   */
  public static Weapon twoHandSword() {
    return new TwoHandSword();
  }

  /**
   * returns a new NoWeapon. NoWeapon does not cause any damage.
   * @return - new NoWeapon object.
   */
  public static Weapon noWeapon() {
    return new NoWeapon();
  }

  /**
   * creates and returns a new emptyWeaponNode.
   * @return - returns an emptyWeaponNode.
   */
  public static WeaponList emptyList() {
    return new EmptyWeaponNode();
  }

  /**
   * creates and returns a new WeaponList that is an extension of given List.
   * @return - returns an updated WeaponList.
   */
  public static WeaponList extendList(Weapon weapon, WeaponList rest) {
    return new WeaponNode(weapon, rest);
  }

  /**
   * Creates a weaponList from an array of Weapons.
   * @param weapons - weapons to add to WeaponList.
   * @return - WeaponList of given weapons.
   */
  public static WeaponList listFromArray(Weapon... weapons) {
    WeaponList list = emptyList();
    for (Weapon weapon : weapons) {
      list = extendList(weapon, list);
    }
    return list;
  }

  /**
   * returns a list of 5 weapons, 11 of each type.
   * @return - a WeaponList.
   */
  public static WeaponList listOfDummyWeapons() {
    return listFromArray(
            WeaponFactory.axe(), WeaponFactory.katana(), WeaponFactory.twoHandSword(),
            WeaponFactory.flail(), WeaponFactory.broadSword()
    );
  }
}
