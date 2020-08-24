public class GameLogicForWinning {
    protected void obtainingPlayerFromTiles(Tile[] tiles, boolean[] occupiedHuman, boolean[] occupiedAI){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()) {
                    occupiedHuman[i] = true;
                } else {
                    occupiedAI[i] = true;
                }
            }
        }
    }
}
