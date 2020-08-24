public class DefensiveAIPlayer {

    private Tile[] tiles;
    private boolean[] occupiedHuman;
    private boolean[] occupiedAI;
    private RandomAIPlayer randomAIPlayer;
    private GameLogicForWinning gameLogicForWinning;

    public DefensiveAIPlayer(GameStage gameStage){
        this.tiles = gameStage.getTiles();
        randomAIPlayer = new RandomAIPlayer(tiles);
        gameLogicForWinning = new GameLogicForWinning(gameStage);
        occupiedHuman = new boolean[9];
        occupiedAI = new boolean[9];
    }

    protected Tile getPlayerTile(){
        gameLogicForWinning.obtainingPlayerFromTiles(tiles, occupiedHuman, occupiedAI);
        if(!tiles[4].getIsOccupied()) return tiles[4];
        for (int i=0; i<9; i += 3) {
            if(occupiedHuman[i] && occupiedHuman[i+1]){ if(!tiles[i+2].getIsOccupied()) return tiles[i+2]; }
            else if(occupiedHuman[i] && occupiedHuman[i+2]){ if(!tiles[i+1].getIsOccupied()) return tiles[i+1]; }
            else if(occupiedHuman[i+1] && occupiedHuman[i+2]){ if(!tiles[i].getIsOccupied()) return tiles[i]; }
        }

        for(int i=0, j=0; i<3; i++, j+=109){
            if(occupiedHuman[i] && occupiedHuman[i+3]){ if(!tiles[i+6].getIsOccupied()) return tiles[i+6]; }
            else if(occupiedHuman[i] && occupiedHuman[i+6]){ if(!tiles[i+3].getIsOccupied()) return tiles[i+3]; }
            else if(occupiedHuman[i+3] && occupiedHuman[i+6]){ if(!tiles[i].getIsOccupied()) return tiles[i]; }
        }

        if(occupiedHuman[0] && occupiedHuman[4]){ if(!tiles[8].getIsOccupied()) return tiles[8]; }
        else if(occupiedHuman[0] && occupiedHuman[8]){ if(!tiles[4].getIsOccupied()) return tiles[4]; }
        else if(occupiedHuman[4] && occupiedHuman[8]){ if(!tiles[0].getIsOccupied()) return tiles[0]; }

        if(occupiedHuman[2] && occupiedHuman[4]){ if(!tiles[6].getIsOccupied()) return tiles[6]; }
        else if(occupiedHuman[2] && occupiedHuman[6]){ if(!tiles[4].getIsOccupied()) return tiles[4]; }
        else if(occupiedHuman[4] && occupiedHuman[6]){ if(!tiles[2].getIsOccupied()) return tiles[2]; }

        return randomAIPlayer.getPlayerTile();
    }

}
