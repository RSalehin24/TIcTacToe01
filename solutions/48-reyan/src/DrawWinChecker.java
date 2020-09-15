public class DrawWinChecker {

    private boolean notEndFlag;

    protected DrawWinChecker(){
        notEndFlag = true;
    }

    protected int winnerDrawChecker(boolean[] firstPlayer, boolean[] secondPlayer) {
        int combinationNo = -1;
        combinationNo = checkRowAndColumnTiles(combinationNo, firstPlayer);
        combinationNo = checkMainDiagonalTiles(combinationNo, firstPlayer);
        combinationNo = checkAuxiliaryDiagonalTiles(combinationNo, firstPlayer);
        combinationNo = drawChecking(combinationNo, firstPlayer,secondPlayer);
        return combinationNo;
    }

    protected int checkRowAndColumnTiles(int combinationNo, boolean[] firstPlayer){
        for (int i=0, k=0; i<9; i+= 3, k++) {
            combinationNo = checkingIfThreeTilesHaveMatched(combinationNo, k, i, i+1, i+2, firstPlayer);
            combinationNo = checkingIfThreeTilesHaveMatched(combinationNo,k+3, k, k+3, k+6, firstPlayer);
        }
        return combinationNo;
    }

    protected int checkMainDiagonalTiles(int combinationNo, boolean[] firstPlayer){
        combinationNo = checkingIfThreeTilesHaveMatched(combinationNo, 6, 0, 4, 8, firstPlayer);
        return combinationNo;
    }

    protected int checkAuxiliaryDiagonalTiles(int combinationNo, boolean[] firstPlayer){
        combinationNo = checkingIfThreeTilesHaveMatched(combinationNo, 7, 2, 4, 6, firstPlayer);
        return combinationNo;
    }


    protected int drawChecking(int combinationNo, boolean[] firstPlayer, boolean[] secondPlayer){
        if(combinationNo == -1) {
            boolean draw = true;
            for (int i = 0; i < 9; i++) {
                draw = draw && (firstPlayer[i] || secondPlayer[i]);
            }
            if (draw) {
                combinationNo = 8;
                notEndFlag = false;
            }
        }
        return combinationNo;
    }

    protected int checkingIfThreeTilesHaveMatched(int combinationNo, int updatedCombinationNo, int tileOne, int tileTwo, int tileThree, boolean[] firstPlayer){
        if(combinationNo == -1){
            if (firstPlayer[tileOne] && firstPlayer[tileTwo] && firstPlayer[tileThree]) {
                combinationNo = updatedCombinationNo;
                notEndFlag = false;
            }
        }
        return combinationNo;
    }

    protected boolean getNotEndFlag(){ return notEndFlag; }

}
