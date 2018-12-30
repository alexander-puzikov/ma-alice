package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;
import pro.apuzikov.alice.service.Session;

import static pro.apuzikov.alice.util.messages.ResponseMessages.WELCOME_MESSAGE;

@Component
public class WelcomeStateProcessor extends DefaultStateProcessor {

    @Override
    public Result process(String command, Session session) {
        return new Result(nextPositiveState(), getPositiveText(), getPositiveTTS(), false);
    }

    @Override
    protected String getPositiveText() {
        return WELCOME_MESSAGE;
    }

    @Override
    protected String getPositiveTTS() {
        return WELCOME_MESSAGE;
    }

    @Override
    SpeachStates nextPositiveState() {
        return SpeachStates.STARTING;
    }
}
