package pro.apuzikov.alice.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pro.apuzikov.alice.service.Session;

import static pro.apuzikov.alice.state.SpeachStates.UNKNOWN_CONTINUE;
import static pro.apuzikov.alice.util.messages.ResponseMessages.END_MESSAGE;
import static pro.apuzikov.alice.util.messages.ResponseMessages.ERROR_MESSAGE;

@Component
public class AnsweredStateProcessor extends DefaultStateProcessor {
    Logger logger = LoggerFactory.getLogger(AnsweredStateProcessor.class);

    @Override
    public Result process(String command, Session session) {
        boolean endSession = false;
        String text, tts;
        SpeachStates nextSpeachState;
        try {
            logger.info("Trying to parse answer " + command + " for session - " + session.getId());
            Integer answer = Integer.valueOf(command);
            boolean correctAnswer = answer == session.getResult();
            text = correctAnswer ? "Вы ответили верно! " : "Нет, к сожалению правильный ответ " + session.getResult();
            tts = text;
            nextSpeachState = nextPositiveState();
        } catch (NumberFormatException e) {
            logger.info("Couldn't parse answer " + command + " for session - " + session.getId());
            text = ERROR_MESSAGE;
            tts = ERROR_MESSAGE;
            nextSpeachState = UNKNOWN_CONTINUE;

        }
        return new Result(nextSpeachState, text, tts, true);
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
