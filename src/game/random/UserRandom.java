package game.random;

/**
 * User defined Pseudo Random Numbers.
 */
public class UserRandom implements RandomGenerator {

  private final int[] pseudoRandomNumbers;
  private int count;

  /**
   * Creates a new UserRandom function.
   * @param pseudoRandomNumbers - integer array of random numbers.
   */
  public UserRandom(int[] pseudoRandomNumbers) {
    if (pseudoRandomNumbers == null) {
      throw new IllegalArgumentException("pseudo random number can't be null");
    }
    this.pseudoRandomNumbers = pseudoRandomNumbers;
    this.count = 0;
  }

  @Override
  public int getRandomNumber(int min, int max) {
    int value = pseudoRandomNumbers[count];
    if (value < min || value > max) {
      throw new IllegalArgumentException("values should be between: " + min + ", " + max);
    }
    count += 1;
    return value;
  }
}
