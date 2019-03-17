package study.basecamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestNumberGeneratorImpl {

    @Test
    void TestGetRandomNumberInRange_0_100() {
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        numberGenerator.setMinNumber(0);
        numberGenerator.setMaxNumber(100);
        int randomNumberInRange =  numberGenerator.getRandomNumberInRange();
        assert (randomNumberInRange>=numberGenerator.getMinNumber() && randomNumberInRange<=numberGenerator.getMaxNumber());
    }
    @Test
    void TestRandomNumberInRange_WhenMinIsGreaterThenMax_ExpectedException(){
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        numberGenerator.setMinNumber(100);
        numberGenerator.setMaxNumber(0);
        Assertions.assertThrows(IllegalArgumentException.class , () ->numberGenerator.getRandomNumberInRange()) ;
    }
    @Test
    void TestRandomNumberInRange_WhenMinMaxNumbersAreNotSet_ExpectedException(){
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        Assertions.assertThrows(IllegalArgumentException.class , () ->numberGenerator.getRandomNumberInRange()) ;
    }

}