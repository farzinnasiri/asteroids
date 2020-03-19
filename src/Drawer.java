import java.awt.*;

public class Drawer {
    private Graphics2D graphics;

    public Drawer(Graphics2D graphics) {
        this.graphics = graphics;
    }

    private void fillRect(Vector2d position, int size, Color color) {
        graphics.setColor(color);
        graphics.fillRect(position.getX(), position.getY(), size, size);
    }

    private void fillCircle(Vector2d position, int size, Color color) {
        graphics.setColor(color);
        graphics.fillOval(position.getX(), position.getY(), size, size);
    }

    public void drawGameOverScreen(Graphics2D g2d) {
        String message = "Game over!";
        int fontSize = 30;
        Font defaultFont = new Font("Helvetica", Font.PLAIN, fontSize);
        FontMetrics fontMetrics = g2d.getFontMetrics(defaultFont);
        int stringWidth = fontMetrics.stringWidth(message);
        graphics.setFont(defaultFont);
        graphics.drawString("Game over!", 1200 / 2 - stringWidth / 2, 800 / 2 - fontSize / 2);
    }

    public void drawGameState(Graphics2D graphics2D, GameState gameState) {
        for (Asteroid asteroid : gameState.getAsteroids()) {
            fillCircle(asteroid.getPosition(), asteroid.getSize(), asteroid.getColor());
        }
        fillRect(gameState.getSpaceShip().getPosition(),
                gameState.getSpaceShip().getSize(),
                gameState.getSpaceShip().getColor());

    }

    public void setGraphics(Graphics2D graphics) {
        this.graphics = graphics;
    }
}
