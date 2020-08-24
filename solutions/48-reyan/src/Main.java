import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GameStage gameStage = new GameStage();
        gameStage.createGameStage();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
