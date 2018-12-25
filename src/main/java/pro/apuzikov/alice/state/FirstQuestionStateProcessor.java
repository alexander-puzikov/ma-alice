package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;

import static pro.apuzikov.alice.state.SpeachStates.QUIZING;

@Component
public class FirstQuestionStateProcessor extends DefaultStateProcessor {

    @Override
    protected String getPositiveText() {
        return "Поехали!?";
    }

    @Override
    protected String getPositiveTTS() {
        return "Поехали!?";
    }

    @Override
    SpeachStates nextPositiveState() {
        return QUIZING;
    }

}
