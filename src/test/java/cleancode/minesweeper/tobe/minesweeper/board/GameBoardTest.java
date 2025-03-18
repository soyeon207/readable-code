package cleancode.minesweeper.tobe.minesweeper.board;

import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Beginner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameBoardTest {
    private final Beginner beginner = new Beginner();
    private final GameBoard instance = new GameBoard(beginner);

    @DisplayName("입력된 레벨의 크기 내의 숫자가 입력되면 정상적인 위치다.")
    @Test
    void isInvalidCellPosition() {
        // given
        CellPosition cellPosition = CellPosition.of(beginner.getRowSize() - 1, beginner.getColSize() - 1);

        // when
        boolean invalidCellPosition = instance.isInvalidCellPosition(cellPosition);

        //then
        assertFalse(invalidCellPosition);
    }

    @DisplayName("입력된 레벨의 크기 외의 숫자가 입력되면 비정상적인 위치다.")
    @Test
    void isValidCellPosition() {
        // given
        CellPosition cellPosition = CellPosition.of(beginner.getRowSize(), beginner.getColSize());

        // when
        boolean invalidCellPosition = instance.isInvalidCellPosition(cellPosition);

        //then
        assertTrue(invalidCellPosition);
    }

    @DisplayName("셀 오픈 시 지뢰셀이라면 게임에서 진다.")
    @Test
    void openCellButLandMineCellYouLose() {
        // given
        instance.initializeGame();
        CellPosition cellPosition = null;
        for (int rowIdx = 0; rowIdx < beginner.getRowSize(); rowIdx++) {
            for (int colIdx = 0; colIdx < beginner.getColSize(); colIdx++) {
                cellPosition = CellPosition.of(rowIdx, colIdx);
                if (instance.isLandMineCellAt(cellPosition)) {
                    break;
                }
            }
        }

        // when
        instance.openAt(cellPosition);

        // then
        assertTrue(instance.isLoseStatus());
    }

}
