package study.basecamp;

public interface NumberGenerator {
    int getRandomNumberInRange();
    int getMaxNumber();
    int getGuessCount();
    int getMinNumber();
    void setMaxNumber(int maxNumber);
    void setGuessCount(int guessCount);
    void setMinNumber(int minNumber);

}
