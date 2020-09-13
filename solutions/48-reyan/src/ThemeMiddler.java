import javafx.scene.paint.Color;

public abstract class ThemeMiddler implements Theme {
    private GameStage gameStage;
    private Tile[] tiles;

    protected ThemeMiddler(GameStage gameStage){
        this.gameStage = gameStage;
        tiles = gameStage.getTiles();
    }

    public void prepareTileToGetChanged(Color lineColor){
        gameStage.removeExtensionsFromTiles(lineColor);
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                changePlayerSign(tiles[i]);
            }
        }
    }

    public void changePlayerSign(Tile tile){}
    public void makeMoveInATile(Tile tile){}
    public void aiPlayer(){}
    public void setPlayerInTile(Tile tile, String string, Color color, boolean isHuman){}
    public Tile[] getThemeTiles(){ return tiles; }
}
