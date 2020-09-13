import java.util.Random;

public class RandomAIPlayer implements AIPlayer{

    public int getAIPlayerTileNo(boolean[][] occupiedTiles) {
        Random random = new Random();
        int randomTileNo = random.nextInt(9);

        for(int i=0; i<100; i++){
            randomTileNo = random.nextInt(9);
            if(!(occupiedTiles[0][randomTileNo] || occupiedTiles[1][randomTileNo])){
                break;
            }
        }
        return randomTileNo;
    }
}
