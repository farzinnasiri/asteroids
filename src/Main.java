import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(canvas);
        f.setSize(1600, 900);
        f.setTitle("Asteroids");
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
    }
}


class Canvas extends JComponent {
    Vector2d vector2d;
    Drawer drawer;

    public Canvas() {
        vector2d = new Vector2d();
        Timer t = new Timer();
        TimerTask tt = new Ticker();
        t.scheduleAtFixedRate(tt, 500, 16);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus();
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawer = new Drawer(g2);
        vector2d.setX(vector2d.getX()+1);
        vector2d.setY(vector2d.getY()+1);
        drawer.fillCircle(vector2d,50,Color.red);
    }

    private class Ticker extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
}

class Drawer {
    private final Graphics2D graphics;

    public Drawer(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public void fillRect(Vector2d position, int size, Color color) {
        graphics.setColor(color);
        graphics.fillRect(position.getX(), position.getY(), size, size);
    }

    public void fillCircle(Vector2d position, int size, Color color) {
        graphics.setColor(color);
        graphics.fillOval(position.getX(), position.getY(), size, size);
    }

    public void drawGameOverScreen(Graphics g) {
        String message = "Game over!";
        int fontSize = 30;
        Font defaultFont = new Font("Helvetica", Font.PLAIN, fontSize);
        FontMetrics fontMetrics = g.getFontMetrics(defaultFont);
        int stringWidth = fontMetrics.stringWidth(message);
        graphics.setFont(defaultFont);
        graphics.drawString("Game over!", 1600 / 2 - stringWidth / 2, 900 / 2 - fontSize / 2);
    }
}