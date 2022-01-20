package ss.calculator.myCalculator;

import ss.calculator.StreamCalculator;

import java.io.Reader;
import java.io.Writer;

public class MyRunnableStreamCalculator implements Runnable {
    // Create a simple wrapper around your StreamCalculator
    private final Reader reader;
    private final Writer writer;

    // Constructor
    public MyRunnableStreamCalculator (Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
            MyCalculatorFactory MyCalculatorFactory = new MyCalculatorFactory();
            StreamCalculator MyStreamCalculator = MyCalculatorFactory.makeStreamCalculator(MyCalculatorFactory.makeCalculator());
            MyStreamCalculator.process(reader, writer);
            }
}

