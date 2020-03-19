import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Asteroid {
    private Vector2d position;
    private int size, speed;

    private Color color;

    public Asteroid(Vector2d position, int size, int speed, Color color) {
        this.position = position;
        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public Asteroid() {
        this(new Vector2d(0, 0), 20, 10, Color.RED);
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Ellipse2D getCollisionBox() {
        return new Ellipse2D.Float(position.getX(), position.getY(), size, size);
    }

}
