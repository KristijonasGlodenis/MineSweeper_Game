import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindowGrid extends JPanel {

    private int maxCells = MinesweeperGame.grid * MinesweeperGame.grid;
    private boolean picked = false;
    private ArrayList<Integer> mines = new ArrayList<Integer>();
    public static ArrayList<GameWindowCell> cellGrid = new ArrayList<GameWindowCell>();

    public GameWindowGrid(GridLayout g, GameEngine gameEngine) {
        super(g);
        createCell(gameEngine);
        addCells();
    }

    public void createCell(GameEngine gameEngine) {
        for(int i = 1; i <= MinesweeperGame.mine; i++) {
            while(!picked) {
                int minePosition = (int) (Math.random() * maxCells);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }

        for(int i = 0; i < maxCells; i++) {
            if(mines.contains(i)) {
                cellGrid.add(new GameWindowCell(1, i, false, false, gameEngine));
            } else if(i % MinesweeperGame.grid == 0){
                if(mines.contains(i - MinesweeperGame.grid) || mines.contains(i - MinesweeperGame.grid + 1) || mines.contains(i + 1) || mines.contains(i + MinesweeperGame.grid) || mines.contains(i + MinesweeperGame.grid + 1)) {
                    cellGrid.add(new GameWindowCell(2, i, false, false, gameEngine));
                } else {
                    cellGrid.add(new GameWindowCell(0, i, false, false, gameEngine));
                }
            } else if(i % MinesweeperGame.grid == MinesweeperGame.grid - 1){
                if(mines.contains(i - MinesweeperGame.grid - 1) || mines.contains(i - MinesweeperGame.grid) || mines.contains(i - 1) || mines.contains(i + MinesweeperGame.grid - 1) || mines.contains(i + MinesweeperGame.grid)) {
                    cellGrid.add(new GameWindowCell(2, i, false, false, gameEngine));
                } else {
                    cellGrid.add(new GameWindowCell(0, i, false, false, gameEngine));
                }
            }else {
                if(mines.contains(i - MinesweeperGame.grid - 1) || mines.contains(i - MinesweeperGame.grid) || mines.contains(i - MinesweeperGame.grid + 1) || mines.contains(i - 1) ||
                        mines.contains(i + 1) || mines.contains(i + MinesweeperGame.grid - 1) || mines.contains(i + MinesweeperGame.grid) || mines.contains(i + MinesweeperGame.grid + 1)) {
                    cellGrid.add(new GameWindowCell(2, i, false, false, gameEngine));
                } else {
                    cellGrid.add(new GameWindowCell(0, i, false, false, gameEngine));
                }
            }
        }
    }

    private void addCells() {
        for(int i = 0; i < cellGrid.size(); i++) {
            add(cellGrid.get(i));
        }
    }
}
