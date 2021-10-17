package game.gear;

// package - private class, provides common functionality of Gears.
abstract class AbstractGear implements Gear {

  // package - private attributes, attributes common to all Gears.
  String name;
  int effectOnStrength;
  int effectOnConstitution;
  int effectOnDexterity;
  int effectOnCharisma;

  // package - private constructor.
  // Initialize gears.
  AbstractGear(String name, int effectOnStrength, int effectOnConstitution,
                      int effectOnDexterity, int effectOnCharisma) {

    if (name == null) {
      throw new IllegalArgumentException("Gear name cannot be null");
    }

    if (!validArguments(effectOnStrength, effectOnConstitution, effectOnDexterity,
            effectOnCharisma)) {
      throw new IllegalArgumentException("Invalid effects");
    }
    this.name = name;
    this.effectOnStrength = effectOnStrength;
    this.effectOnConstitution = effectOnConstitution;
    this.effectOnDexterity = effectOnDexterity;
    this.effectOnCharisma = effectOnCharisma;
  }

  // copy constructor for Gears.
  AbstractGear(Gear gear) {
    if (gear == null) {
      throw new IllegalArgumentException("gear can't be null");
    }
    this.name = gear.getName();
    this.effectOnStrength = gear.getEffectOnStrength();
    this.effectOnConstitution = gear.getEffectOnConstitution();
    this.effectOnDexterity = gear.getEffectOnDexterity();
    this.effectOnCharisma = gear.getEffectOnCharisma();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getEffectOnStrength() {
    return effectOnStrength;
  }

  @Override
  public int getEffectOnConstitution() {
    return effectOnConstitution;
  }

  @Override
  public int getEffectOnDexterity() {
    return effectOnDexterity;
  }

  @Override
  public int getEffectOnCharisma() {
    return effectOnCharisma;
  }

  // package - private method.
  // validates input arguments.
  boolean validArguments(int effectOnStrength, int effectOnConstitution, int effectOnDexterity,
                         int effectOnCharisma) {
    return true;
  }

  @Override
  public String toString() {
    return String.format("\nName: %s, effectOnStrength: %s"
                    + ", effectOnConstitution: %s, effectOnDexterity: %s, effectOnCharisma: %s",
            name, effectOnStrength, effectOnConstitution, effectOnDexterity, effectOnCharisma);
  }

  // helper method for compareTo, called by compareTo method.
  int compareToPotion(Potion other) {
    return this.name.compareTo(other.getName());
  }

  // helper method for compareTo, called by compareTo method.
  int compareToBelt(Belt other) {
    return this.name.compareTo(other.getName());
  }

  // helper method for compareTo, called by compareTo method.
  int compareToFootWear(FootWear other) {
    return this.name.compareTo(other.getName());
  }

  // helper method for compareTo, called by compareTo method.
  int compareToHeadGear(HeadGear other) {
    return this.name.compareTo(other.getName());
  }

  public boolean isBelt() {
    return false;
  }

  public boolean isHeadGear() {
    return false;
  }

  public boolean isFootWear() {
    return false;
  }

  public boolean isPotion() {
    return false;
  }
}
