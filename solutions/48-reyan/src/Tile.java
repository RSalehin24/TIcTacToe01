import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private Theme theme;
    private Text playerInClassic;
    private ImageView playerInForest;

    private boolean isPlayerInClassic;
    private boolean isOccupied;
    private boolean isHuman;
    private boolean isPlayerInForest;


    protected Tile(){
        playerInClassic = new Text();
        playerInClassic.setFont(Font.font(75));

        getChildren().addAll(playerInClassic);
        mouseEventHandler();
    }

    private void mouseEventHandler(){
        setOnMouseClicked(event -> {
            if(theme== null) return;
            if(event.getButton() == MouseButton.PRIMARY){
                if(!isOccupied) theme.gameFunctionThemeBasedPlayer(this);
            }
        });
    }

    protected void setTheme(Theme theme){ this.theme = theme;}

    protected void setPlayerInClassic(String string){ playerInClassic.setText(string); }
    protected boolean getPlayerInClassic(){ return isPlayerInClassic; }
    protected void setPlayerInClassic(boolean playerInClassic){ this.isPlayerInClassic = playerInClassic;}

    protected boolean getIsOccupied(){ return isOccupied; }
    protected void setIsOccupied(boolean isOccupied){ this.isOccupied = isOccupied; }
    protected boolean getIsHuman(){ return isHuman; }
    protected void setIsHuman(boolean isHuman){ this.isHuman = isHuman; }

    protected ImageView getPlayerInForest(){ return playerInForest; }
    protected void setPlayerInForest(ImageView playerInForest){ this.playerInForest = playerInForest; }
    protected boolean getIsPlayerInForest(){ return isPlayerInForest; }
    protected void setPlayerInForest(boolean playerInForest) { this.isPlayerInForest = playerInForest; }
}
