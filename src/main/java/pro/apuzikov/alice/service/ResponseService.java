package pro.apuzikov.alice.service;

import org.springframework.stereotype.Service;
import pro.apuzikov.alice.util.SessionStorage;

import java.util.HashMap;
import java.util.LinkedHashMap;

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


    private SessionStorage sessionStorage;

    public HashMap getResponse(LinkedHashMap data) {
        HashMap<String, Object> responseData = new HashMap<>();
        data.get("command");
        LinkedHashMap inputSession = (LinkedHashMap) data.get("session");
        HashMap<String, Object> response = new HashMap<>();
        response.put("text", getText());
        response.put("tts", getTextToSpeech());
        response.put("end_session", true);
        HashMap<String, Object> responseSession = new HashMap<>();
        responseSession.put("session_id", inputSession.get("session_id"));
        responseSession.put("message_id", inputSession.get("message_id"));
        responseSession.put("user_id", inputSession.get("user_id"));
        responseData.put("response", response);
        responseData.put("session", responseSession);
        responseData.put("version", "1.0");
        return responseData;
    }

    private String getText() {
        return "";
    }

    private String getTextToSpeech() {
        return "";
    }


    public void setSessionStorage(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }
}
