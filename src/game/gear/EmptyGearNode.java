package game.gear;

// package private EmptyGearNode class, represents an empty node in a GearList.
class EmptyGearNode implements GearList {

  @Override
  public int getCount() {
    return 0;
  }

  @Override
  public Gear getGearAt(int i) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public int getTotalEffectOnStrength() {
    return 0;
  }

  @Override
  public int getTotalEffectOnConstitution() {
    return 0;
  }

  @Override
  public int getTotalEffectOnDexterity() {
    return 0;
  }

  @Override
  public int getTotalEffectOnCharisma() {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public GearList getCopy() {
    return this;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    return this.getClass() == obj.getClass();
  }

  @Override
  public GearList sort() {
    return this;
  }

  @Override
  public GearList insert(Gear that) {
    if (that == null) {
      throw new IllegalArgumentException("gear that can't be null");
    }
    return new GearNode(that, this);
  }
}
