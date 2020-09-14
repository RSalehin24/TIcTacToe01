import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class GameEndingWorks {

    private int secondSToWaitForEndScene;

    private GameStage gameStage;
    private Pane paneOfGame;
    private Stage stageOfGame;

    private GameEndingScene gameEndingScene;

    protected GameEndingWorks(GameStage gameStage){
        this.gameStage = gameStage;
        paneOfGame = gameStage.getPaneOfGame();
        stageOfGame = gameStage.getStageOfGame();
        gameEndingScene = new GameEndingScene();
    }

    protected void gameEndLineDrawerAndSceneSetter(int combinationNo, Color lineColor, int winPlayerIndicator){
        drawRowWinLineAndSetScene(combinationNo, lineColor, winPlayerIndicator);
        drawColumnWinLineAndSetScene(combinationNo, lineColor, winPlayerIndicator);
        drawMainDiagonalWinLineAndSetScene(combinationNo, lineColor, winPlayerIndicator);
        drawAuxiliaryDiagonalWinLineAndSetScene(combinationNo, lineColor, winPlayerIndicator);
        setDrawScene(combinationNo);
    }

    private void drawRowWinLineAndSetScene(int combinationNo, Color lineColor, int winPlayerIndicator){
        if(combinationNo>=0 && combinationNo<=2) {
            drawLineForThreeMatchingTiles(53, 84+109*combinationNo, 368, 84+109*combinationNo, lineColor);
            setGameEndScene(winPlayerIndicator);
        }
    }

    private void drawColumnWinLineAndSetScene(int combinationNo, Color lineColor, int winPlayerIndicator){
        if(combinationNo>=3 && combinationNo<=5) {
            drawLineForThreeMatchingTiles(103+109*(combinationNo-3), 31, 103+109*(combinationNo-3), 348, lineColor);
            setGameEndScene(winPlayerIndicator);
        }
    }

    private void drawMainDiagonalWinLineAndSetScene(int combinationNo, Color lineColor, int winPlayerIndicator){
        if(combinationNo==6) {
            drawLineForThreeMatchingTiles(50, 30, 368, 348, lineColor);
            setGameEndScene(winPlayerIndicator);
        }
    }

    private void drawAuxiliaryDiagonalWinLineAndSetScene(int combinationNo, Color lineColor, int winPlayerIndicator){
        if(combinationNo==7) {
            drawLineForThreeMatchingTiles(50, 348, 368, 30, lineColor);
            setGameEndScene(winPlayerIndicator);
        }
    }

    private void setDrawScene(int combinationNo){
        if(combinationNo == 8) {
            setGameEndScene(2);
        }
    }


    private void drawLineForThreeMatchingTiles(double x1, double y1, double x2, double y2, Color color){
        Line line = gameStage.drawLine(x1, y1, x2, y2);
        line.setStroke(color);
        paneOfGame.getChildren().add(line);
    }


    private void setGameEndScene(int winPlayerIndicator){
        secondSToWaitForEndScene=1;
        Timer timer = new Timer();
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
}
