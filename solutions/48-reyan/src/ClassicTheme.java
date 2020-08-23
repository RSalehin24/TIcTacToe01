import javafx.scene.paint.Color;

public class ClassicTheme implements Theme {

    private Tile[] tiles;
    private RandomAIPlayer randomAIPlayer;

    protected ClassicTheme(GameStage gameStage){
        this.tiles = gameStage.getTiles();
        randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        gameStage.thingsToChangeForTheme(Color.WHITE, Color.BLACK);
        changePlayerSign();
        gameStage.setTheme(this);
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){ tiles[i].setPlayerText("X"); }
                else { tiles[i].setPlayerText("O");}
            }
        }
    }

    public void gameFunctionThemeBasedPlayer(Tile tile){
        if(!tile.getIsOccupied()){
            tile.setPlayerText("X");
            tile.setIsOccupied(true);
            tile.setIsHuman(true);
        }
        randomAIPlayerClassic();
    }

    private void randomAIPlayerClassic(){
        Tile tile;
        tile = randomAIPlayer.getPlayerTile();
        if(!tile.getIsOccupied()) {
            tile.setPlayerText("O");
            tile.setIsOccupied(true);
        }
    }
}
