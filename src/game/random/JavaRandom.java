package game.random;

import java.util.Random;

/**
 * Java's default Random generator.
 */
public class JavaRandom implements RandomGenerator {

  private final Random random;

  /**
   * creates a new Java random object.
   */
  public JavaRandom() {
    random = new Random();
  }

  @Override
  public int getRandomNumber(int min, int max) {
    return random.nextInt(max - min + 1) + min;
  }
}
