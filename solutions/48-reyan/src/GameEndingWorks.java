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

    protected boolean gameEndSceneSetter(int combinationNo, Color lineColor, int winPlayerIndicator){
        if(notDrawNotWinOptimizer(combinationNo)) return true;

        boolean hasNotEnd = true;
        hasNotEnd = drawHorizontalWinLineAndSetScene(combinationNo, hasNotEnd, lineColor, winPlayerIndicator);
        hasNotEnd = drawVerticalWinLineAndSetScene(combinationNo, hasNotEnd, lineColor, winPlayerIndicator);
        hasNotEnd = drawMainDiagonalWinLineAndSetScene(combinationNo, hasNotEnd, lineColor, winPlayerIndicator);
        hasNotEnd = drawAuxiliaryWinLineAndSetScene(combinationNo, hasNotEnd, lineColor, winPlayerIndicator);
        hasNotEnd = drawDrawScene(combinationNo, hasNotEnd);

        return hasNotEnd;
    }

    private boolean notDrawNotWinOptimizer(int combinationNo){
        boolean hasNotEnd = false ;
        if(combinationNo ==-1) hasNotEnd = true;
        return hasNotEnd;
    }

    private boolean drawHorizontalWinLineAndSetScene(int combinationNo, boolean hasNotEnd, Color lineColor, int winPlayerIndicator){
        if(hasNotEnd){
            if(combinationNo>=0 && combinationNo<=2) {
                drawLineForMatchingMoves(53, 84+109*combinationNo, 368, 84+109*combinationNo, lineColor);
                setGameEndScene(winPlayerIndicator);
                hasNotEnd = false;
            }
        }
        return hasNotEnd;
    }

    private boolean drawVerticalWinLineAndSetScene(int combinationNo, boolean hasNotEnd, Color lineColor, int winPlayerIndicator){
        if(hasNotEnd){
            if(combinationNo>=3 && combinationNo<=5) {
                drawLineForMatchingMoves(103+109*(combinationNo-3), 31, 103+109*(combinationNo-3), 348, lineColor);
                setGameEndScene(winPlayerIndicator);
                hasNotEnd = false;
            }
        }
        return hasNotEnd;
    }

    private boolean drawMainDiagonalWinLineAndSetScene(int combinationNo, boolean hasNotEnd, Color lineColor, int winPlayerIndicator){
        if(hasNotEnd){
            if(combinationNo==6) {
                drawLineForMatchingMoves(50,30, 368, 348, lineColor);
                setGameEndScene(winPlayerIndicator);
                hasNotEnd = false;
            }
        }
        return hasNotEnd;
    }

    private boolean drawAuxiliaryWinLineAndSetScene(int combinationNo, boolean hasNotEnd, Color lineColor, int winPlayerIndicator){
        if(hasNotEnd){
            if(combinationNo==7) {
                drawLineForMatchingMoves(50, 348, 368, 30, lineColor);
                setGameEndScene(winPlayerIndicator);
                hasNotEnd = false;
            }
        }

        return hasNotEnd;
    }

    private boolean drawDrawScene(int combinationNo, boolean hasNotEnd){
        if(hasNotEnd){
            if(combinationNo == 8){
                setGameEndScene(2);
                hasNotEnd=  false;
            }
        }
        return hasNotEnd;
    }


    private void drawLineForMatchingMoves(double x1, double y1, double x2, double y2, Color color){
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
