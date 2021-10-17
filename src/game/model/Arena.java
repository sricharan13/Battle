package game.model;

import static game.player.PlayerFactory.battlePlayer;

import game.gear.Gear;
import game.gear.GearFactory;
import game.gear.GearList;
import game.player.Player;
import game.random.RandomGenerator;
import game.weapons.Weapon;
import game.weapons.WeaponList;


// package - private class, Arena in the battleGame, all battles take place in Arena.
class Arena {

  private final GearList bag;
  private final WeaponList armory;

  private Player attackPlayer;
  private Player opponent;
  private Player winner;
  private int turnCount;

  // constructs an arena with given equipment and armory.
  Arena(GearList bag, WeaponList armory) {
    validateArguments(bag, armory);
    this.bag = bag;
    this.armory = armory;
    turnCount = 0;
    winner = null;
    attackPlayer = null;
    opponent = null;
  }

  // equips players with weapons and gear.
  Result equipPlayers(Player p1, Player p2, RandomGenerator ranGen) {
    if (ranGen == null || p1 == null || p2 == null) {
      throw new IllegalArgumentException("ranGen/Players can't be null");
    }
    equipPlayer(p1, ranGen);
    equipPlayer(p2, ranGen);
    if (p1.getCharisma() < p2.getCharisma()) {
      attackPlayer = p2;
      opponent = p1;
    }
    else {
      attackPlayer = p1;
      opponent = p2;
    }
    return new Result(attackPlayer, opponent, "");
  }

  int getTurns() {
    return turnCount;
  }

  Result nextPlayerAttack(RandomGenerator ranGen) {
    if (winner != null || turnCount > 200) {
      throw new IllegalStateException("Battle Ended");
    }
    turnCount += 1;
    if (turnCount > 200) {
      throw new IllegalStateException("No progress in 200 moves, terminating battle!!!");
    }
    if (ranGen == null) {
      throw new IllegalArgumentException("ranGen can't be null");
    }
    int strikePower = attackPlayer.getStrikePower(ranGen);
    int avoidanceAbility = opponent.getAvoidanceAbility(ranGen);
    int potentialDamage = 0;
    int actualDamage = 0;
    if (strikePower > avoidanceAbility) {
      int weaponDamage = attackPlayer.getWeaponDamage(ranGen);
      if (attackPlayer.getWeapon().isFlail() && attackPlayer.getDexterity() <= 14) {
        weaponDamage = weaponDamage / 2;
      }
      if (attackPlayer.getWeapon().isTwoHandSword() && attackPlayer.getStrength() <= 14) {
        weaponDamage = weaponDamage / 2;
      }
      potentialDamage = attackPlayer.getStrength() + weaponDamage;
      actualDamage = potentialDamage - opponent.getConstitution();
      if (actualDamage > 0) {
        opponent.setDamageTaken(actualDamage);
      }
    }
    String summary = String.format("\nTurn: %s\nAttacking Player: %s, Strike Power: %s"
                    + "\nOpponent: %s, Avoidance Ability: %s\nPotential Damage: %s, "
                    + "Actual Damage: %s", turnCount, attackPlayer.getName(), strikePower,
            opponent.getName(), avoidanceAbility, potentialDamage, actualDamage);
    if (opponent.getHealth() <= 0) {
      winner = battlePlayer(attackPlayer);
      summary = String.format("%s\n\nWinner is: %s", summary, winner.getName());
    }
    else {
      Player temp = attackPlayer;
      attackPlayer = opponent;
      opponent = temp;
    }
    return new Result(battlePlayer(attackPlayer), battlePlayer(opponent), summary);
  }

  private void equipPlayer(Player player, RandomGenerator ranGen) {
    player.setEquipment(getRandomEquipment(GearFactory.emptyList(), ranGen, 0, 0,0, 20));
    player.setWeapon(getRandomWeapon(ranGen));
  }

