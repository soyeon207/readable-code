package cleancode.minesweeper.tobe.minesweeper.config;

import cleancode.minesweeper.tobe.minesweeper.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.InputHandler;

public class GameConfig {
    private final GameLevel gamelevel;
    private final InputHandler inputHandler;
    private final ConsoleOutputHandler outputHandler;

    public GameConfig(GameLevel gamelevel, InputHandler inputHandler, ConsoleOutputHandler outputHandler) {
        this.gamelevel = gamelevel;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public GameLevel getGamelevel() {
        return gamelevel;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public ConsoleOutputHandler getOutputHandler() {
        return outputHandler;
    }
}
