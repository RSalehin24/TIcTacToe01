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
        changePlayerSign();
        gameStage.setTheme(this);
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getImageViewIdentifier()) { tiles[i].getChildren().remove(tiles[i].getImageView()); }
                if(tiles[i].getIsHuman()){
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                }
                else {
                    if(tiles[i].getClassicPlayerIdentifier()) tiles[i].setClassicPlayer("");
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    public void gameFunctionThemeBasedPlayer(Tile tile){
        if(!tile.getIsOccupied()){
            tile.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            tile.setIsOccupied(true);
            tile.setIsHuman(true);
            gameLogicForWinning.gameEndChecker(Color.DARKGREY);
        }
        if(gameLogicForWinning.getEndFlag()) randomAIPlayerHighContrast();
    }

    private void randomAIPlayerHighContrast(){
        Tile tile;
        if(isDefensivePlayerAI) tile = defensiveAIPlayer.getPlayerTile();
        else tile = randomAIPlayer.getPlayerTile();
        if(!tile.getIsOccupied()) {
            tile.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            tile.setIsOccupied(true);
            gameLogicForWinning.gameEndChecker(Color.DARKGREY);
        }
    }
}
