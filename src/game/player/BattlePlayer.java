package game.player;

import game.gear.GearList;
import game.random.RandomGenerator;
import game.weapons.Weapon;

import java.util.Objects;

// package private class, implements the Player interface and provides concrete methods.
class BattlePlayer implements Player {

  private final String name;
  private final int strength;
  private final int constitution;
  private final int dexterity;
  private final int charisma;

  private int damageTaken;
  private Weapon weapon;
  private GearList equipment;


  BattlePlayer(String name, int strength, int constitution, int dexterity,
                int charisma, GearList equipment, Weapon weapon) {
    if (name == null) {
      throw new IllegalArgumentException("Player name cannot be null");
    }
    if (equipment == null || weapon == null) {
      throw new IllegalArgumentException("Weapons or equipment can't be null");
    }
    this.name = name;
    this.strength = strength;
    this.constitution = constitution;
    this.dexterity = dexterity;
    this.charisma = charisma;
    this.equipment = equipment;
    this.weapon = weapon;
    this.damageTaken = 0;
  }

  BattlePlayer(Player player) {
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    this.name = player.getName();
    this.strength = player.getStrength();
    this.constitution = player.getConstitution();
    this.dexterity = player.getDexterity();
    this.charisma = player.getCharisma();
    this.damageTaken = player.getDamageTaken();
    this.weapon = player.getWeapon();
    this.equipment = player.getEquipment();
  }

  @Override
  public void setEquipment(GearList equipment) {
    if (equipment == null) {
      throw new IllegalArgumentException("equipment cant be null");
    }
    this.equipment = equipment;
  }

  @Override
  public void setWeapon(Weapon weapon) {
    if (weapon == null) {
      throw new IllegalArgumentException("weapon cant be null");
    }
    this.weapon = weapon;
  }

  @Override
  public void setDamageTaken(int damageTaken) {
    this.damageTaken += damageTaken;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getStrength() {
    return strength + equipment.getTotalEffectOnStrength();
  }

  @Override
  public int getConstitution() {
    return constitution + equipment.getTotalEffectOnConstitution();
  }

  @Override
  public int getDexterity() {
    return dexterity + equipment.getTotalEffectOnDexterity();
  }

  @Override
  public int getCharisma() {
    return charisma + equipment.getTotalEffectOnCharisma();
  }

  @Override
  public int getDamageTaken() {
    return damageTaken;
  }

  @Override
  public GearList getEquipment() {
    return equipment.getCopy();
  }

  @Override
  public Weapon getWeapon() {
    return weapon.getCopy();
  }

  @Override
  public int getHealth() {
    return getStrength() + getConstitution() + getDexterity() + getCharisma() - getDamageTaken();
  }

  @Override
  public int getStrikePower(RandomGenerator ranGen) {
    if (ranGen == null) {
      throw new IllegalArgumentException("ranGen can't be null");
    }
    return getStrength() + ranGen.getRandomNumber(1, 10);
  }

  @Override
  public int getAvoidanceAbility(RandomGenerator ranGen) {
    if (ranGen == null) {
      throw new IllegalArgumentException("ranGen can't be null");
    }
    return getDexterity() + ranGen.getRandomNumber(1, 6);
  }

  @Override
  public int getWeaponDamage(RandomGenerator ranGen) {
    if (ranGen == null) {
      throw new IllegalArgumentException("ranGen can't be null");
    }
    return weapon.getDamage(ranGen);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return getName().equals(player.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return String.format("\nName: %s\n\nStats: "
                    + "\nstrength: %s\nconstitution: %s\ndexterity: %s\ncharisma: %s\nhealth: %s"
                    + "\n\nWeapon: %s\n\nEquipment: %s",
            name, getStrength(), getConstitution(), getDexterity(), getCharisma(), getHealth(),
            getWeapon(), getEquipment().sort());
  }
}
