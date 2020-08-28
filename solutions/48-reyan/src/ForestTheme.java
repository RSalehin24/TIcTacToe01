import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ForestTheme implements Theme {


    private Tile[] tiles;

    private GameLogicForWinning gameLogicForWinning;
    private CurrentStateOfGame currentStateOfGame;
    private GameStage gameStage;
    private AIPlayer aiPlayer;


    protected ForestTheme(GameStage gameStage, AIPlayer aiPlayer){
        this.gameStage = gameStage;
        this.aiPlayer = aiPlayer;
        tiles = gameStage.getTiles();

        gameLogicForWinning = new GameLogicForWinning();
        gameLogicForWinning.initializeGameLogicForWinning(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);

        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.LIGHTGREEN, Color.DARKGREEN);
        changePlayerSign();
        gameStage.setThemeInTiles(this);
    }

    public void changePlayerSign(){
        gameStage.removeExtensionsFromTile(Color.LIGHTGREEN);
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){ createImageViewByPlayer("flower.jpg", tiles[i]); }
                else { createImageViewByPlayer("fruit.jpg", tiles[i]); }
            }
        }
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile,"flower.jpg",null, true);
        if(gameLogicForWinning.getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getOccupiedHuman(), currentStateOfGame.getOccupiedAI());
        setPlayerInTile(tiles[tileNo],"fruit.jpg", null, false);
    }


    public void setPlayerInTile(Tile tile, String playerSpecifiedImageName, Color color, boolean isHuman){
        if(!tile.getIsOccupied()) {
            createImageViewByPlayer(playerSpecifiedImageName, tile);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameLogicForWinning.gameEndChecker(Color.DARKGREEN);
        }
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
