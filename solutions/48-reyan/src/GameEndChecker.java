import javafx.scene.paint.Color;

public class GameEndChecker {

    private CurrentStateOfGame currentStateOfGame;
    private GameEndingWorks gameEndingWorks;
    private DrawWinChecker drawWinChecker;


    protected void initializeGameEndChecker(GameStage gameStage){
        currentStateOfGame = new CurrentStateOfGame(gameStage.getTiles());
        gameEndingWorks = new GameEndingWorks(gameStage);
        drawWinChecker = new DrawWinChecker();
    }

    protected void gameEndChecker(Color color) {
        int combinationNo = drawWinChecker.winnerDrawChecker(currentStateOfGame.getTilesOccupiedByPlayers()[0], currentStateOfGame.getTilesOccupiedByPlayers()[1]);
        boolean isNotEnd = gameEndingWorks.gameEndSceneSetter(combinationNo, color, 0);
        if(isNotEnd){
            combinationNo = drawWinChecker.winnerDrawChecker(currentStateOfGame.getTilesOccupiedByPlayers()[1], currentStateOfGame.getTilesOccupiedByPlayers()[0]);
            gameEndingWorks.gameEndSceneSetter(combinationNo, color, 1);
        }
    }

    protected boolean getNotEndFlag(){
        return drawWinChecker.getNotEndFlag();
    }
}
