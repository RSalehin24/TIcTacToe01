import javafx.scene.paint.Color;

public abstract class ThemeMiddler implements Theme {
    private GameStage gameStage;
    private Tile[] tiles;

    protected ThemeMiddler(GameStage gameStage){
        this.gameStage = gameStage;
        tiles = gameStage.getTiles();
    }

    public void prepareTileToGetChanged(Color tileBackGroundColor){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                tiles[i].removeExtensionsFromTile(tileBackGroundColor);
                changePlayerSign(tiles[i]);
            }
        }
    }

    public void changePlayerSign(Tile tile){}
    public void setChangedPlayer(Tile tile, String string, Color backGroundColor){}
    public void makeMoveInATile(Tile tile){}
    public void aiPlayer(){}
    public void setPlayerInTile(Tile tile, String string, Color color, boolean isHuman){}
    protected Tile[] getThemeTiles(){ return tiles; }
}
