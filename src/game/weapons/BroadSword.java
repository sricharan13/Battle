package game.weapons;

import game.random.RandomGenerator;

// represents a broad sword.
class BroadSword extends AbstractWeapon {

  // constructs a BroadSword.
  BroadSword() {
    name = "BroadSword";
    minDamage = 6;
    maxDamage = 10;
  }

  @Override
  public int getDamage(RandomGenerator ranGen) {
    return calculateDamage(ranGen);
  }

  @Override
  public Weapon getCopy() {
    return new BroadSword();
  }

  @Override
  public boolean isBroadSword() {
    return true;
  }
}
