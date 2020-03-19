import java.awt.*;

public class Constants {
    public static final int maxWidth = 1200;
    public static final int maxHeight = 800;
    public static final int maxSpeed = 10;
    public static final int minSpeed = 2;
    public static final int maxSize = 20;
    public static final int minSize = 5;
    public static final int initialAsteroids = 50;
    public static final int tickTime = 16; // milliseconds
    public static final Color asteroidColor = Color.RED;
    public static final Color spaceShipColor = Color.BLUE;
    public static final int asteroidChance = 5;

    public static final int spaceShipSpeed = 10;
    public static final int spaceShipSize = 30;

    public static enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
