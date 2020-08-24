import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class GameLogicForWinning {

    private boolean[] occupiedHuman;
    private boolean[] occupiedAI;
    private boolean endFlag;
    private int secondSToWaitForEndScene;

    private Tile[] tiles;
    private Stage stageOfGame;
    private Pane pane;

    private GameEndingScene gameEndingScene;
    private GameStage gameStage;

    protected GameLogicForWinning(GameStage gameStage){
        this.gameStage = gameStage;
        gameEndingScene = new GameEndingScene();
        stageOfGame = gameStage.getStageOfGame();
        tiles = gameStage.getTiles();
        pane = gameStage.getPaneOfGame();
        occupiedHuman = new boolean[9];
        occupiedAI = new boolean[9];
        endFlag = true;
        secondSToWaitForEndScene = 1;
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
        for (int i=0, j=0, k=0; i<9; i += 3, j+=109, k++) {
            if (booleanArray[i] && booleanArray[i+1] && booleanArray[i+2]) {
                drawLineForMatchingMoves(53, 84+j, 368, 84+j, color);
                start(winPlayerIndicator);
                endFlag = false;
            }

            if (booleanArray[k] && booleanArray[k+3] && booleanArray[k+6]) {
                drawLineForMatchingMoves(103+j, 31, 103+j, 348, color);
                start(winPlayerIndicator);
                endFlag = false;
            }
        }

        if (booleanArray[0] && booleanArray[4] && booleanArray[8]) {
            drawLineForMatchingMoves(50,30, 368, 348, color);
            start(winPlayerIndicator);
            endFlag = false;
        }
        if (booleanArray[2] && booleanArray[4] && booleanArray[6]) {
            drawLineForMatchingMoves(50, 348, 368, 30, color);
            start(winPlayerIndicator);
            endFlag = false;
        }

        drawChecking();
    }

    private void drawChecking(){
        boolean draw = true;
        for(int i=0; i<9; i++){ draw = draw && tiles[i].getIsOccupied(); }
        if(draw){ start(2); }
    }

    private void drawLineForMatchingMoves(double x1, double y1, double x2, double y2, Color color){
        Line line = gameStage.drawLine(x1, y1, x2, y2);
        line.setStroke(color);
        pane.getChildren().add(line);
    }


    private void start(int winPlayerIndicator){
        secondSToWaitForEndScene=1;
        Timer timer  =  new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                secondSToWaitForEndScene--;
                if(secondSToWaitForEndScene == 0) {
                    Platform.runLater(() -> stageOfGame.setScene(gameEndingScene.makeGameOverScene(winPlayerIndicator)));
                }
                timer.cancel();
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    protected boolean getEndFlag(){ return endFlag; }
}
