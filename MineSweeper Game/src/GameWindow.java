import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private static JFrame frame;

    public GameWindow(int width, int height, int gridSize, MinesweeperGame minesweeperGame, GameEngine gameEngine) {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new GameWindowGrid(new GridLayout(gridSize, gridSize), gameEngine);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void update(String text) {
        frame.setTitle(text);
    }
}
