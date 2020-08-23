import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameStage {
    private Pane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    protected GameStage(){
        gamePane = createGamePane();
        gameScene = createGameScene();
        gameStage = createShowGameStage();
    }

    protected Pane createGamePane(){
        Pane gamePane = new Pane();
        gamePane = new Pane();
        gamePane.setPrefSize(550, 380);
        return gamePane;
    }

    protected Scene createGameScene(){
        Scene gameScene = new Scene(createGamePane());
        return gameScene;
    }

    protected Stage createShowGameStage(){
        Stage gameStage = new Stage();
        gameStage.setScene(createGameScene());
        gameStage.show();
        return gameStage;
    }

    protected Pane getGamePane(){ return gamePane; }
    protected Scene getGameScene(){ return gameScene; }
    protected Stage getGameStage(){ return gameStage; }
}
