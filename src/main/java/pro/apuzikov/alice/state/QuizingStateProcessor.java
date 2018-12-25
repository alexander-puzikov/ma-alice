package pro.apuzikov.alice.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.apuzikov.alice.GameLevel;
import pro.apuzikov.alice.math.NumberGenerator;

import static pro.apuzikov.alice.state.SpeachStates.*;
import static pro.apuzikov.alice.util.messages.ResponseMessages.*;
import static pro.apuzikov.alice.util.messages.ResponseMessages.ENDING_MESSAGE;

@Component
public class QuizingStateProcessor extends DefaultStateProcessor {

    private NumberGenerator numberGenerator;

    @Override
    public Result process(SpeachStates previousState, String command) {
        boolean endSession = false;
        String text, tts;
        SpeachStates nextSpeachState;
        Integer value = getNextQuizes();
        if (attitudeService.isAgree(command)) {
            if (!attitudeService.isDecline(command)) {
                text = getPositiveText(value);
                tts = getPositiveTTS(value);
                nextSpeachState = nextPositiveState();
            } else {
                text = ERROR_MESSAGE;
                tts = ERROR_MESSAGE;
                nextSpeachState = UNKNOWN_CONTINUE;
            }
        } else {
            text = ENDING_MESSAGE;
            tts = ENDING_MESSAGE;
            nextSpeachState = HAPPY_ENDED;
        }
        return new Result(nextSpeachState, text, tts, endSession, value);
    }

    protected String getPositiveText(int value) {
        return value > 0 ? ("+" + value) : String.valueOf(value);
    }

    protected String getPositiveTTS(int value) {
        return (value > 0 ? "плюс " : "минус ") + value;
    }


    @Override
    protected String getPositiveText() {
        return null;
    }

    @Override
    protected String getPositiveTTS() {
        return null;
    }

    @Override
    SpeachStates nextPositiveState() {
        return QUIZING;
    }

    @Autowired
    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    private Integer getNextQuizes() {
        int number = numberGenerator.getNextNumber(GameLevel.EASIEST);
        while (number == 0) {
            number = numberGenerator.getNextNumber(GameLevel.EASIEST);
        }
        return number;
    }

}
