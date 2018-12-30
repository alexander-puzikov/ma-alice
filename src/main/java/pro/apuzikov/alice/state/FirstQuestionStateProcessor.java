package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;

import static pro.apuzikov.alice.state.SpeachStates.QUIZING;
import static pro.apuzikov.alice.util.messages.ResponseMessages.GO_ON_MESSAGE;

@Component
public class FirstQuestionStateProcessor extends DefaultStateProcessor {

    @Override
    protected String getPositiveText() {
        return GO_ON_MESSAGE;
    }

    @Override
    protected String getPositiveTTS() {
        return GO_ON_MESSAGE;
    }

    @Override
    SpeachStates nextPositiveState() {
        return QUIZING;
    }

}
