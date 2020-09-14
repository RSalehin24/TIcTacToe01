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

    private GameEndChecker gameEndChecker;
    private CurrentStateOfGame currentStateOfGame;

    protected ThemeIntermediate(GameStage gameStage){
        tiles = gameStage.getTiles();
        lines = gameStage.getLines();

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

    protected Tile[] getThemeTiles(){
        return tiles;
    }

    protected GameEndChecker getGameEndChecker() {
        return gameEndChecker;
    }

    protected CurrentStateOfGame getCurrentStateOfGame(){
        return currentStateOfGame;
    }

    public void setChangedHumanPlayer(Tile tile){}
    public void setChangedAIPlayer(Tile tile){}
    public void makeMoveInATile(Tile tile){}
    public void aiPlayer(){}
    public void setPlayerInTile(Tile tile, String string, Color color, boolean isHuman){}

}
