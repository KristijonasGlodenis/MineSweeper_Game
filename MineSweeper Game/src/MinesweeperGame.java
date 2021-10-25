public class MinesweeperGame {

    public static int width = 1000;
    public static int height = 1000;
    public static int grid = 20;
    public static int mine=10;
    private GameEngine gameEngine = new GameEngine();


    public MinesweeperGame() {
        new GameWindow(width, height, grid,  this, gameEngine);
    }

    public static void main(String[] args) {
        new MinesweeperGame();
    }

}
