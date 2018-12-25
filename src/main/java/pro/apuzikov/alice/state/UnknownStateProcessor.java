package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;

import static pro.apuzikov.alice.state.SpeachStates.ENDED;
import static pro.apuzikov.alice.state.SpeachStates.UNKNOWN_CONTINUE;
import static pro.apuzikov.alice.util.messages.ResponseMessages.END_MESSAGE;
import static pro.apuzikov.alice.util.messages.ResponseMessages.ERROR_MESSAGE;

@Component
public class UnknownStateProcessor extends DefaultStateProcessor {

    @Override
    public Result process(SpeachStates previousState, String command) {
        boolean endSession = false;
        String text, tts;
        SpeachStates nextSpeachState;
        if (attitudeService.isAgree(command)) {
            if (!attitudeService.isDecline(command)) {
                text = getPositiveText(previousState);
                tts = getPositiveTTS(previousState);
                nextSpeachState = previousState;
            } else {
                text = ERROR_MESSAGE;
                tts = ERROR_MESSAGE;
                nextSpeachState = UNKNOWN_CONTINUE;
            }
        } else {
            String message = END_MESSAGE[random.nextInt(END_MESSAGE.length)];
            text = message;
            tts = message;
            nextSpeachState = ENDED;
            endSession = true;
        }
        return new Result(nextSpeachState, text, tts, endSession);
    }

    private String getPositiveText(SpeachStates previousState) {
        return null;
    }

    private String getPositiveTTS(SpeachStates previousState) {
        return null;
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
        return null;
    }
}
