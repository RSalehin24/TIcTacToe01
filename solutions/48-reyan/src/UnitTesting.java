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
        boolean[] occupiedHuman = new boolean[9];
        boolean[] occupiedAI = new boolean[9];
        for(int i=0;i<8; i++) occupiedHuman[i] = true;

        int randomTileNo =  randomAIPlayer.getAIPlayerTileNo(occupiedHuman, occupiedAI);

        Assertions.assertEquals(8, randomTileNo);
    }

    @Test
    public void testDefensiveAIPlayer(){
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[] occupiedHuman = new boolean[9];
        boolean[] occupiedAI = new boolean[9];
        occupiedHuman[4] = true;
        occupiedHuman[3] = true;
        occupiedHuman[6] = true;
        Assertions.assertEquals(5, defensiveAIPlayer.getAIPlayerTileNo(occupiedHuman, occupiedAI));
    }

    @Test
    public void testGameLogicForWinning(){
        GameLogicForWinning gameLogicForWinning = new GameLogicForWinning();
        boolean[] occupiedHuman = new boolean[9];
        boolean[] occupiedAI = new boolean[9];
        occupiedHuman[4] = true;
        occupiedHuman[3] = true;
        occupiedHuman[5] = true;

        Assertions.assertEquals(1, gameLogicForWinning.winnerDrawChecker(occupiedHuman));
    }

    @Test
    public void testDrawChecking(){
        GameLogicForWinning gameLogicForWinning = new GameLogicForWinning();
        boolean[] occupiedHuman = new boolean[9];
        boolean[] occupiedAI = new boolean[9];
        for(int i=0,j=1;i<8; i+=2, j+=2){
            occupiedHuman[i] = true;
            occupiedAI[j] = true;
        }
        occupiedHuman[8] = true;

        Assertions.assertEquals(true, gameLogicForWinning.drawChecking(occupiedHuman, occupiedAI));
    }
}
