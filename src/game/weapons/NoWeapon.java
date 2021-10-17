package game.weapons;

import game.random.RandomGenerator;

// represents a no weapon.
class NoWeapon extends AbstractWeapon {

  // constructs a new NoWeapon.
  NoWeapon() {
    name = "BareHand";
    minDamage = 0;
    maxDamage = 0;
  }

  @Override
  public int getDamage(RandomGenerator ranGen) {
    return 0;
  }

  @Override
  public Weapon getCopy() {
    return new NoWeapon();
  }
}
