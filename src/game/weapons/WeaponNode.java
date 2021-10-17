package game.weapons;

class WeaponNode implements WeaponList {

  private final Weapon weapon;
  private final WeaponList rest;

  WeaponNode(Weapon weapon, WeaponList rest) {
    if (weapon == null) {
      throw new IllegalArgumentException("weapon cannot be null");
    }
    if (rest == null) {
      throw new IllegalArgumentException("rest of the list cannot be null");
    }
    this.weapon = weapon;
    this.rest = rest;
  }

  @Override
  public int getCount() {
    return 1 + rest.getCount();
  }

  @Override
  public Weapon getWeaponAt(int i) {
    if (i == 0) {
      return weapon.getCopy();
    }
    else {
      try {
        return rest.getWeaponAt(i - 1);
      } catch (IndexOutOfBoundsException e) {
        throw new IndexOutOfBoundsException("Index out of range: " + i);
      }
    }
  }

  @Override
  public WeaponList getCopy() {
    return new WeaponNode(weapon.getCopy(), rest.getCopy());
  }

  @Override
  public String toString() {
    return weapon + ", " + rest;
  }
}
