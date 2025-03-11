package cleancode.studycafe.tobe.locker;

import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.pass.StudyCafePass;
import cleancode.studycafe.tobe.pass.StudyCafePassType;

import java.util.List;

public class Locker {
    private final List<StudyCafeLockerPass> lockerPasses;
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();


    public Locker() {
        StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
        lockerPasses = studyCafeFileHandler.readLockerPasses();
    }

    public StudyCafeLockerPass findSamePassBy(StudyCafePassType passType, int duration) {
        return lockerPasses.stream()
            .filter(option -> option.isSamePass(passType, duration))
            .findFirst()
            .orElse(null);
    }

    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        if (isLockerSelection(lockerPass)) {
            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
        } else {
            outputHandler.showPassOrderSummary(selectedPass, null);
        }
    }

    private boolean isLockerSelection(StudyCafeLockerPass lockerPass) {
        boolean lockerSelection = false;
        if (lockerPass != null) {
            outputHandler.askLockerPass(lockerPass);
            lockerSelection = inputHandler.getLockerSelection();
        }
        return lockerSelection;
    }
}
