import javafx.scene.paint.Color;

public interface Theme {

    void prepareTileAndChangeThemePlayerSign(Color lineColor);
    void makeMoveInATile(Tile tile);
    void aiPlayer();
    void setPlayerInTile(Tile tile, String string, Color tileBackGroundColor, Color lineColor, boolean isHuman);
    void setThemeInTiles(Theme theme);

}

