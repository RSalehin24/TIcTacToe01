import javafx.scene.paint.Color;

public class ClassicTheme extends ThemeIntermediate {

    protected ClassicTheme(GameStage gameStage, AIPlayer aiPlayer){
        super(gameStage, aiPlayer);
        super.thingsToChangePerTheme(Color.WHITE, Color.BLACK);
        super.prepareTileAndChangeThemePlayerSign(Color.WHITE);
        super.setThemeInTiles(this);
    }

    public void setChangedHumanPlayer(Tile tile){
        tile.setText("X");
    }

    public void setChangedAIPlayer(Tile tile){
        tile.setText("O");
    }

    protected void setHumanPlayer(Tile tile) {
        super.setPlayerInTile(tile, "X", null, Color.BLACK, true);
    }

    protected void setAIPlayer(Tile tile) {
        super.setPlayerInTile(tile, "O", null, Color.BLACK, false);
    }

    protected void setThemePlayer(Tile tile, String playerSymbol, Color tileBackGroundColor){
        tile.setText(playerSymbol);
    }
}
