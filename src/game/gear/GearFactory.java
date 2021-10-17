package game.gear;

/**
 * Factory method for Gear. Creates new Gear and GearList.
 */
public class GearFactory {

  /**
   * represents Belt sizes.
   */
  public enum BeltSize {
    SMALL(1), MEDIUM(2), LARGE(4);
    private final int unit;

    BeltSize(int unit) {
      this.unit = unit;
    }

    int getUnit() {
      return unit;
    }
  }

  /**
   * returns a new HeadGear with given name and effect. HeadGear effects Constitution.
   * @param name - name of the HeadGear.
   * @param effectOnConstitution - gear's effect on Constitution.
   * @return - new HeadGear object.
   */
  public static Gear headGear(String name, int effectOnConstitution) {
    return new HeadGear(name, effectOnConstitution);
  }

  /**
   * returns a new Potion with given name and effect(s). Potion can effect any or all abilities.
   * @param name - name of the Potion.
   * @param effectOnStrength - gear's effect on Strength.
   * @param effectOnConstitution - gear's effect on Constitution.
   * @param effectOnDexterity - gear's effect on Dexterity.
   * @param effectOnCharisma - gear's effect on Charisma.
   * @return - new Potion object.
   */
  public static Gear potion(String name, int effectOnStrength, int effectOnConstitution,
                     int effectOnDexterity, int effectOnCharisma) {
    return new Potion(name, effectOnStrength, effectOnConstitution,
            effectOnDexterity, effectOnCharisma);
  }

  /**
   * returns a new Belt with given name and effect(s). A Belt can effect upto 2 abilities.
   * @param name - name of the Belt.
   * @param size - Size of Belt.
   * @param effectOnStrength - gear's effect on Strength.
   * @param effectOnConstitution - gear's effect on Constitution.
   * @param effectOnDexterity - gear's effect on Dexterity.
   * @param effectOnCharisma - gear's effect on Charisma.
   * @return - new Belt object.
   */
  public static Gear belt(String name, BeltSize size, int effectOnStrength,
                                int effectOnConstitution, int effectOnDexterity,
                                int effectOnCharisma) {
    return new Belt(name, size, effectOnStrength, effectOnConstitution,
            effectOnDexterity, effectOnCharisma);
  }

  /**
   * returns a new FootWear with given name and effect. FootWear affects a Players Dexterity.
   * @param name - name of the FootWear.
   * @param effectOnDexterity - - gear's effect on Dexterity.
   * @return - new FootWear object.
   */
  public static Gear footWear(String name, int effectOnDexterity) {
    return new FootWear(name, effectOnDexterity);
  }

  /**
   * returns an empty GearList.
   * @return - new NoGearNode object.
   */
  public static GearList emptyList() {
    return new EmptyGearNode();
  }

  /**
   * Extends the given GearList by adding a new Gear at the beginning
   * and returns the new GearList.
   * @param gear - A Gear object.
   * @param rest - rest of the GearList.
   * @return - new GearList object.
   */
  public static GearList extendList(Gear gear, GearList rest) {
    return new GearNode(gear, rest);
  }

  /**
   * Creates a GearList from an array of gears.
   * @param gears - gears Array.
   * @return - GearList from given array.
   */
  public static GearList listFromArray(Gear... gears) {
    GearList list = emptyList();
    for (Gear gear : gears) {
      list = extendList(gear, list);
    }
    return list;
  }

  /**
   * Returns the size of belt.
   * @param gear - Belt object.
   * @return - belt size.
   */
  public static int getBeltSize(Gear gear) {
    if (gear == null) {
      throw new IllegalArgumentException("gear can't be null");
    }
    if (gear instanceof Belt) {
      return ((Belt) gear).getSize().getUnit();
    }
    throw new IllegalArgumentException("not a belt object");
  }

