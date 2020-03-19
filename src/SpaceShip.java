import java.awt.*;

public class SpaceShip {
    private Vector2d position;
    private Color color;
    private int size;
    private int speed;


    public SpaceShip(Vector2d position, Color color, int size, int speed) {
        this.position = position;
        this.color = color;
        this.size = size;
        this.speed = speed;
    }

    public SpaceShip() {
        this(new Vector2d((Constants.maxWidth - Constants.spaceShipSize) / 2,
                        Constants.maxHeight - 3 * Constants.spaceShipSize),
                Constants.spaceShipColor,
                Constants.spaceShipSize, Constants.spaceShipSpeed);
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Rectangle getCollisionBox() {
        return new Rectangle(position.getX(), position.getY(), size, size);
    }

}
