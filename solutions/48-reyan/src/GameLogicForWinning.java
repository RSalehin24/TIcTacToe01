import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameLogicForWinning {

    private boolean[] occupiedHuman;
    private boolean[] occupiedAI;
    private GameEndingScene gameEndingScene;
    private Stage stageOfGame;
    private Tile[] tiles;

    protected GameLogicForWinning(GameStage gameStage){
        this.occupiedHuman = new boolean[9];
        this.occupiedAI = new boolean[9];
        this.gameEndingScene = new GameEndingScene();
        this.stageOfGame = gameStage.getStageOfGame();
        this.tiles = gameStage.getTiles();
    }

    protected void gameEndChecker(Color color) {
        obtainingPlayerFromTiles(tiles, occupiedHuman, occupiedAI);
        winningConditions(occupiedHuman, 0, color);
        winningConditions(occupiedAI, 1, color);
    }

    protected void obtainingPlayerFromTiles(Tile[] tiles, boolean[] occupiedHuman, boolean[] occupiedAI){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()) {
                    occupiedHuman[i] = true;
                } else {
                    occupiedAI[i] = true;
                }
            }
        }
    }

    private void winningConditions(boolean[] booleanArray, int winPlayerIndicator, Color color) {
        for (int i=0, j=0; i<9; i += 3, j+=109) {
            if (booleanArray[i] && booleanArray[i+1] && booleanArray[i+2]) {
                stageOfGame.setScene(gameEndingScene.makeGameOverScene(winPlayerIndicator));
            }
        }

        for(int i=0, j=0; i<3; i++, j+=109){
            if (booleanArray[i] && booleanArray[i+3] && booleanArray[i+6]) {
                stageOfGame.setScene(gameEndingScene.makeGameOverScene(winPlayerIndicator));
            }
        }

        if (booleanArray[0] && booleanArray[4] && booleanArray[8]) {
            stageOfGame.setScene(gameEndingScene.makeGameOverScene(winPlayerIndicator));
        }
        if (booleanArray[2] && booleanArray[4] && booleanArray[6]) {
            stageOfGame.setScene(gameEndingScene.makeGameOverScene(winPlayerIndicator));
        }
    }
}
