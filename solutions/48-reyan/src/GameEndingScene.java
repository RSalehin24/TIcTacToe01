import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameEndingScene {

    public Scene makeGameOverScene(int winPlayerIndicator) {

        String stringForLabelOne, stringForLabelTwo;
        if (winPlayerIndicator == 0) {
            stringForLabelOne = "Yahoo!!!";
            stringForLabelTwo = "You have won the game!!";
        } else if(winPlayerIndicator == 1) {
            stringForLabelOne = "Sorry!";
            stringForLabelTwo = "You have lost the game";
        } else {
            stringForLabelOne = "Hmm!";
            stringForLabelTwo = "Game Has Drawn";
        }

        Label labelOne = createLabel(stringForLabelOne,"#ff0000");
        Label labelTwo = createLabel(stringForLabelTwo, "#228b22");

        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(labelOne, labelTwo);

        Scene scene = new Scene(vBox, 420, 380);

        return scene;
    }

    private Label createLabel(String string, String color){
        Label label = new Label(string);
        label.setFont(new Font("Arial", 30));
        label.setTextFill(Color.web(color, 1.0));
        return label;
    }

}
