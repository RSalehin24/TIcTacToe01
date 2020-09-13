import javafx.scene.paint.Color;

public interface Theme {

    void prepareTileToGetChanged(Color lineColor);
    void changePlayerSign(Tile tile);
    void makeMoveInATile(Tile tile);
    void aiPlayer();
    void setPlayerInTile(Tile tile, String string, Color color, boolean isHuman);

}

