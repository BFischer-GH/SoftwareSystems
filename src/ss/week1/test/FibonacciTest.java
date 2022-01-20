package ss.week1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ss.week1.FibonacciPair;

public class FibonacciTest {

    @Test
    void fibonacciWithArrayTest() {
        assertEquals(0, FibonacciPair.fibonacciWithArray(0));
        assertEquals(5, FibonacciPair.fibonacciWithArray(5));
        assertEquals(701408733, FibonacciPair.fibonacciWithArray(44));
    }

    @Test
    void fibonacciRecursiveTest() {
        assertEquals(0, FibonacciPair.fibonacciRecursive(0));
        assertEquals(5, FibonacciPair.fibonacciRecursive(5));
        assertEquals(701408733, FibonacciPair.fibonacciRecursive(44));
    }
}
