import javafx.scene.paint.Color;

public class ClassicTheme extends ThemeIntermediate {

    private Tile[] tiles;

    private GameEndChecker gameEndChecker;
    private CurrentStateOfGame currentStateOfGame;
    private AIPlayer aiPlayer;

    protected ClassicTheme(GameStage gameStage, AIPlayer aiPlayer){
        super(gameStage);
        this.aiPlayer = aiPlayer;

        tiles = super.getThemeTiles();
        gameEndChecker = super.getGameEndChecker();
        currentStateOfGame = super.getCurrentStateOfGame();

        super.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.WHITE, Color.BLACK);
        super.prepareTileAndChangeThemePlayerSign(Color.WHITE);
        super.setThemeInTiles(this);
    }

    public void setChangedHumanPlayer(Tile tile){
        tile.setText("X");
    }

    public void setChangedAIPlayer(Tile tile){
        tile.setText("O");
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile, "X",null,true);
        if(gameEndChecker.getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getTilesOccupiedByPlayers());
        setPlayerInTile(tiles[tileNo], "O", null,false);
    }

    public void setPlayerInTile(Tile tile, String playerSymbol, Color color, boolean isHuman){
        if(!tile.getIsOccupied()){
            tile.setText(playerSymbol);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameEndChecker.gameEndChecker(Color.BLACK);
        }
    }
}
