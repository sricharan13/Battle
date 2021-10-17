package game.weapons;

import game.random.RandomGenerator;

/**
 * A Weapon interface which lists all the functionalities of a Weapon.
 * Weapons cause damage to Players. Damage to weapons vary for each type and
 * is a random number between the minimum and maximum damage a weapon can cause.
 */
public interface Weapon {

  /**
   * returns the damage caused by a Weapon where damage is a random number between the minimum and
   * maximum damage caused by the Weapon.
   * @param ranGen - A RandomGenerator object.
   * @return - damage.
   */
  public int getDamage(RandomGenerator ranGen);

  /**
   * returns a copy of Weapon.
   * @return - a new copy Weapon.
   */
  public Weapon getCopy();

  /**
   * checks if the weapon is a Flail.
   * @return - boolean if Weapon is a Flail.
   */
  public boolean isFlail();

  /**
   * checks if the weapon is a TwoHandSword.
   * @return - boolean if Weapon is a TwoHandSword.
   */
  public boolean isTwoHandSword();

  /**
   * checks if the weapon is a Katana.
   * @return - boolean if Weapon is a Katana.
   */
  public boolean isKatana();

  /**
   * checks if the weapon is an Axe.
   * @return - boolean if Weapon is a Axe.
   */
  public boolean isAxe();

  /**
   * checks if the weapon is a BroadSword.
   * @return - boolean if Weapon is a BroadSword.
   */
  public boolean isBroadSword();
}
