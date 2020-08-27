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

    private Text textTheme;
    private Pane paneOfGame;
    private Stage stageOfGame;

    private Group tileGroup = new Group();
    private Group lineGroup = new Group();
    private Group radioButtonGroup = new Group();
    private Group buttonGroup = new Group();

    private Tile[] tiles = new Tile[9];
    private Line[] lines = new Line[9];

    private Menu menu;


    protected void createShowGameStage(){
        menu = new Menu();
        menu.createMenu(this);
        stageOfGame = new Stage();
        stageOfGame.setScene(createGameScene());
        stageOfGame.show();
    }

    private Scene createGameScene(){
        return new Scene(createGamePane());
    }

    private Pane createGamePane(){
        paneOfGame = new Pane();
        paneOfGame.setPrefSize(600, 380);

        createTileGroup();
        createLineGroup();

        textTheme = menu.getTextTheme();
        radioButtonGroup = menu.getRadioButtonGroup();
        buttonGroup = menu.getButtonGroup();

        paneOfGame.getChildren().addAll(tileGroup, lineGroup, textTheme, buttonGroup, radioButtonGroup);
        return paneOfGame;
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

    protected Line drawLine(double x1, double y1, double x2, double y2){
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(9);
        return line;
    }

    protected void thingsToChangePerTheme(Pane gamePane, Color colorOfPane, Color colorOfLine){
        gamePane.setBackground(new Background((new BackgroundFill(colorOfPane, CornerRadii.EMPTY, Insets.EMPTY))));
        for(int i=0; i<4; i++){
            lines[i].setStroke(colorOfLine);
        }
    }

    protected void setThemeInTilesByThemeType(Theme theme){
        for(int i=0; i<9; i++){
            tiles[i].setTheme(theme);
        }
    }

    public void removeExtensions(Color color) {
        for (int i = 0; i < 9; i++) {
            if (tiles[i].getIsOccupied()) {
                if (tiles[i].getHasImageView()) {
                    tiles[i].getChildren().remove(tiles[i].getImageView());
                    if (tiles[i].getHasText()) tiles[i].setText("");
                    tiles[i].setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    protected Pane getPaneOfGame(){ return paneOfGame; }
    protected Stage getStageOfGame(){ return stageOfGame; }
    protected Tile[] getTiles(){ return tiles; }
}
