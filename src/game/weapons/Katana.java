package game.weapons;

import game.random.RandomGenerator;

class Katana extends AbstractWeapon {

  Katana() {
    name = "Katana";
    minDamage = 4;
    maxDamage = 6;
  }

  @Override
  public int getDamage(RandomGenerator ranGen) {
    return calculateDamage(ranGen) + calculateDamage(ranGen);
  }

  @Override
  public Weapon getCopy() {
    return new Katana();
  }

  @Override
  public boolean isKatana() {
    return true;
  }
}
