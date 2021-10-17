package game.weapons;

import game.random.RandomGenerator;

// represents a TwoHandSword.
class TwoHandSword extends AbstractWeapon {

  // constructs twoHandSwords.
  TwoHandSword() {
    name = "TwoHandSword";
    minDamage = 8;
    maxDamage = 12;
  }

  @Override
  public int getDamage(RandomGenerator ranGen) {
    return calculateDamage(ranGen);
  }

  @Override
  public Weapon getCopy() {
    return new TwoHandSword();
  }

  @Override
  public boolean isTwoHandSword() {
    return true;
  }
}

