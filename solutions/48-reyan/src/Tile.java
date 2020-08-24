import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private Theme theme;
    private Text classicPlayer;
    private ImageView imageView;

    private boolean classicPlayerIdentifier;
    private boolean isOccupied;
    private boolean isHuman;
    private boolean imageViewIdentifier;


    protected Tile(){
        classicPlayer = new Text();
        classicPlayer.setFont(Font.font(75));

        getChildren().addAll(classicPlayer);
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

    protected void setClassicPlayer(String string){ classicPlayer.setText(string); }
    protected boolean getClassicPlayerIdentifier(){ return classicPlayerIdentifier; }
    protected void setClassicPlayerIdentifier(boolean classicPlayerIdentifier){ this.classicPlayerIdentifier = classicPlayerIdentifier;}

    protected boolean getIsOccupied(){ return isOccupied; }
    protected void setIsOccupied(boolean isOccupied){ this.isOccupied = isOccupied; }
    protected boolean getIsHuman(){ return isHuman; }
    protected void setIsHuman(boolean isHuman){ this.isHuman = isHuman; }

    protected ImageView getImageView(){ return imageView; }
    protected void setImageView(ImageView imageView){ this.imageView = imageView; }
    protected boolean getImageViewIdentifier(){ return imageViewIdentifier; }
    protected void setImageViewIdentifier(boolean imageViewIdentifier) { this.imageViewIdentifier = imageViewIdentifier; }
}