  private GearList getRandomEquipment(GearList list, RandomGenerator ranGen,
                                      int headGears, int beltUnits, int footWear, int count) {
    if (count == 0) {
      return list;
    }
    int i = ranGen.getRandomNumber(0, (bag.getCount() - 1));
    Gear gear = bag.getGearAt(i);
    if (gear.isFootWear()) {
      footWear += 1;
      if (footWear > 1) {
        return getRandomEquipment(list, ranGen, headGears, beltUnits, footWear, count - 1);
      }
    }
    if (gear.isHeadGear()) {
      headGears += 1;
      if (headGears > 1) {
        return getRandomEquipment(list, ranGen, headGears, beltUnits, footWear, count - 1);
      }
    }
    if (gear.isBelt()) {
      if (beltUnits + GearFactory.getBeltSize(gear) > 10) {
        return getRandomEquipment(list, ranGen, headGears, beltUnits, footWear, count - 1);
      }
      else {
        beltUnits += GearFactory.getBeltSize(gear);
      }
    }
    return getRandomEquipment(GearFactory.extendList(gear, list),
            ranGen, headGears, beltUnits, footWear, count - 1);
  }

  private Weapon getRandomWeapon(RandomGenerator ranGen) {
    int i = ranGen.getRandomNumber(0, (armory.getCount() - 1));
    return armory.getWeaponAt(i);
  }

  boolean getWinner() {
    return winner != null;
  }

  private void validateArguments(GearList bag, WeaponList armory) {
    if (bag == null || armory == null) {
      throw new IllegalArgumentException("armory and equipment cant be null");
    }
    int katanaCount = 0;
    int axeCount = 0;
    int twoHandSwordCount = 0;
    int flailCount = 0;
    int broadSwordCount = 0;
    int headGearCount = 0;
    int potionCount = 0;
    int footWearCount = 0;
    int beltCount = 0;
    int diminishingGearCount = 0;
    // atleast one type of each weapon
    for (int i = 0; i < armory.getCount(); i++) {
      Weapon weapon = armory.getWeaponAt(i);
      if (weapon.isTwoHandSword()) {
        twoHandSwordCount += 1;
      }
      if (weapon.isFlail()) {
        flailCount += 1;
      }
      if (weapon.isAxe()) {
        axeCount += 1;
      }
      if (weapon.isBroadSword()) {
        broadSwordCount += 1;
      }
      if (weapon.isKatana()) {
        katanaCount += 1;
      }
    }
    if (twoHandSwordCount < 1 || flailCount < 1
            || broadSwordCount < 1 || axeCount < 1 || katanaCount < 1) {
      throw new IllegalArgumentException("armory should have atleast 1 weapon of each kind");
    }
    // check if bag contains 15 FW, 15B, 5 HG, 5 FW and 25% of items have diminishing effect.
    for (int i = 0; i < bag.getCount(); i++) {
      Gear gear = bag.getGearAt(i);
      if (gear.isHeadGear()) {
        headGearCount += 1;
      }
      if (gear.isFootWear()) {
        footWearCount += 1;
      }
      if (gear.isBelt()) {
        beltCount += 1;
      }
      if (gear.isPotion()) {
        potionCount += 1;
      }
      if (gear.getEffectOnCharisma() < 0) {
        diminishingGearCount += 1;
      }
      if (gear.getEffectOnStrength() < 0) {
        diminishingGearCount += 1;
      }
      if (gear.getEffectOnConstitution() < 0) {
        diminishingGearCount += 1;
      }
      if (gear.getEffectOnDexterity() < 0) {
        diminishingGearCount += 1;
      }
    }
    if (headGearCount < 5 || footWearCount < 5 || potionCount < 15 || beltCount < 15) {
      throw new IllegalArgumentException("A minimum of 5 headgear, "
              + "5 footwear, 15 potion and 15 belt are required");
    }
    if (diminishingGearCount < (25 * bag.getCount()) / 100) {
      throw new IllegalArgumentException("atleast 25% items should have diminishing effect");
    }
  }
}
