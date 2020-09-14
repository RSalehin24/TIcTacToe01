import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HighContrastTheme extends ThemeIntermediate {

    protected HighContrastTheme(GameStage gameStage, AIPlayer aiPlayer) {
        super(gameStage, aiPlayer);
        super.thingsToChangePerTheme(Color.DARKGREY, Color.LIGHTGREY);
        super.prepareTileAndChangeThemePlayerSign(Color.DARKGREY);
        super.setThemeInTiles(this);
    }

    public void setChangedHumanPlayer(Tile tile){
        tile.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setChangedAIPlayer(Tile tile){
        tile.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    protected void setHumanPlayer(Tile tile) {
        super.setPlayerInTile(tile, null, Color.BLACK, Color.DARKGREY, true);
    }

    protected void setAIPlayer(Tile tile) {
        super.setPlayerInTile(tile, null, Color.WHITE, Color.DARKGREY, false);
    }

    protected void setThemePlayer(Tile tile, String playerSymbol, Color tileBackGroundColor){
        tile.setBackground(new Background(new BackgroundFill(tileBackGroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }

}
