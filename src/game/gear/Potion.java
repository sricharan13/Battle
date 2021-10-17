package game.gear;

// This class represents Potion. Potion effects any or all of the Player's Abilities.
class Potion extends AbstractGear {

  // constructs a potion with given parameters.
  Potion(String name, int effectOnStrength, int effectOnConstitution,
         int effectOnDexterity, int effectOnCharisma) {
    super(name, effectOnStrength, effectOnConstitution, effectOnDexterity, effectOnCharisma);
  }

  // copy constrcutor.
  Potion(Potion potion) {
    super(potion);
  }

  @Override
  public Gear getCopy() {
    return new Potion(this);
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return -1 * that.compareToPotion(this);
    }
    return -1;
  }

  int compareToHeadGear(HeadGear other) {
    return 1;
  }

  int compareToBelt(Belt other) {
    return -1;
  }

  int compareToFootWear(FootWear other) {
    return -1;
  }

  @Override
  public boolean isPotion() {
    return true;
  }
}
