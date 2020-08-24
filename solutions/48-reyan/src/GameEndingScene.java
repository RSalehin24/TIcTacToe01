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

        Label labelOne = new Label(stringForLabelOne);
        labelOne.setFont(new Font("Arial", 30));
        labelOne.setTextFill(Color.web("#ff0000", 1.0));

        Label labelTwo = new Label(stringForLabelTwo);
        labelTwo.setFont(new Font("Aerial", 30));
        labelTwo.setTextFill(Color.web("#228b22", 30));

        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(labelOne, labelTwo);

        Scene scene = new Scene(vBox, 420, 380);

        return scene;
    }

}
