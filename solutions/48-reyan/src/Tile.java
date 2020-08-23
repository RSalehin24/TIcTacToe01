import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    private Text text;

    protected Tile(){
        text = new Text();
        text.setFont(Font.font(75));

        getChildren().addAll(text);

        setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY){
                text.setText("X");
            }
            else if(event.getButton() == MouseButton.SECONDARY){
                text.setText("O");
            }
        });
    }
}
