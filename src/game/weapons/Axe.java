package game.weapons;

import game.random.RandomGenerator;

// represents an Axe.
class Axe extends AbstractWeapon {

  // constructs an axe.
  Axe() {
    name = "Axe";
    minDamage = 6;
    maxDamage = 10;
  }

  @Override
  public int getDamage(RandomGenerator ranGen) {
    return calculateDamage(ranGen);
  }

  @Override
  public Weapon getCopy() {
    return new Axe();
  }

  @Override
  public boolean isAxe() {
    return true;
  }
}

