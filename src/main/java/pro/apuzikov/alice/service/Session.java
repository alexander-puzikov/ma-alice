package pro.apuzikov.alice.service;

import pro.apuzikov.alice.state.SpeachStates;

import java.util.*;

public class Session {
    private int result;
    private SpeachStates state;
    private List<Object[]> dialog;
    private String sessionId;

    public Session(int result, SpeachStates state, String sessionId) {
        this(result, state);
        this.sessionId = sessionId;
    }

    public Session(int result, SpeachStates state) {
        this(state);
        this.result = result;
    }

    public Session(SpeachStates state) {
        this.result = 0;
        this.state = state;
        dialog = new ArrayList<>();
    }

    public int getResult() {
        return result;
    }

    public SpeachStates getState() {
        return state;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setState(SpeachStates state) {
        this.state = state;
    }

    public List<Object[]> getDialog() {
        return dialog;
    }

    public void addToResult(int value) {
        result += value;
    }

    public String getId() {
        return sessionId;
    }
}
