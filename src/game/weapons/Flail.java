package game.weapons;

import game.random.RandomGenerator;

// represents a flail.
class Flail extends AbstractWeapon {

  // constrcuts a new flail.
  Flail() {
    name = "Flail";
    minDamage = 8;
    maxDamage = 12;
  }

  @Override
  public int getDamage(RandomGenerator ranGen) {
    return calculateDamage(ranGen);
  }

  @Override
  public Weapon getCopy() {
    return new Flail();
  }

  @Override
  public boolean isFlail() {
    return true;
  }
}
