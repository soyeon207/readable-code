package cleancode.minesweeper.tobe.minesweeper.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleOutputHandlerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("게임을 이겼을 때 안내 문구가 정상적으로 나온다.")
    @Test
    void showGameWinningComment() {
        // given
        ConsoleOutputHandler instance = new ConsoleOutputHandler();

        // when
        instance.showGameWinningComment();

        //then
        String targetOutput = outputStreamCaptor.toString().trim();
        assertEquals("지뢰를 모두 찾았습니다. GAME CLEAR!", targetOutput);
    }

    @DisplayName("게임에서 지뢰를 밟았을 때 안내 문구가 정상적으로 나온다.")
    @Test
    void gameLosingComment() {
        // given
        ConsoleOutputHandler instance = new ConsoleOutputHandler();

        // when
        String losingComment = instance.gameLosingComment();

        //then
        assertEquals("지뢰를 밟았습니다. GAME OVER!", losingComment);
    }


}
