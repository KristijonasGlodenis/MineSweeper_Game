import javax.swing.*;
import java.awt.event.*;

public class GameWindowCell extends JButton {

    private int type;
    private int position;
    private boolean isDiscovered;
    private boolean isFlagged;
    private GameEngine gameEngine;


    public GameWindowCell(int type, int position, boolean isDiscovered, boolean isFlagged, GameEngine gameEngine) {
        this.type = type;
        this.position = position;
        this.isDiscovered = isDiscovered;
        this.isFlagged = isFlagged;
        this.gameEngine = gameEngine;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    rightClick();
                }
                else
                {
                    leftClick();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public int getType() { return type; }

    public int getPosition() {
        return position;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered(boolean d) {
        this.isDiscovered = d;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean f) {
        this.isFlagged = f;
    }

    public void leftClick() {
        gameEngine.click(this);
    }

    public void rightClick() {
        gameEngine.rightClick(this);
    }

    public void setType(int type) { this.type = type; }

    public void setPosition(int position) { this.position = position; }

    public GameEngine getGameEngine() { return gameEngine; }

    public void setGameEngine(GameEngine gameEngine) { this.gameEngine = gameEngine; }
}
