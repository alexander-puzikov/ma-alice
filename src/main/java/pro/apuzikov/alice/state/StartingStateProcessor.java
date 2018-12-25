package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;

import static pro.apuzikov.alice.state.SpeachStates.FIRST_QUESTION;
import static pro.apuzikov.alice.util.messages.ResponseMessages.SECOND_AGREED_MESSAGE;

@Component
public class StartingStateProcessor extends DefaultStateProcessor {

    @Override
    protected String getPositiveText() {
        return SECOND_AGREED_MESSAGE;
    }

    @Override
    protected String getPositiveTTS() {
        return SECOND_AGREED_MESSAGE;
    }

    @Override
    SpeachStates nextPositiveState() {
        return FIRST_QUESTION;
    }
}
