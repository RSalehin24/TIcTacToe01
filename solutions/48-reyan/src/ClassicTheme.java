import javafx.scene.paint.Color;

public class ClassicTheme {

    private Tile[] tiles;
    private GameStage gameStage;

    protected ClassicTheme(GameStage gameStage){
        this.gameStage = gameStage;
        this.tiles = gameStage.getTiles();
        gameStage.thingsToChangeForTheme(Color.WHITE, Color.BLACK);
        changePlayerSign();
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){ tiles[i].setPlayerText("X"); }
                else { tiles[i].setPlayerText("O");}
            }
        }
    }


}
