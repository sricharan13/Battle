package game.gear;

/**
 * Interface for Gear. Gear affects different abilities of players.
 * Lists all the functionalities of Gear.
 */
public interface Gear extends Comparable<Gear> {

  /**
   * returns the Gear's name.
   * @return - name of Gear.
   */
  public String getName();

  /**
   * returns this Gear's effect on Strength.
   * @return - effect points.
   */
  public int getEffectOnStrength();

  /**
   * returns this Gear's effect on Constitution.
   * @return - effect points.
   */
  public int getEffectOnConstitution();

  /**
   * returns this Gear's effect on Dexterity.
   * @return - effect points.
   */
  public int getEffectOnDexterity();

  /**
   * returns this Gear's effect on Charisma.
   * @return - effect points.
   */
  public int getEffectOnCharisma();

  /**
   * returns a copy of this Gear.
   * @return - Gear object.
   */
  public Gear getCopy();

  /**
   * returns if a Gear is Belt or not.
   * @return - boolean value.
   */
  public boolean isBelt();

  /**
   * returns if a Gear is HeadGear or not.
   * @return - boolean value.
   */
  public boolean isHeadGear();

  /**
   * returns if a Gear is FootWear or not.
   * @return - boolean value.
   */
  public boolean isFootWear();

  /**
   * returns if a Gear is Potion or not.
   * @return - boolean value.
   */
  public boolean isPotion();
}
