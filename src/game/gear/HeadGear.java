package game.gear;

//This class represents HeadGear. HeadGear effects a Player's Constitution.
class HeadGear extends AbstractGear {

  // constructs Headgear object.
  HeadGear(String name, int effectOnConstitution) {
    super(name, 0, effectOnConstitution, 0, 0);
  }

  // copy constructor for HeadGear.
  HeadGear(HeadGear headGear) {
    super(headGear);
  }

  @Override
  public Gear getCopy() {
    return new HeadGear(this);
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return -1 * that.compareToHeadGear(this);
    }
    return -1;
  }

  int compareToPotion(Potion other) {
    return -1;
  }

  int compareToBelt(Belt other) {
    return -1;
  }

  int compareToFootWear(FootWear other) {
    return -1;
  }

  @Override
  public boolean isHeadGear() {
    return true;
  }

}
