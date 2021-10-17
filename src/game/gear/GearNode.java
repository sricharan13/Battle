package game.gear;

// package private Gear node class. represents a GearNode in GearList.
class GearNode implements GearList {

  private final Gear gear;
  private final GearList rest;

  // creates a gear node in the GearList with given gear.
  GearNode(Gear gear, GearList rest) {
    if (gear == null) {
      throw new IllegalArgumentException("gear cannot be null");
    }
    if (rest == null) {
      throw new IllegalArgumentException("rest of the list cannot be null");
    }
    this.gear = gear;
    this.rest = rest;
  }

  @Override
  public int getCount() {
    return  1 + rest.getCount();
  }

  @Override
  public Gear getGearAt(int i) {
    if (i == 0) {
      return gear.getCopy();
    }
    else {
      try {
        return rest.getGearAt(i - 1);
      } catch (IndexOutOfBoundsException e) {
        throw new IndexOutOfBoundsException("Index out of range: " + i);
      }
    }
  }

  @Override
  public int getTotalEffectOnStrength() {
    return gear.getEffectOnStrength() + rest.getTotalEffectOnStrength();
  }

  @Override
  public int getTotalEffectOnConstitution() {
    return gear.getEffectOnConstitution() + rest.getTotalEffectOnConstitution();
  }

  @Override
  public int getTotalEffectOnDexterity() {
    return gear.getEffectOnDexterity() + rest.getTotalEffectOnDexterity();
  }

  @Override
  public int getTotalEffectOnCharisma() {
    return gear.getEffectOnCharisma() + rest.getTotalEffectOnCharisma();
  }

  @Override
  public GearList getCopy() {
    return new GearNode(gear.getCopy(), rest.getCopy());
  }

  @Override
  public GearList sort() {
    return rest.sort().insert(gear);
  }

  @Override
  public GearList insert(Gear that) {
    if (that == null) {
      throw new IllegalArgumentException("gear that can't be null");
    }
    if (that.compareTo(gear) <= 0) {
      return new GearNode(that, this);
    }
    else {
      return new GearNode(gear, rest.insert(that));
    }
  }

  @Override
  public String toString() {
    return String.format("%s%s", gear, rest);
  }
}
