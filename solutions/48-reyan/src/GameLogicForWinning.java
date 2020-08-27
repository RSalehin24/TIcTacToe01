import javafx.scene.paint.Color;

public class GameLogicForWinning {


    private boolean endFlag;

    private CurrentStateOfGame currentStateOfGame;
    private GameEndingWorks gameEndingWorks;


    protected void initializeGameWinningLogic(GameStage gameStage){
        endFlag = true;
        currentStateOfGame = new CurrentStateOfGame(gameStage.getTiles());
        gameEndingWorks = new GameEndingWorks(gameStage);
    }

    protected void gameEndChecker(Color color) {
        int combinationNo = winnerDrawChecker( currentStateOfGame.getOccupiedHuman());
        boolean isEnd = gameEndingWorks.gameEndSceneSetter(combinationNo, color, 0);
        if(isEnd){
            combinationNo = winnerDrawChecker(currentStateOfGame.getOccupiedAI());
            gameEndingWorks.gameEndSceneSetter(combinationNo, color, 1);
        }
    }

    protected int winnerDrawChecker(boolean[] booleanArray) {
        for (int i=0, k=0; i<9; i+= 3, k++) {
            if (booleanArray[i] && booleanArray[i+1] && booleanArray[i+2]) { endFlag = false; return k; }
            if (booleanArray[k] && booleanArray[k+3] && booleanArray[k+6]) { endFlag = false; return k+3; }
        }
        if (booleanArray[0] && booleanArray[4] && booleanArray[8]) { endFlag = false; return 6; }
        if (booleanArray[2] && booleanArray[4] && booleanArray[6]) { endFlag = false; return 7; }

        if(drawChecking(currentStateOfGame.getOccupiedHuman(), currentStateOfGame.getOccupiedAI())){  return 8; }
        return -1;
    }

    protected boolean drawChecking(boolean[] occupiedHuman, boolean[] occupiedAI){
        boolean draw = true;
        for(int i=0; i<9; i++){ draw = draw && (occupiedHuman[i] || occupiedAI[i]); }
        if(draw) endFlag = false;
        return draw;
    }

    protected boolean getEndFlag(){ return endFlag; }
}
