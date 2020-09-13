public class DrawWinChecker {

    private boolean notEndFlag;

    protected DrawWinChecker(){
        notEndFlag = true;
    }

    protected int winnerDrawChecker(boolean[] firstPlayer, boolean[] secondPlayer) {
        int combinationNo = -1;
        combinationNo = horizontalAndVerticalCombination(combinationNo, firstPlayer);
        combinationNo = mainDiagonalCombination(combinationNo, firstPlayer);
        combinationNo = auxiliaryDiagonalCombination(combinationNo, firstPlayer);
        combinationNo = drawChecking(combinationNo, firstPlayer,secondPlayer);
        return combinationNo;
    }

    private int horizontalAndVerticalCombination(int combinationNo, boolean[] firstPlayer){
        for (int i=0, k=0; i<9; i+= 3, k++) {
            combinationNo = checkingIfAllTilesHasMatchedInACombination(combinationNo, k, i, i+1, i+2, firstPlayer);
            combinationNo = checkingIfAllTilesHasMatchedInACombination(combinationNo,k+3, k, k+3, k+6, firstPlayer);
        }
        return combinationNo;
    }

    private int mainDiagonalCombination(int combinationNo, boolean[] firstPlayer){
        combinationNo = checkingIfAllTilesHasMatchedInACombination(combinationNo, 6, 0, 4, 8, firstPlayer);
        return combinationNo;
    }

    private int auxiliaryDiagonalCombination(int combinationNo, boolean[] firstPlayer){
        combinationNo = checkingIfAllTilesHasMatchedInACombination(combinationNo, 7, 2, 4, 6, firstPlayer);
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

    private int checkingIfAllTilesHasMatchedInACombination(int combinationNo, int updatedCombinationNo, int tileOne, int tileTwo, int tileThree, boolean[] firstPlayer){
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
