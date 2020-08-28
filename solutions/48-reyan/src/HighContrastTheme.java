import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HighContrastTheme implements Theme {

    private Tile[] tiles;

    private GameLogicForWinning gameLogicForWinning;
    private CurrentStateOfGame currentStateOfGame;
    private GameStage gameStage;
    private AIPlayer aiPlayer;


    protected HighContrastTheme(GameStage gameStage, AIPlayer aiPlayer) {
        this.gameStage = gameStage;
        this.aiPlayer = aiPlayer;
        tiles = gameStage.getTiles();

        gameLogicForWinning = new GameLogicForWinning();
        gameLogicForWinning.initializeGameLogicForWinning(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);

        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.DARKGREY, Color.LIGHTGREY);
        changePlayerSign();
        gameStage.setThemeInTiles(this);
    }

    public void changePlayerSign() {
        gameStage.removeExtensionsFromTile(Color.DARKGREY);
        for (int i = 0; i < 9; i++) {
            if(tiles[i].getIsOccupied()){
                if (tiles[i].getIsHuman()) {
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile, null, Color.BLACK, true);
        if(gameLogicForWinning.getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getOccupiedHuman(), currentStateOfGame.getOccupiedAI());
        setPlayerInTile(tiles[tileNo], null, Color.WHITE, false);
    }

    public void setPlayerInTile(Tile tile, String string, Color playerSpecifiedColor, boolean isHuman){
        if(!tile.getIsOccupied()){
            tile.setBackground(new Background(new BackgroundFill(playerSpecifiedColor, CornerRadii.EMPTY, Insets.EMPTY)));
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameLogicForWinning.gameEndChecker(Color.DARKGREY);
        }
    }
}
