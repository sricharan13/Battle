package game.player;

import game.gear.GearList;
import game.random.RandomGenerator;
import game.weapons.Weapon;

/**
 * Represents a Player. A Player has 4 different abilities and can equip gears and weapon, that
 * affect a Players abilities either positively or negatively.
 */
public interface Player {

  /**
   * assigns given equipment to player.
   * @param equipment - equipment to give to player.
   */
  public void setEquipment(GearList equipment);

  /**
   * assigns given weapon to player.
   * @param weapon - weapon object to be given to player.
   */
  public void setWeapon(Weapon weapon);

  /**
   * adds given damage points to players damage points.
   * @param damageTaken - damage taken by player.
   */
  public void setDamageTaken(int damageTaken);

  /**
   * returns players name. a Unique identifier for player.
   * @return - player's name.
   */
  public String getName();

  /**
   * returns the strength of player.
   * @return - strength points.
   */
  public int getStrength();

  /**
   * returns the constitution of player.
   * @return - constitution points.
   */
  public int getConstitution();

  /**
   * returns the dexterity of player.
   * @return - dexterity points.
   */
  public int getDexterity();

  /**
   * returns the charisma of player.
   * @return - charisma points.
   */
  public int getCharisma();

  /**
   * damage taken by player.
   * @return - damage points.
   */
  public int getDamageTaken();

  /**
   * returns a copy of player's equipment.
   * @return - Players Gearlist.
   */
  public GearList getEquipment();

  /**
   * returns players weapon copy.
   * @return - a weapon object.
   */
  public Weapon getWeapon();

  /**
   * returns players health calculated by players damage taken and total ability points.
   * @return - player's health points.
   */
  public int getHealth();

  /**
   * returns players striking power computed by player's strength and a random
   * number between 1 and 10.
   * @param ranGen - RandomGenerator that accepts a min bound and max bound.
   * @return - strike power of player.
   */
  public int getStrikePower(RandomGenerator ranGen);

  /**
   * returns players avoidance ability computed by player's dexterity and a random
   * number between 1 and 6.
   * @param ranGen - RandomGenerator that accepts a min bound and max bound.
   * @return - avoidance capability of player.
   */
  public int getAvoidanceAbility(RandomGenerator ranGen);

  /**
   * returns the damage caused by Players weapon with in its damage range.
   * @param ranGen - RandomGenerator that accepts a min bound and max bound.
   * @return - damage points of weapon.
   */
  public int getWeaponDamage(RandomGenerator ranGen);


  @Override
  public boolean equals(Object o);

  @Override
  public int hashCode();

  @Override
  public String toString();
}