  /**
   * returns a list of 40 gear items. The items include 5 HeadGear, 15 Potion, 15 Belt, 5 FootWear.
   * @return - a GearList.
   */
  public static GearList listOfDummyGears() {
    return listFromArray(
            // 5 head gears
            headGear("HG1", 1),
            headGear("HG2", -1),
            headGear("HG3", 2),
            headGear("HG4", -2),
            headGear("HG5", 3),

            // 15 potions
            potion("P1", -1, 2, -1, 3),
            potion("P2", 0, 0, 3, 0),
            potion("P3", 1, 0, 0, 1),
            potion("P4", 0, 0, -3, 1),
            potion("P5", -2, 3, 1, -1),
            potion("P6", -1, 0, 0, 0),
            potion("P7", 1, -2, 2, 2),
            potion("P8", 4, 2, 0, 0),
            potion("P9", 0, -1, 0, -2),
            potion("P10", 0, -3, 1, 0),
            potion("P11", 0, -3, 1, 0),
            potion("P12", 1, -2, 1, 3),
            potion("P13", 2, -3, -1, 0),
            potion("P14", 3, -1, 1, 2),
            potion("P15", -6, -2, 3, 0),

            // 15 belts
            belt("B1", BeltSize.SMALL, 0, 1, -1, 0),
            belt("B2", BeltSize.MEDIUM, 0, 1, -1, 0),
            belt("B3", BeltSize.LARGE, 1, 0, -1, 0),
            belt("B4", BeltSize.SMALL, 1, 0, -1, 0),
            belt("B5", BeltSize.MEDIUM, 0, 1, 0, 1),
            belt("B6", BeltSize.SMALL, 0, 1, -1, 0),
            belt("B7", BeltSize.LARGE, 2, 0, 0, 1),
            belt("B8", BeltSize.SMALL, 0, 2, 0, 2),
            belt("B9", BeltSize.MEDIUM, 0, 0, 0, 0),
            belt("B10", BeltSize.SMALL, 0, 1, -1, 0),
            belt("B11", BeltSize.SMALL, -1, 0, 0, -2),
            belt("B12", BeltSize.LARGE, 0, 1, -1, 0),
            belt("B13", BeltSize.LARGE, 3, 1, 0, 0),
            belt("B14", BeltSize.MEDIUM, 0, 1, 0, 4),
            belt("B15", BeltSize.SMALL, 0, 3, 0, 0),

            // 5 footwear
            footWear("FW1", 1),
            footWear("FW2", -1),
            footWear("FW3", 2),
            footWear("FW4", -2),
            footWear("FW5", 3)
    );
  }

  /**
   * returns a list of 40 gear items. The items include 5 HeadGear, 15 Potion, 15 Belt, 5 FootWear.
   * 25% items do not have negative effects.
   * @return - a GearList.
   */
  public static GearList listOfDummyGearsNonNeg() {
    return listFromArray(
            // 5 head gears
            headGear("HG1", 1),
            headGear("HG2", 1),
            headGear("HG3", 2),
            headGear("HG4", 2),
            headGear("HG5", 3),

            // 15 potions
            potion("P1", 1, 2, 1, 3),
            potion("P2", 0, 0, 3, 0),
            potion("P3", 1, 0, 0, 1),
            potion("P4", 0, 0, 3, 1),
            potion("P5", 2, 3, 1, 1),
            potion("P6", 1, 0, 0, 0),
            potion("P7", 1, 2, 2, 2),
            potion("P8", 4, 2, 0, 0),
            potion("P9", 0, 1, 0, 2),
            potion("P10", 0, 3, 1, 0),
            potion("P11", 0, 3, 1, 0),
            potion("P12", 1, 2, 1, 3),
            potion("P13", 2, 3, 1, 0),
            potion("P14", 3, 1, 1, 2),
            potion("P15", 6, 2, 3, 0),

            // 15 belts
            belt("B1", BeltSize.SMALL, 0, 1, 1, 0),
            belt("B2", BeltSize.MEDIUM, 0, 1, 1, 0),
            belt("B3", BeltSize.LARGE, 1, 0, 1, 0),
            belt("B4", BeltSize.SMALL, 1, 0, 1, 0),
            belt("B5", BeltSize.MEDIUM, 0, 1, 0, 1),
            belt("B6", BeltSize.SMALL, 0, 1, 1, 0),
            belt("B7", BeltSize.LARGE, 2, 0, 0, 1),
            belt("B8", BeltSize.SMALL, 0, 2, 0, 2),
            belt("B9", BeltSize.MEDIUM, 0, 0, 0, 0),
            belt("B10", BeltSize.SMALL, 0, 1, 1, 0),
            belt("B11", BeltSize.SMALL, 1, 0, 0, 2),
            belt("B12", BeltSize.LARGE, 0, 1, 1, 0),
            belt("B13", BeltSize.LARGE, 3, 1, 0, 0),
            belt("B14", BeltSize.MEDIUM, 0, 1, 0, 4),
            belt("B15", BeltSize.SMALL, 0, 3, 0, 0),

            // 5 footwear
            footWear("FW1", 1),
            footWear("FW2", 1),
            footWear("FW3", 2),
            footWear("FW4", 2),
            footWear("FW5", 3)
    );
  }
}
