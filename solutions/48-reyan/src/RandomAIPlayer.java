import java.util.Random;

public class RandomAIPlayer implements AIPlayer{

    public int getAIPlayerTileNo(boolean[] occupiedHuman, boolean[] occupiedAI) {
        Random random = new Random();
        int randomTileNo = random.nextInt(9);

        for(int i=0; i<100; i++){
            randomTileNo = random.nextInt(9);
            if(!(occupiedHuman[randomTileNo] || occupiedAI[randomTileNo])){
                break;
            }
        }
        return randomTileNo;
    }
}
