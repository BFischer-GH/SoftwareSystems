package ss.week1.test;

import org.junit.jupiter.api.Test;
import ss.week1.BabylonianAlgorithm;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BabylonianAlgorithmTest {

    @Test
    void babylonianAlgorithmTest() {
        // We test if the implementation gives the right result for various small numbers

        for (int i = 1; i <= 100; i += 1) {
            double guessedNumber = BabylonianAlgorithm.babylonianAlgorithm(i);
            double actualNumber = Math.sqrt(i);
            double difference = Math.abs(actualNumber - guessedNumber);

            // Test if the difference is less than a %
            assertTrue((difference/actualNumber) < 0.01);
        }

        // We test if the implementation gives the right result for various bigger numbers

        for (int i = 1000; i <= 10000000; i += 1000) {
            double guessedNumber = BabylonianAlgorithm.babylonianAlgorithm(i);
            double actualNumber = Math.sqrt(i);
            double difference = Math.abs(actualNumber - guessedNumber);

            // Test if the difference is less than a %
            assertTrue((difference/actualNumber) < 0.01);
        }
    }
}
