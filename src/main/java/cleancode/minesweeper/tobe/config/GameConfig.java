package cleancode.minesweeper.tobe.config;

import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;

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
