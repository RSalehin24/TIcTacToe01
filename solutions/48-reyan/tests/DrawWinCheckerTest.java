import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DrawWinCheckerTest {

    @Test
    void winnerDrawChecker() {
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][4] = true;
        occupiedTiles[0][3] = true;
        occupiedTiles[0][5] = true;

        Assertions.assertEquals(1, drawWinChecker.winnerDrawChecker(occupiedTiles[0], occupiedTiles[1]));
    }

    @Test
    void checkRowAndColumnTiles() {
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][0] = true;
        occupiedTiles[0][1] = true;
        occupiedTiles[0][2] = true;
        Assertions.assertEquals(0, drawWinChecker.checkRowAndColumnTiles(-1, occupiedTiles[0]));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][3] = true;
        occupiedTiles[0][4] = true;
        occupiedTiles[0][5] = true;
        Assertions.assertEquals(1, drawWinChecker.checkRowAndColumnTiles(-1, occupiedTiles[0]));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][6] = true;
        occupiedTiles[0][7] = true;
        occupiedTiles[0][8] = true;
        Assertions.assertEquals(2, drawWinChecker.checkRowAndColumnTiles(-1, occupiedTiles[0]));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][0] = true;
        occupiedTiles[0][3] = true;
        occupiedTiles[0][6] = true;
        Assertions.assertEquals(3, drawWinChecker.checkRowAndColumnTiles(-1, occupiedTiles[0]));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][1] = true;
        occupiedTiles[0][4] = true;
        occupiedTiles[0][7] = true;
        Assertions.assertEquals(4, drawWinChecker.checkRowAndColumnTiles(-1, occupiedTiles[0]));

        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = false;
            }
        }
        occupiedTiles[0][2] = true;
        occupiedTiles[0][5] = true;
        occupiedTiles[0][8] = true;
        Assertions.assertEquals(5, drawWinChecker.checkRowAndColumnTiles(-1, occupiedTiles[0]));
    }

    @Test
    void checkMainDiagonalTiles() {
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][0] = true;
        occupiedTiles[0][4] = true;
        occupiedTiles[0][8] = true;
        Assertions.assertEquals(6, drawWinChecker.checkMainDiagonalTiles(-1, occupiedTiles[0]));
    }

    @Test
    void checkAuxiliaryDiagonalTiles() {
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][2] = true;
        occupiedTiles[0][4] = true;
        occupiedTiles[0][6] = true;
        Assertions.assertEquals(7, drawWinChecker.checkAuxiliaryDiagonalTiles(-1, occupiedTiles[0]));
    }

    @Test
    void drawChecking() {
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        for(int i=0; i<2; i++){
            for(int j=0; j<9; j++){
                occupiedTiles[i][j] = true;
            }
        }
        Assertions.assertEquals(8, drawWinChecker.drawChecking(-1, occupiedTiles[0], occupiedTiles[1]));
    }

    @Test
    void checkingIfThreeTilesHaveMatched() {
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][2] = true;
        occupiedTiles[0][4] = true;
        occupiedTiles[0][6] = true;
        Assertions.assertEquals(7, drawWinChecker.checkingIfThreeTilesHaveMatched(-1,7,2,4,6,occupiedTiles[0]));
    }

    @Test
    void getNotEndFlag() {
        DrawWinChecker drawWinChecker = new DrawWinChecker();
        boolean[][] occupiedTiles = new boolean[2][9];
        occupiedTiles[0][2] = true;
        occupiedTiles[0][4] = true;
        occupiedTiles[0][6] = true;

        drawWinChecker.checkingIfThreeTilesHaveMatched(-1,7,2,4,6,occupiedTiles[0]);
        Assertions.assertFalse(drawWinChecker.getNotEndFlag());
    }
}