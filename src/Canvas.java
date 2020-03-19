import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Canvas extends JComponent {
    private Drawer drawer;
    private GameState gameState;
    private boolean gameOver;

    public Canvas() {
        gameState = GameState.getInstance();
        addKeyListener(new KeyBoardListener());
        java.util.Timer t = new Timer();
        TimerTask tt = new Ticker();
        t.scheduleAtFixedRate(tt, 500, Constants.tickTime);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (drawer == null) drawer = new Drawer(g2d);
        requestFocus();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawer.setGraphics(g2d);
        if (gameOver) {
            drawer.drawGameOverScreen(g2d);
        } else {
            drawer.drawGameState(g2d, gameState);

        }
    }

    private void update() {
        checkCollision();
        updateAsteroids();
        updateGameState();

    }

    private void checkCollision() {
        SpaceShip spaceShip = gameState.getSpaceShip();
        for (Asteroid asteroid : gameState.getAsteroids()) {
            if (asteroid.getCollisionBox().intersects(spaceShip.getCollisionBox())) {
                gameOver = true;
            }
        }
    }

    private void updateGameState() {
        for (Asteroid asteroid : gameState.getAsteroids()) {
            asteroid.setPosition(new Vector2d(asteroid.getPosition().getX(),
                    asteroid.getPosition().getY() + asteroid.getSpeed()));
        }
    }

    private void updateAsteroids() {
        gameState.createAsteroids();
    }

    private class Ticker extends TimerTask {
        @Override
        public void run() {
            if (!gameOver) {
                update();
            }
            repaint();
        }
    }
}