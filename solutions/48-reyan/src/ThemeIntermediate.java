import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public abstract class ThemeIntermediate implements Theme {

    private Tile[] tiles;
    private Line[] lines;

    private AIPlayer aiPlayer;
    private GameEndChecker gameEndChecker;
    private CurrentStateOfGame currentStateOfGame;

    protected ThemeIntermediate(GameStage gameStage, AIPlayer aiPlayer){
        tiles = gameStage.getTiles();
        lines = gameStage.getLines();
        this.aiPlayer = aiPlayer;

        gameEndChecker = new GameEndChecker();
        gameEndChecker.initializeGameEndChecker(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);
    }

    public void thingsToChangePerTheme(Pane gamePane, Color colorOfPane, Color colorOfLine){
        gamePane.setBackground(new Background((new BackgroundFill(colorOfPane, CornerRadii.EMPTY, Insets.EMPTY))));
        for(int i=0; i<4; i++){
            lines[i].setStroke(colorOfLine);
        }
    }

    public void prepareTileAndChangeThemePlayerSign(Color tileBackGroundColor){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                tiles[i].removeExtensionsFromTile(tileBackGroundColor);
                changePlayerSign(tiles[i]);
            }
        }
    }

    private void changePlayerSign(Tile tile){
        if(tile.getIsHuman()){
            setChangedHumanPlayer(tile);
        }
        else{
            setChangedAIPlayer(tile);
        }
    }

    public void setThemeInTiles(Theme theme){
        for(int i=0; i<9; i++){
            tiles[i].setTheme(theme);
        }
    }

    public void makeMoveInATile(Tile tile){
        setHumanPlayer(tile);
        if(gameEndChecker.getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getTilesOccupiedByPlayers());
        setAIPlayer(tiles[tileNo]);
    }

    public void setPlayerInTile(Tile tile, String playerSymbol, Color tileBackGroundColor, Color lineColor, boolean isHuman){
        if(!tile.getIsOccupied()){
            setThemePlayer(tile, playerSymbol, tileBackGroundColor);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameEndChecker.gameEndChecker(lineColor);
        }
    }

    protected void setHumanPlayer(Tile tile){}
    protected void setAIPlayer(Tile tile){}
    protected void setThemePlayer(Tile tile, String playerSymbol, Color tileBackGroundColor){}

    public void setChangedHumanPlayer(Tile tile){}
    public void setChangedAIPlayer(Tile tile){}
}
