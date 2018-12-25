package pro.apuzikov.alice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.apuzikov.alice.GameLevel;
import pro.apuzikov.alice.math.NumberGenerator;
import pro.apuzikov.alice.state.Result;
import pro.apuzikov.alice.state.StateProcessor;
import pro.apuzikov.alice.state.StateProcessorFactory;
import pro.apuzikov.alice.util.SessionStorage;
import pro.apuzikov.alice.util.exception.ResponseException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import static pro.apuzikov.alice.state.SpeachStates.*;
import static pro.apuzikov.alice.util.messages.ResponseMessages.*;

/**
 * {
 * "response": {
 * "text": "Здравствуйте! Это мы, хороводоведы.",
 * "tts": "Здравствуйте! Это мы, хоров+одо в+еды.",
 * "buttons": [
 * {
 * "title": "Надпись на кнопке",
 * "payload": {},
 * "url": "https://example.com/",
 * "hide": true
 * }
 * ],
 * "end_session": false
 * },
 * "session": {
 * "session_id": "2eac4854-fce721f3-b845abba-20d60",
 * "message_id": 4,
 * "user_id": "AC9WC3DF6FCE052E45A4566A48E6B7193774B84814CE49A922E163B8B29881DC"
 * },
 * "version": "1.0"
 * }
 */
@Service
public class ResponseService {

    private final static int START_MESSAGE_ID = 0;

    private SessionStorage sessionStorage;
    private StateProcessorFactory processorFactory;

    public HashMap getResponse(LinkedHashMap data) throws ResponseException {
        HashMap<String, Object> responseData = new HashMap<>();
        LinkedHashMap request = (LinkedHashMap) data.get("request");
        LinkedHashMap inputSession = (LinkedHashMap) data.get("session");
        HashMap<String, Object> response = new HashMap<>();
        response.put("end_session", false);
        String currentSessionId = inputSession.get("session_id").toString();
        Session session;
        Result result = null;
        if ((int) inputSession.get("message_id") == START_MESSAGE_ID || !sessionStorage.containsKey(currentSessionId)) {
            if (sessionStorage.containsKey(currentSessionId)) {
                sessionStorage.delete(currentSessionId);
            }
            session = new Session(STARTING);
            sessionStorage.put(currentSessionId, session);
            result = new Result(STARTING, WELCOME_MESSAGE, WELCOME_MESSAGE, false);
        } else {
            session = (Session) sessionStorage.get(currentSessionId);
            StateProcessor processor = processorFactory.getStateProcessor(session.getState());
            String command = request.get("command").toString();
            result = processor.process(session.getState(), command);
            session.setState(result.getState());
            session.addToResult(result.getValue());
        }
        response.put("end_session", result.isEndSession());
        response.put("text", result.getText());
        response.put("tts", result.getTts());
        responseData.put("response", response);
        responseData.put("session", inputSession);
        responseData.put("version", "1.0");
        session.getDialog().add(new Object[]{request, response});
        return responseData;
    }

    @Autowired
    public void setSessionStorage(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    @Autowired
    public void setProcessorFactory(StateProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }
}
