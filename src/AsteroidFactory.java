import java.util.Random;

public class AsteroidFactory {
    private Random random;

    public AsteroidFactory() {
        random = new Random(System.nanoTime());
    }

    public Asteroid makeAsteroid() {
        int x = random.nextInt(Constants.maxWidth-Constants.maxSize);
        int size = random.nextInt(Constants.maxSize - Constants.minSize) + Constants.minSize;
        int y = -size;
        int speed = random.nextInt(Constants.maxSpeed - Constants.minSpeed) + Constants.minSpeed;

        return new Asteroid(new Vector2d(x, y), size, speed, Constants.asteroidColor);

    }
}
