import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private Theme theme;
    private Text playerInClassicTheme;
    private ImageView imageView;

    private boolean isPlayerInClassicTheme;
    private boolean isOccupied;
    private boolean isHuman;
    private boolean imageViewIdentifier;


    protected Tile(){
        playerInClassicTheme = new Text();
        playerInClassicTheme.setFont(Font.font(75));

        getChildren().addAll(playerInClassicTheme);
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

    protected void setPlayerInClassicTheme(String string){ playerInClassicTheme.setText(string); }
    protected boolean getPlayerInClassicTheme(){ return isPlayerInClassicTheme; }
    protected void setPlayerInClassicTheme(boolean playerInClassicTheme){ this.isPlayerInClassicTheme = playerInClassicTheme;}

    protected boolean getIsOccupied(){ return isOccupied; }
    protected void setIsOccupied(boolean isOccupied){ this.isOccupied = isOccupied; }
    protected boolean getIsHuman(){ return isHuman; }
    protected void setIsHuman(boolean isHuman){ this.isHuman = isHuman; }

    protected ImageView getImageView(){ return imageView; }
    protected void setImageView(ImageView imageView){ this.imageView = imageView; }
    protected boolean getImageViewIdentifier(){ return imageViewIdentifier; }
    protected void setImageViewIdentifier(boolean imageViewIdentifier) { this.imageViewIdentifier = imageViewIdentifier; }
}
