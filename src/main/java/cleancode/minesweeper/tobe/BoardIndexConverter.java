package cleancode.minesweeper.tobe;

public class BoardIndexConverter {
    private static final char BASE_CHAR_FOR_COL = 'a';

    public int getSelectedColIndex(String cellInput, int rowSize) {
        char cellInputCol = cellInput.charAt(0);
        return convertColFrom(cellInputCol, rowSize);
    }

    public int getSelectedRowIndex(String cellInput, int colSize) {
        String cellInputRow = cellInput.substring(1);
        return convertRowFrom(cellInputRow, colSize);
    }

    private int convertRowFrom(String cellInputRow, int rowSize) {
        int rowIndex = Integer.parseInt(cellInputRow) - 1;
        if (rowIndex < 0 || rowIndex >= rowSize) {
            throw new GameException("잘못된 입력입니다.");
        }
        return rowIndex;
    }

    private int convertColFrom(char cellInputCol, int colSize) {
        int colIndex = cellInputCol - BASE_CHAR_FOR_COL;
        if (colIndex < 0 || colIndex >= colSize) {
            throw new GameException("잘못된 입력입니다.");
        }
        return colIndex;
    }
}
