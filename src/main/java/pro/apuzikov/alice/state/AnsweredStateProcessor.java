package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;

import static pro.apuzikov.alice.util.messages.ResponseMessages.END_MESSAGE;

@Component
public class AnsweredStateProcessor extends DefaultStateProcessor {
    @Override
    public Result process(SpeachStates previousState, String command) {
        return new Result(nextPositiveState(), getPositiveText(), getPositiveText(), true);
    }

    @Override
    protected String getPositiveText() {
        return END_MESSAGE[random.nextInt(END_MESSAGE.length)];
    }

    @Override
    protected String getPositiveTTS() {
        return null;
    }

    @Override
    SpeachStates nextPositiveState() {
        return SpeachStates.ENDED;
    }
}
