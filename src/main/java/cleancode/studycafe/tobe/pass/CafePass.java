package cleancode.studycafe.tobe.pass;

import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;

import java.util.List;

public class CafePass {
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public List<StudyCafePass> findCafePassFor(StudyCafePassType type) {
        List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
        List<StudyCafePass> typePasses = studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == type)
            .toList();
        outputHandler.showPassListForSelection(typePasses);
        return typePasses;
    }
}
