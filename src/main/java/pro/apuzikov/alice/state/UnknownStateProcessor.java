package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;
import pro.apuzikov.alice.service.Session;

import java.util.LinkedHashMap;
import java.util.List;

import static pro.apuzikov.alice.state.SpeachStates.ENDED;
import static pro.apuzikov.alice.state.SpeachStates.UNKNOWN_CONTINUE;
import static pro.apuzikov.alice.util.messages.ResponseMessages.END_MESSAGE;
import static pro.apuzikov.alice.util.messages.ResponseMessages.ERROR_MESSAGE;

@Component
public class UnknownStateProcessor extends DefaultStateProcessor {

    @Override
    public Result process(String command, Session session) {
        boolean endSession = false;
        SpeachStates previousState = session.getState();
        String text, tts;
        SpeachStates nextSpeachState;
        if (attitudeService.isAgree(command)) {
            if (!attitudeService.isDecline(command)) {
                LinkedHashMap[] dialog = (LinkedHashMap[]) session.getDialog().get(session.getDialog().size() - 1);
                text = dialog[0].get("command").toString();
                tts = text;
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
