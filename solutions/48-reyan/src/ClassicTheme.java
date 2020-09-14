import javafx.scene.paint.Color;

public class ClassicTheme extends ThemeMiddler {

    private Tile[] tiles;

    private GameEndChecker gameEndChecker;
    private CurrentStateOfGame currentStateOfGame;
    private AIPlayer aiPlayer;

    protected ClassicTheme(GameStage gameStage, AIPlayer aiPlayer){
        super(gameStage);
        this.aiPlayer = aiPlayer;
        tiles = super.getThemeTiles();

        gameEndChecker = new GameEndChecker();
        gameEndChecker.initializeGameLogicForWinning(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);

        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.WHITE, Color.BLACK);
        super.prepareTileToGetChanged(Color.WHITE);
        gameStage.setThemeInTiles(this);
    }

    public void changePlayerSign(Tile tile) {
        if(tile.getIsHuman()){
            setChangedPlayer(tile, "X", null);
        }
        else{
            setChangedPlayer(tile, "O", null);
        }
    }

    public void setChangedPlayer(Tile tile, String string, Color backGroundColor){
        tile.setText(string);
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile, "X",null,true);
        if(gameEndChecker.getDrawWinChecker().getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getOccupiedTiles());
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
