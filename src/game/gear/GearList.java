package game.gear;

/**
 * A list of Gear. A list representation of different Gears.
 */
public interface GearList {

  /**
   * Counts the number of items in GearList and returns the count.
   * @return - number of items in GearList.
   */
  public int getCount();

  /**
   * returns the Gear at ith position in GearList.
   * @return - Gear at position i
   */
  public Gear getGearAt(int i);

  /**
   * Calculates the total effect (positive and negative) on strength by the Gear.
   * @return - the total effect.
   */
  public int getTotalEffectOnStrength();

  /**
   * Calculates the total effect (positive and negative) on strength by the Gear.
   * @return - the total effect.
   */
  public int getTotalEffectOnConstitution();

  /**
   * Calculates the total effect (positive and negative) on strength by the Gear.
   * @return - the total effect.
   */
  public int getTotalEffectOnDexterity();

  /**
   * Calculates the total effect (positive and negative) on strength by the Gear.
   * @return - the total effect.
   */
  public int getTotalEffectOnCharisma();

  /**
   * returns a copy of this GearList.
   * @return - copy of this.
   */
  public GearList getCopy();

  /**
   * returns a sorted GearList, with the following priority:
   * HeadHear, Potion, Belt, FootWear.
   * @return - sorted GearList.
   */
  public GearList sort();

  /**
   * inserts into the list in the sorted order and returns the new list.
   * @param gear - gear to add to list.
   * @return - new sorted GearList.
   */
  public GearList insert(Gear gear);
}
