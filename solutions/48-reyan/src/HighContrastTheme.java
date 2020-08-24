import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HighContrastTheme implements Theme{

    private Tile[] tiles;
    private boolean isDefensivePlayerAI;

    private RandomAIPlayer randomAIPlayer;
    private DefensiveAIPlayer defensiveAIPlayer;
    private GameLogicForWinning gameLogicForWinning;



    protected HighContrastTheme(GameStage gameStage,boolean isDefensivePlayerAI){
        this.isDefensivePlayerAI = isDefensivePlayerAI;
        randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        defensiveAIPlayer = new DefensiveAIPlayer(gameStage);
        gameLogicForWinning = new GameLogicForWinning(gameStage);
        tiles = gameStage.getTiles();
        gameStage.thingsToChangeForTheme(gameStage.getPaneOfGame(), Color.DARKGREY, Color.LIGHTGREY);
        changePlayerSignToHighContrast();
        gameStage.setTheme(this);
    }

    private void changePlayerSignToHighContrast(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsPlayerInForest()) { tiles[i].getChildren().remove(tiles[i].getPlayerInForest()); }
                if(tiles[i].getIsHuman()){
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                }
                else {
                    if(tiles[i].getPlayerInClassic()) tiles[i].setPlayerInClassic("");
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    public void setPlayerByThemeType(Tile tile){
        setPlayerInTileHighContrast(tile, Color.BLACK, true);
        if(gameLogicForWinning.getEndFlag()) randomAIPlayerHighContrast();
    }

    private void randomAIPlayerHighContrast(){
        Tile tile;
        if(isDefensivePlayerAI) tile = defensiveAIPlayer.getPlayerTile();
        else tile = randomAIPlayer.getPlayerTile();
        setPlayerInTileHighContrast(tile, Color.WHITE, false);
    }

    private void setPlayerInTileHighContrast(Tile tile, Color playerSpecifiedColor, boolean isHuman){
        if(!tile.getIsOccupied()){
            tile.setBackground(new Background(new BackgroundFill(playerSpecifiedColor, CornerRadii.EMPTY, Insets.EMPTY)));
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameLogicForWinning.gameEndChecker(Color.DARKGREY);
        }
    }
}
