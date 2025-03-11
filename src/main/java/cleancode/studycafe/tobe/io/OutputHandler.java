package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.pass.StudyCafePass;

import java.util.List;

public class OutputHandler {

    public void showWelcomeMessage() {
        System.out.println("*** 프리미엄 스터디카페 ***");
    }

    public void showAnnouncement() {
        System.out.println("* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)");
        System.out.println("* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)");
        lineBreak();
    }

    public void askPassTypeSelection() {
        System.out.println("사용하실 이용권을 선택해 주세요.");
        System.out.println("1. 시간 이용권(자유석) | 2. 주단위 이용권(자유석) | 3. 1인 고정석");
    }

    public void showPassListForSelection(List<StudyCafePass> passes) {
        lineBreak();
        System.out.println("이용권 목록");
        for (int index = 0; index < passes.size(); index++) {
            StudyCafePass pass = passes.get(index);
            System.out.println(String.format("%s. ", index + 1) + pass.display());
        }
    }

    public void askLockerPass(StudyCafeLockerPass lockerPass) {
        lineBreak();
        String askMessage = String.format("사물함을 이용하시겠습니까? (%s)", lockerPass.display());

        System.out.println(askMessage);
        System.out.println("1. 예 | 2. 아니오");
    }

    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        lineBreak();
        System.out.println("이용 내역");
        System.out.println("이용권: " + selectedPass.display());
        if (isUseLocker(lockerPass)) {
            System.out.println("사물함: " + lockerPass.display());
        }

        double discountRate = selectedPass.getDiscountRate();
        int price = selectedPass.getPrice();
        int discountPrice = calculateDiscount(price, discountRate);
        if (isAvailableDiscount(discountPrice)) {
            System.out.println("이벤트 할인 금액: " + discountPrice + "원");
        }

        int totalPrice = calculateTotalPrice(price, lockerPass, discountPrice);
        System.out.println("총 결제 금액: " + totalPrice + "원");
        lineBreak();
    }

    private static void lineBreak() {
        System.out.println();
    }

    private static boolean isUseLocker(StudyCafeLockerPass lockerPass) {
        return lockerPass != null;
    }

    private static int calculateDiscount(int price, double discountRate) {
        return (int) (price * discountRate);
    }

    private static boolean isAvailableDiscount(int discountPrice) {
        return discountPrice > 0;
    }

    private static int calculateTotalPrice(int price, StudyCafeLockerPass lockerPass, int discountPrice) {
        return price - discountPrice + getLockerPassPrice(lockerPass);
    }

    public void showSimpleMessage(String message) {
        System.out.println(message);
    }

    private static int getLockerPassPrice(StudyCafeLockerPass lockerPass) {
        if (isUseLocker(lockerPass)) {
            return lockerPass.getPrice();
        }
        return 0;
    }

}
