import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyBoardListener implements KeyListener {
    private GameState gameState = GameState.getInstance();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        updateState(e.getKeyCode());
    }

    private void updateState(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                gameState.moveSpaceShip(Constants.Direction.UP);
                break;
            case KeyEvent.VK_RIGHT:
                gameState.moveSpaceShip(Constants.Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                gameState.moveSpaceShip(Constants.Direction.LEFT);
                break;
            case KeyEvent.VK_DOWN:
                gameState.moveSpaceShip(Constants.Direction.DOWN);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
