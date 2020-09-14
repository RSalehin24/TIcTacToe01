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
        int combinationNo = drawWinChecker.winnerDrawChecker(currentStateOfGame.getOccupiedTiles()[0], currentStateOfGame.getOccupiedTiles()[1]);
        boolean isNotEnd = gameEndingWorks.gameEndSceneSetter(combinationNo, color, 0);
        if(isNotEnd){
            combinationNo = drawWinChecker.winnerDrawChecker(currentStateOfGame.getOccupiedTiles()[1], currentStateOfGame.getOccupiedTiles()[0]);
            gameEndingWorks.gameEndSceneSetter(combinationNo, color, 1);
        }
    }

    protected DrawWinChecker getDrawWinChecker(){
        return drawWinChecker;
    }
}
