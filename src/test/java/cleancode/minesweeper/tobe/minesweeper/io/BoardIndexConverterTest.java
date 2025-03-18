package cleancode.minesweeper.tobe.minesweeper.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardIndexConverterTest {

    @DisplayName("좌표를 입력했을 때 가로 좌표를 가져올 수 있다.")
    @Test
    void getSelectedRowIndex() {
        // given
        BoardIndexConverter instance = new BoardIndexConverter();

        // when
        String[] cellInputArr = {"a1", "a2", "a3", "a4"};
        int[] expectedRowIndexArr = {0, 1, 2, 3};

        // then
        for (int i = 0; i < cellInputArr.length; i++) {
            assertEquals(expectedRowIndexArr[i], instance.getSelectedRowIndex(cellInputArr[i]));
        }
    }

    @DisplayName("좌표를 입력했을 때 세로 좌표를 가져올 수 있다.")
    @Test
    void getSelectedColIndex() {
        // given
        BoardIndexConverter instance = new BoardIndexConverter();

        // when
        String[] cellInputArr = {"a1", "b1", "c1", "d1"};
        int[] expectedRowIndexArr = {0, 1, 2, 3};

        // then
        for (int i = 0; i < cellInputArr.length; i++) {
            assertEquals(expectedRowIndexArr[i], instance.getSelectedColIndex(cellInputArr[i]));
        }
    }

}
