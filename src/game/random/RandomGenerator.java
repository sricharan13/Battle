package game.random;

/**
 * A Random number Generator. Generates a Random Number in the given range.
 */
public interface RandomGenerator {

  /**
   * return a random number.
   * @param min - floor value.
   * @param max - max value.
   * @return - a random number between min and max.
   */
  public int getRandomNumber(int min, int max);

}
