package game.weapons;

import game.random.RandomGenerator;

// An abstractWeapon, contains all functionalities common to weapons.
abstract class AbstractWeapon implements Weapon {

  // package private attributes.
  String name;
  int minDamage;
  int maxDamage;

  // calculates damage based on minimum and maximum bound.
  int calculateDamage(RandomGenerator ranGen) {
    if (ranGen == null) {
      throw new IllegalArgumentException("ranGen can't be null");
    }
    return ranGen.getRandomNumber(minDamage, maxDamage);
  }

  @Override
  public String toString() {
    return String.format("\nName: %s\nminDamage: %s\nmaxDamage: %s", name, minDamage, maxDamage);
  }

  @Override
  public boolean isFlail() {
    return false;
  }

  @Override
  public boolean isTwoHandSword() {
    return false;
  }

  @Override
  public boolean isKatana() {
    return false;
  }

  @Override
  public boolean isAxe() {
    return false;
  }

  @Override
  public boolean isBroadSword() {
    return false;
  }
}
