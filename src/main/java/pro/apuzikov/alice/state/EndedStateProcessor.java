package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;
import pro.apuzikov.alice.service.Session;

import static pro.apuzikov.alice.state.SpeachStates.ENDED;
import static pro.apuzikov.alice.util.messages.ResponseMessages.END_MESSAGE;

@Component
public class EndedStateProcessor extends DefaultStateProcessor {
    @Override
    public Result process(String command, Session session) {
        String message = END_MESSAGE[random.nextInt(END_MESSAGE.length)];
        String text = message;
        String tts = message;
        return new Result(ENDED, text, tts, true);
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
