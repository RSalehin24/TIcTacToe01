import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private Theme theme;

    private Text text;
    private ImageView imageView;
    private boolean hasImageView;

    private boolean isOccupied;
    private boolean isHuman;



    protected Tile(){
        text = new Text();
        text.setFont(Font.font(75));

        getChildren().addAll(text);
        mouseEventHandler();
    }

    private void mouseEventHandler(){
        setOnMouseClicked(event -> {
            if(theme== null) return;
            if(event.getButton() == MouseButton.PRIMARY){
                if(!isOccupied) theme.makeMoveInATile(this);
            }
        });
    }

    protected void setTheme(Theme theme){ this.theme = theme;}
    protected void setText(String string){ text.setText(string); }

    protected boolean getIsOccupied(){ return isOccupied; }
    protected void setIsOccupied(boolean isOccupied){ this.isOccupied = isOccupied; }
    protected boolean getIsHuman(){ return isHuman; }
    protected void setIsHuman(boolean isHuman){ this.isHuman = isHuman; }

    protected ImageView getImageView(){ return imageView; }
    protected void setImageView(ImageView imageView){ this.imageView = imageView; }
    protected boolean getHasImageView(){ return hasImageView; }
    protected void setHasImageView(boolean hasImageView) { this.hasImageView = hasImageView; }
}
