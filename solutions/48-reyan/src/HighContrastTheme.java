import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HighContrastTheme extends ThemeIntermediate {

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
        gameEndChecker.initializeGameEndChecker(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);

        super.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.DARKGREY, Color.LIGHTGREY);
        super.prepareTileAndChangeThemePlayerSign(Color.DARKGREY);
        super.setThemeInTiles(this);
    }

    public void setChangedHumanPlayer(Tile tile){
        tile.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setChangedAIPlayer(Tile tile){
        tile.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile, null, Color.BLACK, true);
        if(gameEndChecker.getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getTilesOccupiedByPlayers());
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
