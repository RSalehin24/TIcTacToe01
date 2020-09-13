public class CurrentStateOfGame {

    private Tile[] tiles;

    protected CurrentStateOfGame(Tile[] tiles){
        this.tiles = tiles;
    }

    protected boolean[][] getOccupiedTiles(){

        boolean[][] occupiedTiles= new boolean[2][9];

        occupiedTiles[0] = getOccupiedTilesByPlayer(true);
        occupiedTiles[1] = getOccupiedTilesByPlayer(false);

        return occupiedTiles;
    }

    private boolean[] getOccupiedTilesByPlayer(boolean isHuman){
        boolean[] occupiedTile = new boolean[9];
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(isHuman){
                    if(tiles[i].getIsHuman()) {
                        occupiedTile[i] = true;
                    }
                } else {
                    if(!tiles[i].getIsHuman()) {
                        occupiedTile[i] = true;
                    }
                }
            }
        }
        return occupiedTile;
    }
}
