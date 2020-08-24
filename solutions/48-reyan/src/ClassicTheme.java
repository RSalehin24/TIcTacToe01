import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ClassicTheme implements Theme {

    private Tile[] tiles;
    private RandomAIPlayer randomAIPlayer;
    private GameLogicForWinning gameLogicForWinning;

    protected ClassicTheme(GameStage gameStage){
        this.tiles = gameStage.getTiles();
        this.randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        this.gameLogicForWinning = new GameLogicForWinning(gameStage);
        gameStage.thingsToChangeForTheme(gameStage.getPaneOfGame(), Color.WHITE, Color.BLACK);
        changePlayerSign();
        gameStage.setTheme(this);
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getImageViewIdentifier()) { tiles[i].getChildren().remove(tiles[i].getImageView()); }
                if(tiles[i].getIsHuman()){
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    tiles[i].setClassicPlayer("X");
                }
                else { tiles[i].setClassicPlayer("O");}
            }
        }
    }

    public void gameFunctionThemeBasedPlayer(Tile tile){
        if(!tile.getIsOccupied()){
            tile.setClassicPlayer("X");
            tile.setIsOccupied(true);
            tile.setIsHuman(true);
            gameLogicForWinning.gameEndChecker(Color.BLACK);
        }
        if(!gameLogicForWinning.getEndFlag())randomAIPlayerClassic();
    }

    private void randomAIPlayerClassic(){
        Tile tile;
        tile = randomAIPlayer.getPlayerTile();
        if(!tile.getIsOccupied()) {
            tile.setClassicPlayer("O");
            tile.setClassicPlayerIdentifier(true);
            tile.setIsOccupied(true);
            gameLogicForWinning.gameEndChecker(Color.BLACK);
        }
    }
}
