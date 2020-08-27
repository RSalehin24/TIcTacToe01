public class GameCurrentState {

    private Tile[] tiles;

    protected GameCurrentState(Tile[] tiles){
        this.tiles = tiles;
    }

    protected boolean[] getOccupiedHuman(){
        boolean[] occupiedHuman = new boolean[9];
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()) {
                    occupiedHuman[i] = true;
                }
            }
        }
        return occupiedHuman;
    }

    protected boolean[] getOccupiedAI(){
        boolean[] occupiedAI = new boolean[9];
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(!tiles[i].getIsHuman()) {
                    occupiedAI[i] = true;
                }
            }
        }
        return occupiedAI;
    }
}
