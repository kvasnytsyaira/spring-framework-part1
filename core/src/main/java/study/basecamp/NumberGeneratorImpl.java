package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {
    private static final Logger log = LoggerFactory.getLogger(NumberGeneratorImpl.class);

    private final Random random = new Random();
    private int maxNumber;
    private int minNumber;
    private int guessCount;

    @Override
    @Autowired
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    @Autowired
    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    @Override
    @Autowired
    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }



    @Override
    public int getRandomNumberInRange() {
        if (minNumber >= maxNumber) {
            log.info("MAX NUMBER MUST BE GREATER THEN MIN NUMBER");
            throw new  IllegalArgumentException ();
        }
        int i = random.nextInt((maxNumber - minNumber) + 1) + minNumber;
        return i;
    }
    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
    @Override
    public int getMinNumber() {
        return minNumber;
    }
    @Override
    public int getGuessCount() {
        return guessCount;
    }
}
