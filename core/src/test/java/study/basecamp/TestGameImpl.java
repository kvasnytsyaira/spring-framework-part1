package study.basecamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestGameImpl {

    @Test
    void TestStartGame_WhenRemainingGuessesCountIsInvalid() {
        GameImpl game = new GameImpl();
        game.setRemainingGuesses(-6);
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.startGame());
    }
    @Test
    void TestCheck_WhenValidNumberRangeIsFalse_ExpectedRemainingGuessesDecrement() {
        GameImpl game = new GameImpl();
        game.setRemainingGuesses(10);
        game.setValidNumberRange(false);
        game.check();
        assertEquals(9, game.remainingGuesses);
    }
    @Test
    void TestCheck_WhenValidNumberIsTrue_ExpectedMinNumberChange(){
        GameImpl game = new GameImpl();
        game.setValidNumberRange(true);
        game.setGuess(45);
        game.setMin(0);
        game.setMax(100);
        game.setProgramNumber(80);
        game.setRemainingGuesses(6);
        game.check();
        assertEquals(5,game.getRemainingGuesses());
        assertEquals(46,game.getMin());
    }
    @Test
    void TestCheck_WhenValidNumberIsTrue_ExpectedMaxNumberChange(){
        GameImpl game = new GameImpl();
        game.setValidNumberRange(true);
        game.setGuess(80);
        game.setMin(0);
        game.setMax(100);
        game.setProgramNumber(60);
        game.setRemainingGuesses(1);
        game.check();
        assertEquals(0,game.getRemainingGuesses());
        assertEquals(79,game.getMax());
    }
    @Test
    void TestIsGameWon_WhenGuessAndProgNumberAreNotEqual_ExpectedFalse() {
        GameImpl game = new GameImpl();
        game.setGuess(10);
        game.setProgramNumber(15);
        assert !game.isGameWon();
    }
    @Test
    void TestIsGameWon_WhenGuessAndProgNumberAreEqual_ExpectedTrue(){
        GameImpl game = new GameImpl();
        game.setGuess(50);
        game.setProgramNumber(50);
        assert game.isGameWon();
    }

}