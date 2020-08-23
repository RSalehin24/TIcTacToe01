import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ForestTheme implements Theme {


    private Tile[] tiles;
    private RandomAIPlayer randomAIPlayer;

    protected ForestTheme(GameStage gameStage){
        this.tiles = gameStage.getTiles();
        randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        gameStage.thingsToChangeForTheme(gameStage.getGamePane(), Color.WHITE, Color.BLACK);
        changePlayerSign();
        gameStage.setTheme(this);
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){ tiles[i].setPlayerText("X"); }
                else { tiles[i].setPlayerText("O");}
            }
        }
    }

    public void gameFunctionThemeBasedPlayer(Tile tile){
        if(!tile.getIsOccupied()){
            addImageView("flower.jpg", tile);
            tile.setIsOccupied(true);
            tile.setIsHuman(true);
        }
        randomAIPlayerClassic();
    }

    private void randomAIPlayerClassic(){
        Tile tile;
        tile = randomAIPlayer.getPlayerTile();
        if(!tile.getIsOccupied()) {
            addImageView("fruit.jpg", tile);
            tile.setIsOccupied(true);
        }
    }

    private void addImageView(String imageName, Tile tile){
        Image image= new Image(imageName);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        tile.getChildren().add(imageView);
    }

}
