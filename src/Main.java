import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        GameState gameState = GameState.getInstance();
        Canvas canvas = new Canvas();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(canvas);
        f.setSize(Constants.maxWidth, Constants.maxHeight);
        f.setTitle("Asteroids");
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
    }
}




