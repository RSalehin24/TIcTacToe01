import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ClassicTheme implements Theme {

    private Tile[] tiles;
    private boolean isDefensivePlayerAI;

    private RandomAIPlayer randomAIPlayer;
    private DefensiveAIPlayer defensiveAIPlayer;
    private GameLogicForWinning gameLogicForWinning;

    protected ClassicTheme(GameStage gameStage, boolean isDefensivePlayerAI){
        this.isDefensivePlayerAI = isDefensivePlayerAI;
        randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        defensiveAIPlayer = new DefensiveAIPlayer(gameStage);
        gameLogicForWinning = new GameLogicForWinning(gameStage);
        tiles = gameStage.getTiles();
        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.WHITE, Color.BLACK);
        changePlayerSignToClassic();
        gameStage.setTheme(this);
    }

    private void changePlayerSignToClassic(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsPlayerInForest()) { tiles[i].getChildren().remove(tiles[i].getPlayerInForest()); }
                if(tiles[i].getIsHuman()){
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    tiles[i].setPlayerInClassic("X");
                }
                else { tiles[i].setPlayerInClassic("O");}
            }
        }
    }

    public void setPlayerByThemeType(Tile tile){
        setPlayerInTileClassic(tile, "X", true);
        if(gameLogicForWinning.getEndFlag()) randomAIPlayerClassic();
    }

    private void randomAIPlayerClassic(){
        Tile tile;
        if(isDefensivePlayerAI) tile = defensiveAIPlayer.getPlayerTile();
        else tile = randomAIPlayer.getPlayerTile();
        setPlayerInTileClassic(tile, "O", false);
    }

    private void setPlayerInTileClassic(Tile tile, String playerSymbol, boolean isHuman){
        if(!tile.getIsOccupied()){
            tile.setPlayerInClassic(playerSymbol);
            tile.setPlayerInClassic(true);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameLogicForWinning.gameEndChecker(Color.BLACK);
        }
    }
}
