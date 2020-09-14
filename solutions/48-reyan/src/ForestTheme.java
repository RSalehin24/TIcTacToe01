import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ForestTheme extends ThemeCommonJobs {


    private Tile[] tiles;

    private GameEndChecker gameEndChecker;
    private CurrentStateOfGame currentStateOfGame;
    private AIPlayer aiPlayer;


    protected ForestTheme(GameStage gameStage, AIPlayer aiPlayer){
        super(gameStage);
        this.aiPlayer = aiPlayer;
        tiles = super.getThemeTiles();

        gameEndChecker = new GameEndChecker();
        gameEndChecker.initializeGameLogicForWinning(gameStage);
        currentStateOfGame = new CurrentStateOfGame(tiles);

        gameStage.thingsToChangePerTheme(gameStage.getPaneOfGame(), Color.LIGHTGREEN, Color.DARKGREEN);
        super.prepareAndChangeThemePlayerSign(Color.LIGHTGREEN);
        gameStage.setThemeInTiles(this);
    }

    public void setChangedHumanPlayer(Tile tile){
        createImageViewByPlayer("flower.jpg", tile);
    }

    public void setChangedAIPlayer(Tile tile){
        createImageViewByPlayer("fruit.jpg", tile);
    }

    public void makeMoveInATile(Tile tile){
        setPlayerInTile(tile,"flower.jpg",null, true);
        if(gameEndChecker.getDrawWinChecker().getNotEndFlag()) aiPlayer();
    }

    public void aiPlayer(){
        int tileNo = aiPlayer.getAIPlayerTileNo(currentStateOfGame.getOccupiedTiles());
        setPlayerInTile(tiles[tileNo],"fruit.jpg", null, false);
    }


    public void setPlayerInTile(Tile tile, String playerSpecifiedImageName, Color color, boolean isHuman){
        if(!tile.getIsOccupied()) {
            createImageViewByPlayer(playerSpecifiedImageName, tile);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameEndChecker.gameEndChecker(Color.DARKGREEN);
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
