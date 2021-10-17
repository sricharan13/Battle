package game.gear;

// package private Belt class, affects any 2 abilities of a player. the abilities should be
// specified when creating the Belt.
class Belt extends AbstractGear {

  private final GearFactory.BeltSize size;

  // Belt constructor, constructs a new Belt.
  Belt(String name, GearFactory.BeltSize size, int effectOnStrength, int effectOnConstitution,
       int effectOnDexterity, int effectOnCharisma) {
    super(name, effectOnStrength, effectOnConstitution, effectOnDexterity, effectOnCharisma);
    this.size = size;
  }

  // Belt copy constructor, creates a copy of this belt.
  Belt(Belt belt) {
    super(belt);
    this.size = belt.getSize();
  }

  // returns size of this belt.
  GearFactory.BeltSize getSize() {
    return size;
  }

  @Override
  boolean validArguments(int effectOnStrength, int effectOnConstitution, int effectOnDexterity,
                         int effectOnCharisma)  {
    int count = 0;
    if (effectOnStrength != 0) {
      count += 1;
    }
    if (effectOnConstitution != 0) {
      count += 1;
    }
    if (effectOnDexterity != 0) {
      count += 1;
    }
    if (effectOnCharisma != 0) {
      count += 1;
    }
    return count <= 2;
  }

  @Override
  public Gear getCopy() {
    return new Belt(this);
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return -1 * that.compareToBelt(this);
    }
    return -1;
  }

  int compareToHeadGear(HeadGear other) {
    return 1;
  }

  int compareToPotion(Potion other) {
    return 1;
  }

  int compareToFootWear(FootWear other) {
    return -1;
  }

  @Override
  public boolean isBelt() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("\nName: %s, Size: %s, effectOnStrength: %s, effectOnConstitution: %s, "
                    + "effectOnDexterity: %s, effectOnCharisma: %s", name, size, effectOnStrength,
            effectOnConstitution, effectOnDexterity, effectOnCharisma);
  }
}
