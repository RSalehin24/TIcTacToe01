import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HighContrastTheme implements Theme{
    private Tile[] tiles;
    private RandomAIPlayer randomAIPlayer;
    private GameLogicForWinning gameLogicForWinning;

    protected HighContrastTheme(GameStage gameStage){
        this.tiles = gameStage.getTiles();
        this.randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        this.gameLogicForWinning = new GameLogicForWinning(gameStage);
        gameStage.thingsToChangeForTheme(gameStage.getPaneOfGame(), Color.LIGHTGREY, Color.GREY);
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
        if(!gameLogicForWinning.getEndFlag()) randomAIPlayerHighContrast();
    }

    private void randomAIPlayerHighContrast(){
        Tile tile;
        tile = randomAIPlayer.getPlayerTile();
        if(!tile.getIsOccupied()) {
            tile.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            tile.setIsOccupied(true);
            gameLogicForWinning.gameEndChecker(Color.DARKGREY);
        }
    }
}
