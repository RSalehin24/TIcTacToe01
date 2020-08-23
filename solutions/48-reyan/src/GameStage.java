import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameStage {
    private Pane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Menu menu;
    private Text textTheme;
    private Group tileGroup = new Group();
    private Group lineGroup = new Group();
    private Group radioButtonGroup = new Group();
    private Group buttonGroup = new Group();

    private Tile[] tiles = new Tile[9];
    private Line[] lines = new Line[9];

    protected GameStage(){
        menu = new Menu();
        gamePane = createGamePane();
        gameScene = createGameScene();
        gameStage = createShowGameStage();
    }

    protected Pane createGamePane(){
        Pane gamePane = new Pane();
        gamePane.setPrefSize(600, 380);

        createTileGroup();
        createLineGroup();

        textTheme = menu.getTextTheme();
        radioButtonGroup = menu.getRadioButtonGroup();
        buttonGroup = menu.getButtonGroup();

        gamePane.getChildren().addAll(tileGroup, lineGroup, textTheme, buttonGroup, radioButtonGroup);
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

    protected void createTileGroup(){
        for(int i=0, l=0; i<3; i++){
            for(int j=0; j<3; j++){
                Tile tile = new Tile();
                tile.setMinSize(100, 100);
                tile.setTranslateX(j*109+53);
                tile.setTranslateY(i*109+30);

                tiles[l] = tile;
                tileGroup.getChildren().add(tiles[l]);
                l++;
            }
        }
    }

    protected Line drawLine(double x1, double y1, double x2, double y2){
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(9);
        return line;
    }

    private void createLineGroup(){
        int l=0;
        lines[l] = drawLine(158, 30, 158, 350);
        l++;
        lines[l] = drawLine(267, 30, 267, 350);
        l++;
        lines[l] = drawLine(53, 135, 373, 135);
        l++;
        lines[l] = drawLine(53, 244, 373, 244);
        l++;
        lines[l] = drawLine(400, 30, 400, 348);

        lineGroup.getChildren().addAll(lines[0], lines[1], lines[2], lines[3], lines[4]);
    }

    protected void thingsToChangeForTheme(Color colorOfPane, Color colorOfLine){
        gamePane.setBackground(new Background((new BackgroundFill(colorOfPane, CornerRadii.EMPTY, Insets.EMPTY))));
        for(int i=0; i<4; i++){
            lines[i].setStroke(colorOfLine);
        }
    }

    protected Pane getGamePane(){ return gamePane; }
    protected Scene getGameScene(){ return gameScene; }
    protected Stage getGameStage(){ return gameStage; }
    protected Tile[] getTiles(){ return tiles; }
    protected Line[] getLines(){ return  lines; }
}
