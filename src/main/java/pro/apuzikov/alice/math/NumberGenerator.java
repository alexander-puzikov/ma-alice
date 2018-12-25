package pro.apuzikov.alice.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.apuzikov.alice.GameLevel;

import java.util.Random;

@Component
public class NumberGenerator {

    private Random random;

    public int getNextNumber(GameLevel level) {
        int maxBound = 9; //easiest
        switch (level) {
            case EASY:
                maxBound = 19;
                break;
            case MEDIUM:
                maxBound = 59;
                break;
            case HARD:
                maxBound = 999;
                break;
            case HARDEST:
                maxBound = 9999;
                break;
        }
        return random.nextInt(maxBound) * getSign();
    }

    private int getSign() {
        return random.nextInt(10) >= 7 ? -1 : +1;
    }

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }
}
