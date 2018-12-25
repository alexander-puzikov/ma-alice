package pro.apuzikov.alice.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class StateProcessorFactory {

    private ApplicationContext context;

    public StateProcessor getStateProcessor(SpeachStates state) {
        StateProcessor stateProcessor;
        switch (state) {
            case STARTING:
                stateProcessor = context.getBean(StartingStateProcessor.class);
                break;
            case FIRST_QUESTION:
                stateProcessor = context.getBean(FirstQuestionStateProcessor.class);
                break;
            case QUIZING:
                stateProcessor = context.getBean(QuizingStateProcessor.class);
                break;
            case UNKNOWN_CONTINUE:
                stateProcessor = context.getBean(UnknownStateProcessor.class);
                break;
            case HAPPY_ENDED:
                stateProcessor = context.getBean(HappyEndedStateProcessor.class);
                break;
            case ANSWERED:
                stateProcessor = context.getBean(AnsweredStateProcessor.class);
                break;
            default:
                stateProcessor = context.getBean(EndedStateProcessor.class);
                break;
        }

        return stateProcessor;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
