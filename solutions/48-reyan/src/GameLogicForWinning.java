import javafx.scene.paint.Color;

public class GameLogicForWinning {


    private boolean notEndFlag;

    private CurrentStateOfGame currentStateOfGame;
    private GameEndingWorks gameEndingWorks;


    protected void initializeGameWinningLogic(GameStage gameStage){
        notEndFlag = true;
        currentStateOfGame = new CurrentStateOfGame(gameStage.getTiles());
        gameEndingWorks = new GameEndingWorks(gameStage);
    }

    protected void gameEndChecker(Color color) {
        int combinationNo = winnerDrawChecker(currentStateOfGame.getOccupiedHuman(), currentStateOfGame.getOccupiedAI());
        boolean isNotEnd = gameEndingWorks.gameEndSceneSetter(combinationNo, color, 0);
        if(isNotEnd){
            combinationNo = winnerDrawChecker(currentStateOfGame.getOccupiedAI(), currentStateOfGame.getOccupiedHuman());
            gameEndingWorks.gameEndSceneSetter(combinationNo, color, 1);
        }
    }

    protected int winnerDrawChecker(boolean[] firstPlayer, boolean[] secondPlayer) {
        for (int i=0, k=0; i<9; i+= 3, k++) {
            if (firstPlayer[i] && firstPlayer[i+1] && firstPlayer[i+2]) { notEndFlag = false; return k; }
            if (firstPlayer[k] && firstPlayer[k+3] && firstPlayer[k+6]) { notEndFlag = false; return k+3; }
        }
        if (firstPlayer[0] && firstPlayer[4] && firstPlayer[8]) { notEndFlag = false; return 6; }
        if (firstPlayer[2] && firstPlayer[4] && firstPlayer[6]) { notEndFlag = false; return 7; }

        if(drawChecking(firstPlayer, secondPlayer)){  return 8; }
        return -1;
    }

    protected boolean drawChecking(boolean[] firstPlayer, boolean[] secondPlayer){
        boolean draw = true;
        for(int i=0; i<9; i++){ draw = draw && (firstPlayer[i] || secondPlayer[i]); }
        if(draw) notEndFlag = false;
        return draw;
    }

    protected boolean getNotEndFlag(){ return notEndFlag; }
}
