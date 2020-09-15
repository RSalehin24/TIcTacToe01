import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomAIPlayerTest {

    @Test
    void getAIPlayerTileNo8() {
        RandomAIPlayer randomAIPlayer = new RandomAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        for(int i=0;i<7; i=i+2) occupiedTiles[0][i] = true;
        for(int i=1;i<9; i=i+2) occupiedTiles[1][i] = true;

        Assertions.assertEquals(8, randomAIPlayer.getAIPlayerTileNo(occupiedTiles));
    }

    @Test
    void getAIPlayerTileNo4() {
        RandomAIPlayer randomAIPlayer = new RandomAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        for(int i=0;i<9; i=i+2) {
            if(i==4) continue;
            occupiedTiles[0][i] = true;
        }
        for(int i=1;i<9; i=i+2) occupiedTiles[1][i] = true;

        Assertions.assertEquals(4, randomAIPlayer.getAIPlayerTileNo(occupiedTiles));
    }

    @Test
    void getAIPlayerTileNo1() {
        RandomAIPlayer randomAIPlayer = new RandomAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        for(int i=0;i<9; i=i+2) occupiedTiles[0][i] = true;

        for(int i=1;i<9; i=i+2) {
            if(i==1) continue;
            occupiedTiles[1][i] = true;
        }

        Assertions.assertEquals(1, randomAIPlayer.getAIPlayerTileNo(occupiedTiles));
    }

    @Test
    void getAIPlayerBetween(){
        RandomAIPlayer randomAIPlayer = new RandomAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][3] = true;
        occupiedTiles[1][5] = true;

        boolean isBetween = false;
        int tileNo = randomAIPlayer.getAIPlayerTileNo(occupiedTiles);
        if((tileNo>=0 && tileNo<=2) || (tileNo==4) || (tileNo>=6 && tileNo<=8)) isBetween = true;

        Assertions.assertTrue(isBetween);
    }
}