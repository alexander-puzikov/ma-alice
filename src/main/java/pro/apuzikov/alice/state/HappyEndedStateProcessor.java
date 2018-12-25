package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;

import static pro.apuzikov.alice.state.SpeachStates.ANSWERED;

@Component
public class HappyEndedStateProcessor extends DefaultStateProcessor {

    @Override
    public Result process(SpeachStates previousState, String command) {
        return new Result(nextPositiveState(), getPositiveText(), getPositiveTTS(), false);
    }

    @Override
    protected String getPositiveText() {
        return "И ваш ответ?";
    }

    @Override
    protected String getPositiveTTS() {
        return "И ответ ";
    }

    @Override
    SpeachStates nextPositiveState() {
        return ANSWERED;
    }
}
