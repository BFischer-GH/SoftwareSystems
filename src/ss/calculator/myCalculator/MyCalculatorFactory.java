package ss.calculator.myCalculator;

import ss.calculator.Calculator;
import ss.calculator.CalculatorFactory;
import ss.calculator.CalculatorServer;
import ss.calculator.StreamCalculator;

import java.io.Reader;
import java.io.Writer;

public class MyCalculatorFactory implements CalculatorFactory {

    public Calculator makeCalculator() {

        return new MyCalculator();
    }

    public StreamCalculator makeStreamCalculator(Calculator calculator) {
        //Changed for week 6
        return new MyStreamCalculator(calculator);
    }

    public Runnable makeRunnableStreamCalculator(Reader reader, Writer writer) {
        // Changed for week 7
        return new MyRunnableStreamCalculator(reader, writer);
    }


    // 7.2 let your CalculatorFactory return an object of the class you just created.
    public CalculatorServer makeCalculatorServer() {

        return new MyCalculatorServer72();
    }
}
