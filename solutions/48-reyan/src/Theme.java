import javafx.scene.paint.Color;

public interface Theme {

    void prepareTileToGetChanged(Color lineColor);
    void changePlayerSign(Tile tile);
    void setChangedPlayer(Tile tile, String string, Color backGroundColor);
    void makeMoveInATile(Tile tile);
    void aiPlayer();
    void setPlayerInTile(Tile tile, String string, Color color, boolean isHuman);

}

