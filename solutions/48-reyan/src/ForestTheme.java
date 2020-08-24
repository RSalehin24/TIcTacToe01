import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ForestTheme implements Theme {


    private Tile[] tiles;
    private RandomAIPlayer randomAIPlayer;
    private GameLogicForWinning gameLogicForWinning;

    protected ForestTheme(GameStage gameStage){
        this.tiles = gameStage.getTiles();
        this.randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        this.gameLogicForWinning = new GameLogicForWinning(gameStage);
        gameStage.thingsToChangeForTheme(gameStage.getPaneOfGame(), Color.LIGHTGREEN, Color.DARKGREEN);
        changePlayerSign();
        gameStage.setTheme(this);
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){ addImageView("flower.jpg", tiles[i]); }
                else { addImageView("fruit.jpg", tiles[i]); }
            }
        }
    }

    public void gameFunctionThemeBasedPlayer(Tile tile){
        if(!tile.getIsOccupied()){
            addImageView("flower.jpg", tile);
            tile.setIsOccupied(true);
            tile.setIsHuman(true);
            gameLogicForWinning.gameEndChecker(Color.DARKGREEN);
        }
        if(!gameLogicForWinning.getEndFlag()) randomAIPlayerForest();
    }

    private void randomAIPlayerForest(){
        Tile tile;
        tile = randomAIPlayer.getPlayerTile();
        if(!tile.getIsOccupied()) {
            addImageView("fruit.jpg", tile);
            tile.setIsOccupied(true);
            gameLogicForWinning.gameEndChecker(Color.DARKGREEN);
        }
    }

    private void addImageView(String imageName, Tile tile){
        Image image= new Image(imageName);
        ImageView imageView = new ImageView(image);
        tile.setImageView(imageView);
        tile.setImageViewIdentifier(true);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        tile.getChildren().add(imageView);
    }

}
