import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HighContrastTheme extends ThemeMiddler {

    private Tile[] tiles;

    private GameEndChecker gameEndChecker;
    private CurrentStateOfGame currentStateOfGame;
    private GameStage gameStage;
    private AIPlayer aiPlayer;


    protected HighContrastTheme(GameStage gameStage, AIPlayer aiPlayer) {
        super(gameStage);
        this.aiPlayer = aiPlayer;
        tiles = super.getThemeTiles();

        gameEndChecker = new GameEndChecker();
        gameEndChecker.initializeGameLogicForWinning(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);

        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.DARKGREY, Color.LIGHTGREY);
        super.prepareTileToGetChanged(Color.DARKGREY);
        gameStage.setThemeInTiles(this);
    }

    public void changePlayerSign(Tile tile) {
        if (tile.getIsHuman()) {
            setChangedPlayer(tile, null, Color.BLACK);
        } else {
            setChangedPlayer(tile, null, Color.WHITE);
        }
    }

    public void setChangedPlayer(Tile tile, String string, Color backGroundColor){
        tile.setBackground(new Background(new BackgroundFill(backGroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile, null, Color.BLACK, true);
        if(gameEndChecker.getDrawWinChecker().getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getOccupiedTiles());
        setPlayerInTile(tiles[tileNo], null, Color.WHITE, false);
    }

    public void setPlayerInTile(Tile tile, String string, Color playerSpecifiedColor, boolean isHuman){
        if(!tile.getIsOccupied()){
            tile.setBackground(new Background(new BackgroundFill(playerSpecifiedColor, CornerRadii.EMPTY, Insets.EMPTY)));
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameEndChecker.gameEndChecker(Color.DARKGREY);
        }
    }
}
