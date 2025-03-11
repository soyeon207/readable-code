package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.locker.Locker;
import cleancode.studycafe.tobe.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.pass.CafePass;
import cleancode.studycafe.tobe.pass.StudyCafePass;
import cleancode.studycafe.tobe.pass.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final Locker locker = new Locker();
    private final CafePass cafePass = new CafePass();

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();
            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            if (studyCafePassType.isHourly()) {
                List<StudyCafePass> hourlyPasses = cafePass.findCafePassFor(StudyCafePassType.HOURLY);
                StudyCafePass selectedPass = inputHandler.getSelectPass(hourlyPasses);
                outputHandler.showPassOrderSummary(selectedPass, null);
            }

            if (studyCafePassType.isWeekly()) {
                List<StudyCafePass> weeklyPasses = cafePass.findCafePassFor(StudyCafePassType.WEEKLY);
                StudyCafePass selectedPass = inputHandler.getSelectPass(weeklyPasses);
                outputHandler.showPassOrderSummary(selectedPass, null);
            }

            if (studyCafePassType.isFixed()) {
                List<StudyCafePass> fixedPasses = cafePass.findCafePassFor(StudyCafePassType.FIXED);
                StudyCafePass selectedPass = inputHandler.getSelectPass(fixedPasses);
                StudyCafeLockerPass lockerPass = this.locker.findSamePassBy(selectedPass.getPassType(), selectedPass.getDuration());
                locker.showPassOrderSummary(selectedPass, lockerPass);
            }
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }



}
