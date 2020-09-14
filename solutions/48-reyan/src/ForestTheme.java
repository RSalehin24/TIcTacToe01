import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ForestTheme extends ThemeIntermediate {

    protected ForestTheme(GameStage gameStage, AIPlayer aiPlayer){
        super(gameStage, aiPlayer);
        super.thingsToChangePerTheme(Color.LIGHTGREEN, Color.DARKGREEN);
        super.prepareTileAndChangeThemePlayerSign(Color.LIGHTGREEN);
        super.setThemeInTiles(this);
    }

    public void setChangedHumanPlayer(Tile tile){
        createImageViewByPlayer("flower.jpg", tile);
    }

    public void setChangedAIPlayer(Tile tile){
        createImageViewByPlayer("fruit.jpg", tile);
    }

    protected void setHumanPlayer(Tile tile) {
        super.setPlayerInTile(tile, "flower.jpg", null, Color.DARKGREEN, true);
    }

    protected void setAIPlayer(Tile tile) {
        super.setPlayerInTile(tile, "fruit.jpg", null, Color.DARKGREEN, false);
    }

    protected void setThemePlayer(Tile tile, String playerSymbol, Color tileBackGroundColor){
        createImageViewByPlayer(playerSymbol, tile);
    }

    private void createImageViewByPlayer(String imageName, Tile tile){
        Image image= new Image(imageName);
        ImageView imageView = new ImageView(image);
        tile.setImageView(imageView);
        tile.setHasImageView(true);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        tile.getChildren().add(imageView);
    }

}
