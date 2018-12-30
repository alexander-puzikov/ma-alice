package pro.apuzikov.alice.state;

import org.springframework.stereotype.Component;
import pro.apuzikov.alice.service.Session;

@Component
public interface StateProcessor {

    Result process(String command, Session session);

}
