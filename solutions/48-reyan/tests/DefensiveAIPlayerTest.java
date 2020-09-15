import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefensiveAIPlayerTest {

    @Test
    void getAIPlayerTileNo() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][2] = true;
        occupiedTiles[1][4] = true;
        occupiedTiles[0][6] = true;
        occupiedTiles[0][8] = true;


        Assertions.assertEquals(7, defensiveAIPlayer.getAIPlayerTileNo(occupiedTiles));
    }

    @Test
    void checkTileNoFour() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][2] = true;
        int tileNo = -1;
        Assertions.assertEquals(4, defensiveAIPlayer.checkTileNoFour(tileNo, occupiedTiles));
    }

    @Test
    void checkRowTiles() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][4] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][5] = true;
        int tileNo = -1;
        Assertions.assertEquals(3, defensiveAIPlayer.checkRowTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][4] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][3] = true;
        tileNo = -1;
        Assertions.assertEquals(5, defensiveAIPlayer.checkRowTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][6] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][8] = true;
        tileNo = -1;
        Assertions.assertEquals(7, defensiveAIPlayer.checkRowTiles(tileNo, occupiedTiles));
    }

    @Test
    void checkColumnTiles() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][5] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][8] = true;
        int tileNo = -1;
        Assertions.assertEquals(2, defensiveAIPlayer.checkColumnTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][2] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][5] = true;
        tileNo = -1;
        Assertions.assertEquals(8, defensiveAIPlayer.checkColumnTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][3] = true;
        occupiedTiles[1][2] = true;
        occupiedTiles[0][6] = true;
        tileNo = -1;
        Assertions.assertEquals(0, defensiveAIPlayer.checkColumnTiles(tileNo, occupiedTiles));
    }

    @Test
    void checkMainDiagonalTiles() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][4] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][8] = true;
        int tileNo = -1;
        Assertions.assertEquals(0, defensiveAIPlayer.checkMainDiagonalTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][4] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][0] = true;
        tileNo = -1;
        Assertions.assertEquals(8,  defensiveAIPlayer.checkMainDiagonalTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][0] = true;
        occupiedTiles[1][2] = true;
        occupiedTiles[0][8] = true;
        tileNo = -1;
        Assertions.assertEquals(4,  defensiveAIPlayer.checkMainDiagonalTiles(tileNo, occupiedTiles));
    }

    @Test
    void checkAuxiliaryDiagonalTiles() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][4] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][6] = true;
        int tileNo = -1;
        Assertions.assertEquals(2, defensiveAIPlayer.checkAuxiliaryDiagonalTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][4] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][2] = true;
        tileNo = -1;
        Assertions.assertEquals(6, defensiveAIPlayer.checkAuxiliaryDiagonalTiles(tileNo, occupiedTiles));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][2] = true;
        occupiedTiles[1][2] = true;
        occupiedTiles[0][6] = true;
        tileNo = -1;
        Assertions.assertEquals(4, defensiveAIPlayer.checkAuxiliaryDiagonalTiles(tileNo, occupiedTiles));
    }

    @Test
    void checkIfTwoTilesHaveMatched() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][8] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][7] = true;
        int tileNo = -1;
        Assertions.assertEquals(6, defensiveAIPlayer.checkIfTwoTilesHaveMatched(tileNo, occupiedTiles,7, 8,6));
    }

    @Test
    void returnRandomTileNo() {
        DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][8] = true;
        occupiedTiles[1][1] = true;
        occupiedTiles[0][2] = true;

        int tileNo = -1;
        boolean isBetween = false;
        tileNo = defensiveAIPlayer.returnRandomTileNo(tileNo, occupiedTiles);
        if( (tileNo >=0 && tileNo <=1) || (tileNo>=3 && tileNo<=7) ) isBetween = true;

        Assertions.assertTrue(isBetween);
    }
}