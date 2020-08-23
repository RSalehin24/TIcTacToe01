import java.util.Random;

public class RandomAIPlayer {

    private Tile[] tiles;

    public RandomAIPlayer(Tile[] tiles){
        this.tiles = tiles;
    }

    protected Tile getPlayerTile(){
        Random random = new Random();
        int randomTileNo = random.nextInt(9);

        for(int i=0; i<100; i++){
            randomTileNo = random.nextInt(9);
            if(!tiles[randomTileNo].getIsOccupied()){
                break;
            }
        }
        return tiles[randomTileNo];
    }
}
