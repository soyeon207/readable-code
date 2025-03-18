package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyCellSignProviderTest {
    private final EmptyCellSignProvider instance = new EmptyCellSignProvider();

    @DisplayName("빈 셀을 정상적으로 체크할 수 있다.")
    @Test
    void checkEmptyCellStatus() {
        // given
        CellSnapshot emptyCellSnapshot = CellSnapshot.ofEmpty();

        // when
        boolean isEmptyStatus = instance.supports(emptyCellSnapshot);

        //then
        assertTrue(isEmptyStatus);
    }

    @DisplayName("빈 셀이 아닌 경우 체크할 수 있다.")
    @Test
    void checkNotEmptyCellStatus() {
        // given
        CellSnapshot emptyCellSnapshot = CellSnapshot.ofFlag();

        // when
        boolean isEmptyStatus = instance.supports(emptyCellSnapshot);

        //then
        assertFalse(isEmptyStatus);
    }

    @DisplayName("빈 깃발에 해당하는 데이터가 호출된다")
    @Test
    void checkEmptySign() {
        // given
        CellSnapshot emptyCellSnapshot = CellSnapshot.ofEmpty();
        String emptySign = "■";

        // when
        String sign = instance.provide(emptyCellSnapshot);

        //then
        assertEquals(sign, emptySign);
    }


}
