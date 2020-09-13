import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTesting {

    @Test
    public void testDetermineString(){
        GameEndingScene gameEndingScene = new GameEndingScene();
        String stringOne = "Yahoo!!!";
        String stringTwo = "Sorry!";
        String stringThree = "Hmm!";

        Assertions.assertEquals("Yahoo!!!", gameEndingScene.determineLabelString(0, stringOne, stringTwo, stringThree));
    }

    @Test
    public void testRandomAIPlayer(){
        RandomAIPlayer randomAIPlayer = new RandomAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        for(int i=0;i<8; i++) occupiedTiles[0][i] = true;

        int randomTileNo =  randomAIPlayer.getAIPlayerTileNo(occupiedTiles);

        Assertions.assertEquals(8, randomTileNo);
    }

    @Test
    public void testDefensiveAIPlayer(){
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][4] = true;
        occupiedTiles[0][3] = true;
        occupiedTiles[0][6] = true;
        Assertions.assertEquals(0, defensiveAIPlayer.getAIPlayerTileNo(occupiedTiles));
    }

    @Test
    public void textWinnerDrawChecker(){
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][4] = true;
        occupiedTiles[0][3] = true;
        occupiedTiles[0][5] = true;

        Assertions.assertEquals(1, drawWinChecker.winnerDrawChecker(occupiedTiles[0], occupiedTiles[1]));
    }

    @Test
    public void testDrawChecking(){
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        for(int i=0,j=1;i<8; i+=2, j+=2){
            occupiedTiles[0][i] = true;
            occupiedTiles[1][j] = true;
        }
        occupiedTiles[0][8] = true;

        Assertions.assertEquals(8, drawWinChecker.drawChecking(-1, occupiedTiles[0], occupiedTiles[1]));
    }
}
