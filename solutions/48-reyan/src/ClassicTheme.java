import javafx.scene.paint.Color;

public class ClassicTheme implements Theme {

    private Tile[] tiles;

    private GameLogicForWinning gameLogicForWinning;
    private AIPlayer aiPlayer;
    private CurrentStateOfGame currentStateOfGame;
    private GameStage gameStage;

    protected ClassicTheme(GameStage gameStage, AIPlayer aiPlayer){
        this.gameStage = gameStage;
        this.aiPlayer = aiPlayer;
        tiles = gameStage.getTiles();

        gameLogicForWinning = new GameLogicForWinning();
        gameLogicForWinning.initializeGameWinningLogic(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);

        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.WHITE, Color.BLACK);
        changePlayerSign();
        gameStage.setThemeInTilesByThemeType(this);
    }

    public void changePlayerSign(){
        gameStage.removeExtensions(Color.WHITE);
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){
                    tiles[i].setText("X");
                }
                else { tiles[i].setText("O");}
            }
        }
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile, "X",null,true);
        if(gameLogicForWinning.getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getOccupiedHuman(), currentStateOfGame.getOccupiedAI());
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
