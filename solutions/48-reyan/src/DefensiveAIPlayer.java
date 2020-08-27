public class DefensiveAIPlayer implements AIPlayer{

    private RandomAIPlayer randomAIPlayer;

    protected DefensiveAIPlayer(){
        randomAIPlayer = new RandomAIPlayer();
    }

    public int getAIPlayerTileNo(boolean[] occupiedHuman, boolean[] occupiedAI){
        if(!(occupiedHuman[4]||occupiedAI[4])) return 4;
        for (int i=0; i<9; i += 3) {
            if(occupiedHuman[i] && occupiedHuman[i+1]){ if(!(occupiedHuman[i+2]||occupiedAI[i+2])) return i+2; }
            else if(occupiedHuman[i] && occupiedHuman[i+2]){ if(!(occupiedAI[i+1])) return i+1; }
            else if(occupiedHuman[i+1] && occupiedHuman[i+2]){ if(!(occupiedAI[i])) return i; }
        }

        for(int i=0; i<3; i++){
            if(occupiedHuman[i] && occupiedHuman[i+3]){ if(!(occupiedHuman[i+6]||occupiedAI[i+6])) return i+6; }
            else if(occupiedHuman[i] && occupiedHuman[i+6]){ if(!(occupiedAI[i+3])) return i+3; }
            else if(occupiedHuman[i+3] && occupiedHuman[i+6]){ if(!(occupiedAI[i])) return i; }
        }

        if(occupiedHuman[0] && occupiedHuman[4]){ if(!(occupiedHuman[8]||occupiedAI[8])) return 8; }
        else if(occupiedHuman[0] && occupiedHuman[8]){ if(!(occupiedAI[4])) return 4; }
        else if(occupiedHuman[4] && occupiedHuman[8]){ if(!(occupiedAI[0])) return 0; }

        if(occupiedHuman[2] && occupiedHuman[4]){ if(!(occupiedHuman[6]||occupiedAI[6])) return 6; }
        else if(occupiedHuman[2] && occupiedHuman[6]){ if(!(occupiedAI[4])) return 4; }
        else if(occupiedHuman[4] && occupiedHuman[6]){ if(!(occupiedAI[2])) return 2; }

        return randomAIPlayer.getAIPlayerTileNo(occupiedHuman, occupiedAI);
    }
}
