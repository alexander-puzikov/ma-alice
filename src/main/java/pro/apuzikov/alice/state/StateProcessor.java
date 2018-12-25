package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;

@Component
public interface StateProcessor {

    Result process(SpeachStates previousState, String command);

}
