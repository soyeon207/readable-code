package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.pass.StudyCafePass;
import cleancode.studycafe.tobe.pass.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        if (doesUserChooseToHourlyType(userInput)) {
            return StudyCafePassType.HOURLY;
        }
        if (doesUserChooseToWeeklyType(userInput)) {
            return StudyCafePassType.WEEKLY;
        }
        if (doesUserChooseToFixedType(userInput)) {
            return StudyCafePassType.FIXED;
        }

        throw new AppException("잘못된 입력입니다.");
    }

    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        if (doesNotAvailableSelectedInput(passes, selectedIndex)) {
            throw new AppException("잘못된 입력입니다.");
        }
        return passes.get(selectedIndex);
    }

    private static boolean doesNotAvailableSelectedInput(List<StudyCafePass> passes, int selectedIndex) {
        return selectedIndex + 1 > passes.size() || selectedIndex < 0;
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return doesUserChooseToHourlyType(userInput);
    }

    private static boolean doesUserChooseToFixedType(String userInput) {
        return "3".equals(userInput);
    }

    private static boolean doesUserChooseToWeeklyType(String userInput) {
        return "2".equals(userInput);
    }

    private static boolean doesUserChooseToHourlyType(String userInput) {
        return "1".equals(userInput);
    }

}
