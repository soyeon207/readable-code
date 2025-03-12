package cleancode.studycafe.tobe.pass;

import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.locker.Locker;

import java.util.List;

public class CafePass {
    private static final StudyCafeFileHandler STUDY_CAFE_FILE_HANDLER = new StudyCafeFileHandler();
    private static final List<StudyCafePass> STUDY_CAFE_PASSES = STUDY_CAFE_FILE_HANDLER.readStudyCafePasses();
    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();
    private final Locker locker = new Locker();


    public void actOnHourly() {
        StudyCafePass selectedPass = findStudyCafePassBy(StudyCafePassType.HOURLY);
        outputHandler.showPassOrderSummary(selectedPass, null);
    }

    public void actOnWeekly() {
        StudyCafePass selectedPass = findStudyCafePassBy(StudyCafePassType.WEEKLY);
        outputHandler.showPassOrderSummary(selectedPass, null);
    }

    public void actOnFixed() {
        StudyCafePass selectedPass = findStudyCafePassBy(StudyCafePassType.FIXED);
        StudyCafeLockerPass lockerPass = locker.findSamePassBy(selectedPass.getPassType(), selectedPass.getDuration());
        locker.showPassOrderSummary(selectedPass, lockerPass);
    }

    private List<StudyCafePass> findStudyCafePassesBy(StudyCafePassType type) {
        List<StudyCafePass> typePasses = STUDY_CAFE_PASSES.stream()
            .filter(studyCafePass -> studyCafePass.isSameType(type))
            .toList();
        outputHandler.showPassListForSelection(typePasses);
        return typePasses;
    }

    private StudyCafePass findStudyCafePassBy(StudyCafePassType type) {
        List<StudyCafePass> passes = findStudyCafePassesBy(type);
        return inputHandler.getSelectPass(passes);
    }
}
