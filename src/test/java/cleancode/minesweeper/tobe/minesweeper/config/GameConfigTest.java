package cleancode.minesweeper.tobe.minesweeper.config;

import cleancode.minesweeper.tobe.minesweeper.gamelevel.Advanced;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigTest {

    @DisplayName("동일한 gameLevel 을 출력한다.")
    @Test
    void getGameLevel() {
        // given
        Advanced advanced = new Advanced();
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();
        GameConfig instance = new GameConfig(advanced, inputHandler, outputHandler);

        // when
        GameLevel gameLevel = instance.getGameLevel();

        //then
        assertEquals(gameLevel, advanced);
    }

}
