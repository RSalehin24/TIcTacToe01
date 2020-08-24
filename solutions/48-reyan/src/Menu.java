import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Menu {

    private Group buttonGroup = new Group();
    private  Group radioButtonGroup = new Group();

    private Text textTheme;
    private Button buttonRandomAI;
    private Button buttonDefensiveAI;
    private RadioButton radioButtonClassic;
    private RadioButton radioButtonForest;
    private RadioButton radioButtonHighContrast;

    private GameStage gameStage;

    protected void createMenu(GameStage gameStage){
        this.gameStage = gameStage;
        textTheme = createText("Theme", 410, 30);
        createButtonGroup(410, 410, 280, 320);
        createRadioButtonGroup(410, 40, 62, 84);
        buttonEventHandler();
    }


    private Text createText(String string, double X, double Y){
        Text text = new Text(X, Y, string);
        text.setFont(Font.font("Aerial", FontWeight.BOLD, 30));
        return text;
    }

    private RadioButton createRadioButton(String string, ToggleGroup toggleGroup, double X, double Y){
        RadioButton radioButton = new RadioButton(string);
        radioButton.setFont(Font.font("Aerial", FontWeight.BOLD, 15));
        radioButton.setLayoutX(X);
        radioButton.setLayoutY(Y);
        radioButton.setToggleGroup(toggleGroup);
        return radioButton;
    }

    private Button createButton(String string, double X, double Y){
        Button button = new Button(string);
        button.setFont(Font.font("Aerial", FontWeight.BOLD, 15));
        button.setLayoutX(X);
        button.setLayoutY(Y);
        return button;
    }

    private void createRadioButtonGroup(double X, double Y1, double Y2, double Y3){
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonClassic = createRadioButton("Classic", toggleGroup, X, Y1);
        radioButtonForest = createRadioButton("Forest", toggleGroup, X, Y2);
        radioButtonHighContrast = createRadioButton("High Contrast", toggleGroup, X, Y3);
        radioButtonGroup.getChildren().addAll(radioButtonClassic, radioButtonForest, radioButtonHighContrast);
    }

    private void createButtonGroup(double X1, double X2, double Y1, double Y2){
        buttonRandomAI = createButton("Play with Random AI",X1, Y1);
        buttonDefensiveAI = createButton("Play with Defensive AI", X2, Y2);
        buttonGroup.getChildren().addAll(buttonRandomAI, buttonDefensiveAI);
    }

    private void themeDeterminerFromRadioButtons(boolean isdefensivePlayerAI){
        if(radioButtonClassic.isSelected()){
            ClassicTheme classicTheme = new ClassicTheme(gameStage, isdefensivePlayerAI);
        }
        else if(radioButtonForest.isSelected()){
            ForestTheme forestTheme = new ForestTheme(gameStage, isdefensivePlayerAI);
        }
        else if(radioButtonHighContrast.isSelected()){
            HighContrastTheme highContrastTheme = new HighContrastTheme(gameStage, isdefensivePlayerAI);
        }
    }

    private void buttonEventHandler(){
        buttonRandomAI.setOnMouseClicked(e -> themeDeterminerFromRadioButtons(false));
        buttonDefensiveAI.setOnMouseClicked(e -> themeDeterminerFromRadioButtons(true));
    }

    protected Text getTextTheme(){ return textTheme; }
    protected Group getRadioButtonGroup(){ return radioButtonGroup; }
    protected Group getButtonGroup(){ return buttonGroup; }
}
