import javafx.scene.paint.Color;

public abstract class ThemeCommonJobs implements Theme {
    private Tile[] tiles;

    protected ThemeCommonJobs(GameStage gameStage){
        tiles = gameStage.getTiles();
    }

    public void prepareAndChangeThemePlayerSign(Color tileBackGroundColor){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                tiles[i].removeExtensionsFromTile(tileBackGroundColor);
                changePlayerSign(tiles[i]);
            }
        }
    }

    private void changePlayerSign(Tile tile){
        if(tile.getIsHuman()){
            setChangedHumanPlayer(tile);
        }
        else{
            setChangedAIPlayer(tile);
        }
    }

    public void setChangedHumanPlayer(Tile tile){}
    public void setChangedAIPlayer(Tile tile){}
    public void makeMoveInATile(Tile tile){}
    public void aiPlayer(){}
    public void setPlayerInTile(Tile tile, String string, Color color, boolean isHuman){}
    protected Tile[] getThemeTiles(){ return tiles; }
}
