package game.gear;

// This class represents FootWear. FootWear effects a Player's Dexterity.
class FootWear extends AbstractGear {

  // constructs a new Footwear with given parameters.
  FootWear(String name, int effectOnDexterity) {
    super(name, 0, 0, effectOnDexterity, 0);
  }

  // copy constructor, creates a copy of this footwear.
  FootWear(FootWear footWear) {
    super(footWear);
  }

  @Override
  public Gear getCopy() {
    return new FootWear(this);
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return -1 * that.compareToFootWear(this);
    }
    return -1;
  }

  int compareToHeadGear(HeadGear other) {
    return 1;
  }

  int compareToPotion(Potion other) {
    return 1;
  }

  int compareToBelt(Belt other) {
    return 1;
  }

  @Override
  public boolean isFootWear() {
    return true;
  }

}
