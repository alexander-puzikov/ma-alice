package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;
import pro.apuzikov.alice.service.Session;

import static pro.apuzikov.alice.state.SpeachStates.ANSWERED;

@Component
public class HappyEndedStateProcessor extends DefaultStateProcessor {

    @Override
    public Result process(String command, Session session) {
        return new Result(nextPositiveState(), getPositiveText(), getPositiveTTS(), false);
    }

    @Override
    protected String getPositiveText() {
        return "И ваш ответ?";
    }

    @Override
    protected String getPositiveTTS() {
        return "И ваш ответ?";
    }

    @Override
    SpeachStates nextPositiveState() {
        return ANSWERED;
    }
}
