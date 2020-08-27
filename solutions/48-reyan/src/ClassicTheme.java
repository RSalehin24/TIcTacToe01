import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ClassicTheme implements Theme {

    private Tile[] tiles;

    private GameLogicForWinning gameLogicForWinning;
    private AIPlayer aiPlayer;
    private GameCurrentState gameCurrentState;
    private GameStage gameStage;

    protected ClassicTheme(GameStage gameStage, AIPlayer aiPlayer){
        this.gameStage = gameStage;
        this.aiPlayer = aiPlayer;
        tiles = gameStage.getTiles();

        gameLogicForWinning = new GameLogicForWinning();
        gameLogicForWinning.initializeGameWinningLogic(gameStage);
        gameCurrentState = new GameCurrentState(tiles);

        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.WHITE, Color.BLACK);
        changePlayerSign();
        gameStage.setThemeInTilesByThemeType(this);
    }

    private void changePlayerSign(){
        gameStage.removeExtensions(Color.WHITE);
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    tiles[i].setText("X");
                }
                else { tiles[i].setText("O");}
            }
        }
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile, "X",null,true);
        if(gameLogicForWinning.getEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(gameCurrentState.getOccupiedHuman(), gameCurrentState.getOccupiedAI());
        setPlayerInTile(tiles[tileNo], "O", null,false);
    }

    public void setPlayerInTile(Tile tile, String playerSymbol, Color color, boolean isHuman){
        if(!tile.getIsOccupied()){
            tile.setText(playerSymbol);
            tile.setHasText(true);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameLogicForWinning.gameEndChecker(Color.BLACK);
        }
    }
}
