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

    protected boolean gameEndSceneSetter(int k, Color color, int winPlayerIndicator){
        if(k>=0 && k<=2) drawLineForMatchingMoves(53, 84+109*k, 368, 84+109*k, color);
        if(k>=3 && k<=5) drawLineForMatchingMoves(103+109*(k-3), 31, 103+109*(k-3), 348, color);
        if(k==6) drawLineForMatchingMoves(50,30, 368, 348, color);
        if(k==7) drawLineForMatchingMoves(50, 348, 368, 30, color);
        if(k==8) {
            setGameEndScene(2);
            return false;
        }
        if(k>=0 && k<=7) {
            setGameEndScene(winPlayerIndicator);
            return false;
        }
        return true;
    }

    private void drawLineForMatchingMoves(double x1, double y1, double x2, double y2, Color color){
        Line line = gameStage.drawLine(x1, y1, x2, y2);
        line.setStroke(color);
        paneOfGame.getChildren().add(line);
    }


    private void setGameEndScene(int winPlayerIndicator){
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
}
