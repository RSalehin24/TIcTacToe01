import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    private Text text;
    private boolean isOccupied = false;
    private boolean isHuman = false;

    protected Tile(){
        text = new Text();
        text.setFont(Font.font(75));

        getChildren().addAll(text);
        mouseEventHandler();
    }

    private void mouseEventHandler(){
        setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY){
                if(!isOccupied) text.setText("X");
                isHuman = true;
            }
            else if(event.getButton() == MouseButton.SECONDARY){
                if(!isOccupied) text.setText("O");
            }
        });
    }

    protected boolean getIsOccupied(){ return isOccupied; }
    protected boolean getIsHuman(){ return isHuman; }
    protected void setIsOccupied(boolean isOccupied){ this.isOccupied = isOccupied; }
    protected void setIsHuman(boolean isHuman){ this.isHuman = isHuman; }
    protected void setPlayerText(String string){ text.setText(string); }
}
