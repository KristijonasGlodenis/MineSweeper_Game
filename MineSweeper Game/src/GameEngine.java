import java.util.ArrayList;

public class GameEngine {

    private ArrayList<GameWindowCell> zeroTypeStorage = new ArrayList<GameWindowCell>();
    private ArrayList<GameWindowCell> current = new ArrayList<GameWindowCell>();

    public void click(GameWindowCell gameWindowCell) {

        int discoveredCells = 0;

        if(gameWindowCell.isFlagged()==false) {

            gameWindowCell.setEnabled(false);
            gameWindowCell.setDiscovered(true);

            int position = gameWindowCell.getPosition();

            if (gameWindowCell.getType() == 0) {
                if (position < MinesweeperGame.grid) {
                    if (position % MinesweeperGame.grid == 0) {
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid + 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)));
                    } else if (position % MinesweeperGame.grid == MinesweeperGame.grid - 1) {
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid - 1)));
                    } else {
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid + 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid - 1)));
                    }
                } else if (position >= (MinesweeperGame.grid * (MinesweeperGame.grid - 1))) {
                    if (position % MinesweeperGame.grid == 0) {
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid + 1)));
                    } else if (position % MinesweeperGame.grid == MinesweeperGame.grid - 1) {
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid - 1)));
                    } else {
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid + 1)));
                        zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid - 1)));
                    }
                } else if (position % MinesweeperGame.grid == MinesweeperGame.grid - 1) {
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid - 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid - 1)));
                } else if (position % MinesweeperGame.grid == 0) {
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid + 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid + 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + 1)));
                }  else {
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid - 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid - 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid + 1)));
                    zeroTypeStorage.add(GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid + 1)));
                }
            } else if (gameWindowCell.getType() == 2) {

                int count = 0;

                if (position < MinesweeperGame.grid) {
                    if (position % MinesweeperGame.grid == 0) {
                        if (GameWindowGrid.cellGrid.get(position + 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid + 1).getType() == 1) count++;
                    } else if (position % MinesweeperGame.grid == MinesweeperGame.grid - 1) {
                        if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid - 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - 1).getType() == 1) count++;
                    } else {
                        if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid + 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid - 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - 1).getType() == 1) count++;
                    }
                } else if (position >= (MinesweeperGame.grid * (MinesweeperGame.grid - 1))) {
                    if (position % MinesweeperGame.grid == 0) {
                        if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid + 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + 1).getType() == 1) count++;
                    } else if (position % MinesweeperGame.grid == MinesweeperGame.grid - 1) {
                        if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid - 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - 1).getType() == 1) count++;
                    } else {
                        if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid + 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid - 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position + 1).getType() == 1) count++;
                        if (GameWindowGrid.cellGrid.get(position - 1).getType() == 1) count++;
                    }
                }  else if (position % MinesweeperGame.grid == MinesweeperGame.grid - 1) {
                    if (GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid - 1)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid - 1)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position - 1)).getType() == 1) count++;
                }  else if (position % MinesweeperGame.grid == 0) {
                    if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get(position - MinesweeperGame.grid + 1).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get(position + MinesweeperGame.grid + 1).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get(position + 1).getType() == 1) count++;
                }  else {
                    if (GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid - 1)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid - 1)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position - MinesweeperGame.grid + 1)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position + MinesweeperGame.grid + 1)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position - 1)).getType() == 1) count++;
                    if (GameWindowGrid.cellGrid.get((position + 1)).getType() == 1) count++;
                }
                gameWindowCell.setText(String.valueOf(count));
            } else if (gameWindowCell.getType() == 1) {
                for (int x = 0; x < GameWindowGrid.cellGrid.size(); x++) {
                    if (GameWindowGrid.cellGrid.get(x).getType() == 1) {
                        GameWindowGrid.cellGrid.get(x).setText("M");
                    }
                }
                gameWindowCell.setEnabled(true);
                gameWindowCell.setText("Boom");
                GameWindow.update("You lose the game");
            }

            for (int i = 0; i < zeroTypeStorage.size(); i++) {
                if (zeroTypeStorage.get(i).isDiscovered()==false) {
                    current.add(zeroTypeStorage.get(i));
                    zeroTypeStorage.get(i).setDiscovered(true);
                }
            }
            zeroTypeStorage.clear();

            while (current.isEmpty()==false) {
                GameWindowCell temp = current.get(0);
                current.remove(0);
                temp.leftClick();
            }

            for(int x = 0; x < GameWindowGrid.cellGrid.size(); x++) {
                if(GameWindowGrid.cellGrid.get(x).isDiscovered()) {
                    discoveredCells++;
                }
            }

            if (discoveredCells == GameWindowGrid.cellGrid.size() - MinesweeperGame.mine) {
                for (int i = 0; i < GameWindowGrid.cellGrid.size(); i++) {
                    if (GameWindowGrid.cellGrid.get(i).getType() == 1) {
                        GameWindowGrid.cellGrid.get(i).setEnabled(false);
                        GameWindowGrid.cellGrid.get(i).setText("M");
                    } else {
                        GameWindowGrid.cellGrid.get(i).setEnabled(false);

                        GameWindow.update("You won the game");
                    }
                }
            }
        }
       }

    public void rightClick(GameWindowCell gameWindowCell) {
        if(!gameWindowCell.isDiscovered()) {
            if(!gameWindowCell.isFlagged()) {
                gameWindowCell.setFlagged(true);
                gameWindowCell.setText("F");
            } else {
                gameWindowCell.setFlagged(false);
                gameWindowCell.setText("");
            }
        }
    }
}
