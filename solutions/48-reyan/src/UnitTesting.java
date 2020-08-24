import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTesting {
    @Test
    public void testDetermineString(){
        GameEndingScene gameEndingScene = new GameEndingScene();
        String stringOne = "Yahoo!!!";
        String stringTwo = "Sorry!";
        String stringThree = "Hmm!";

        Assertions.assertEquals("Yahoo!!!", gameEndingScene.determineLabelString(0, stringOne, stringTwo, stringThree));
    }
}
