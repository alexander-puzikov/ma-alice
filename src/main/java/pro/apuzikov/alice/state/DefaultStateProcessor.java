package pro.apuzikov.alice.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.apuzikov.alice.service.AttitudeService;
import pro.apuzikov.alice.service.Session;

import java.util.LinkedHashMap;
import java.util.Random;

import static pro.apuzikov.alice.state.SpeachStates.*;
import static pro.apuzikov.alice.util.messages.ResponseMessages.END_MESSAGE;
import static pro.apuzikov.alice.util.messages.ResponseMessages.ERROR_MESSAGE;

@Component
public abstract class DefaultStateProcessor implements StateProcessor {

    protected AttitudeService attitudeService;

    protected Random random;

    @Override
    public Result process(String command, Session session) {
        boolean endSession = false;
        String text, tts;
        SpeachStates nextSpeachState;
        if (attitudeService.isAgree(command)) {
            if (!attitudeService.isDecline(command)) {
                text = getPositiveText();
                tts = getPositiveTTS();
                nextSpeachState = nextPositiveState();
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

    protected abstract String getPositiveText();

    protected abstract String getPositiveTTS();

    abstract SpeachStates nextPositiveState();

    @Autowired
    public void setAttitudeService(AttitudeService attitudeService) {
        this.attitudeService = attitudeService;
    }

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }
}

