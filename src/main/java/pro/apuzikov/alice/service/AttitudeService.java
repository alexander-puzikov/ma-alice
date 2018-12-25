package pro.apuzikov.alice.service;

import org.springframework.stereotype.Controller;
import pro.apuzikov.alice.util.text.TextTokens;

import java.util.Arrays;

@Controller
public class AttitudeService {

    public boolean isAgree(String text) {
        return Arrays.stream(TextTokens.agreementTokens).anyMatch(s -> text.toLowerCase().contains(s));
    }

    public boolean isDecline(String text) {
        return Arrays.stream(TextTokens.refuseTokens).anyMatch(s -> text.toLowerCase().contains(s));
    }

    public boolean isProceed(String text) {
        return true;
    }

    public boolean isStop(String text) {
        return true;
    }

}
