package game.weapons;

// represents an empty weapon in WeaponList.
class EmptyWeaponNode implements WeaponList {

  @Override
  public int getCount() {
    return 0;
  }

  @Override
  public Weapon getWeaponAt(int i) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public WeaponList getCopy() {
    return this;
  }

  @Override
  public String toString() {
    return "";
  }
}
