import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState {
    private static GameState gameState;
    private List<Asteroid> asteroids;
    private AsteroidFactory asteroidFactory;
    private SpaceShip spaceShip;
    private Random random;


    private GameState() {
        asteroids = new ArrayList<>();
        asteroidFactory = new AsteroidFactory();
        spaceShip = new SpaceShip();
        random = new Random();
    }

    public static GameState getInstance() {
        if (gameState == null) {
            gameState = new GameState();
        }
        return gameState;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public SpaceShip getSpaceShip(){
        return spaceShip;
    }

    public void createAsteroids() {
        int chance = random.nextInt(100);
        if (Constants.asteroidChance >= chance) {
            asteroids.add(asteroidFactory.makeAsteroid());
        }
    }

    public void moveSpaceShip(Constants.Direction direction) {
        if(direction == Constants.Direction.UP) {
            spaceShip.getPosition().addY(-spaceShip.getSpeed());
        }
        if(direction == Constants.Direction.DOWN) {
            spaceShip.getPosition().addY(+spaceShip.getSpeed());
        }
        if(direction == Constants.Direction.LEFT) {
            spaceShip.getPosition().addX(-spaceShip.getSpeed());
        }
        if(direction == Constants.Direction.RIGHT) {
            spaceShip.getPosition().addX(spaceShip.getSpeed());
        }
    }
}
