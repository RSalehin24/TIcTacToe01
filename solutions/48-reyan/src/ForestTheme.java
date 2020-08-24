import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ForestTheme implements Theme {


    private Tile[] tiles;
    private boolean isDefensivePlayerAI;

    private RandomAIPlayer randomAIPlayer;
    private DefensiveAIPlayer defensiveAIPlayer;
    private GameLogicForWinning gameLogicForWinning;



    protected ForestTheme(GameStage gameStage, boolean isDefensivePlayerAI){
        this.isDefensivePlayerAI = isDefensivePlayerAI;
        randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        defensiveAIPlayer = new DefensiveAIPlayer(gameStage);
        gameLogicForWinning = new GameLogicForWinning(gameStage);
        tiles = gameStage.getTiles();
        gameStage.thingsToChangeForTheme(gameStage.getPaneOfGame(), Color.LIGHTGREEN, Color.DARKGREEN);
        changePlayerSignToForest();
        gameStage.setTheme(this);
    }

    private void changePlayerSignToForest(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getIsHuman()){ createImageViewByPlayer("flower.jpg", tiles[i]); }
                else { createImageViewByPlayer("fruit.jpg", tiles[i]); }
            }
        }
    }

    public void setPlayerByThemeType(Tile tile){
        setPlayerInTileForest(tile,"flower.jpg",true);
        if(gameLogicForWinning.getEndFlag()) randomAIPlayerForest();
    }

    private void randomAIPlayerForest(){
        Tile tile;
        if(isDefensivePlayerAI) tile = defensiveAIPlayer.getPlayerTile();
        else tile = randomAIPlayer.getPlayerTile();
        setPlayerInTileForest(tile,"fruit.jpg", false);
    }

    private void createImageViewByPlayer(String imageName, Tile tile){
        Image image= new Image(imageName);
        ImageView imageView = new ImageView(image);
        tile.setPlayerInForest(imageView);
        tile.setPlayerInForest(true);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        tile.getChildren().add(imageView);
    }

    private void setPlayerInTileForest(Tile tile, String playerSpecifiedImageName, boolean isHuman){
        if(!tile.getIsOccupied()) {
            createImageViewByPlayer(playerSpecifiedImageName, tile);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameLogicForWinning.gameEndChecker(Color.DARKGREEN);
        }
    }

}
