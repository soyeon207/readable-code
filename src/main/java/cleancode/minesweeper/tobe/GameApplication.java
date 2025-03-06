package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Advanced;

public class GameApplication {

    public static void main(String[] args) {
        Advanced middle = new Advanced();

        Minesweeper minesweeper = new Minesweeper(middle);
        minesweeper.initialize();
        minesweeper.run();
    }

}
