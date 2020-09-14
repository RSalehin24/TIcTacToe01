public class CurrentStateOfGame {

    private Tile[] tiles;

    protected CurrentStateOfGame(Tile[] tiles){
        this.tiles = tiles;
    }

    protected boolean[][] getTilesOccupiedByPlayers(){
        boolean[][] occupiedTiles= new boolean[2][9];
        occupiedTiles[0] = getOccupiedTilesPerPlayer(true);
        occupiedTiles[1] = getOccupiedTilesPerPlayer(false);
        return occupiedTiles;
    }

    private boolean[] getOccupiedTilesPerPlayer(boolean isHuman){
        boolean[] occupiedTilesPerPlayer = new boolean[9];
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(isHuman){
                    if(tiles[i].getIsHuman()) {
                        occupiedTilesPerPlayer[i] = true;
                    }
                } else {
                    if(!tiles[i].getIsHuman()) {
                        occupiedTilesPerPlayer[i] = true;
                    }
                }
            }
        }
        return occupiedTilesPerPlayer;
    }
}
