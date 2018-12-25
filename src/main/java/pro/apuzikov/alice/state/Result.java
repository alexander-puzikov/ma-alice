package pro.apuzikov.alice.state;

public class Result {

    private SpeachStates state;
    private String text;
    private String tts;
    private boolean endSession;
    private int value;

    public Result(SpeachStates state, String text, String tts, boolean endSession) {
        this.state = state;
        this.text = text;
        this.tts = tts;
        this.endSession = endSession;
        value = 0;
    }

    public Result(SpeachStates state, String text, String tts, boolean endSession, int value) {
        this.state = state;
        this.text = text;
        this.tts = tts;
        this.endSession = endSession;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public SpeachStates getState() {
        return state;
    }

    public String getText() {
        return text;
    }

    public String getTts() {
        return tts;
    }

    public boolean isEndSession() {
        return endSession;
    }
}
