package study.basecamp;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import static study.basecamp.Scan.inputGuess;

@Setter
@Getter
public class GameImpl implements Game {
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    @Autowired
    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    NumberGenerator numberGenerator;
    int programNumber;
    int guess;
    int min;
    int max;
    int remainingGuesses;
    public boolean validNumberRange = true;


    @PostConstruct
    @Override
    public void reset() {
        min = numberGenerator.getMinNumber();
        max = numberGenerator.getMaxNumber();
        remainingGuesses = numberGenerator.getGuessCount();
        programNumber = numberGenerator.getRandomNumberInRange();
        log.debug("the number is {}", programNumber);
    }

    @Override
    public void startGame() {
        while (remainingGuesses > 0) {
            guess = inputGuess();
            if (validNumberRange = (guess >= min) && (guess <= max)) {
                if (isGameWon()) {
                    log.info("GUESS IS RIGHT! YOU WON!");
                    break;
                } else {
                    log.info("GUESS IS WRONG! TRY AGAIN");
                    check();
                    log.info("Minimum is - " + min + ". Maximum is" + max);
                    log.info(remainingGuesses + " TRIES LEFT");
                }
            } else log.info("INPUT GUESS IN RANGE [ " + min + " ; " + max + " ] !");
        }
        if (remainingGuesses == 0) {
            log.info("GAME OVER");
        }else if (remainingGuesses<0){
            log.error("REMAINING GUESSES COUNT IS INVALID");
            throw new  IllegalArgumentException ();
        }
    }

    @Override
    public void check() {
        validNumberRange = (guess >= min) && (guess <= max);
        if (validNumberRange) {
            if (guess > programNumber) {
                max = guess - 1;
            }
            if (guess < programNumber) {
                min = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == programNumber;
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }
}
