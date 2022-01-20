package ss.calculator.myCalculator;

import java.io.*;

public class MyMainCalculator {
    public static void main(String[] args) throws IOException {
        //Construct a new factory
        MyCalculatorFactory CalculatorFactory = new MyCalculatorFactory();

        var bufRead = new BufferedReader(new InputStreamReader(System.in));
        var outRead = new OutputStreamWriter(System.out);
        var printRead = new PipedReader();
        var printWrite = new PipedWriter(printRead);
        var printWrite2 = new PrintWriter(printWrite);

        Runnable runnableStreamCalc = CalculatorFactory.makeRunnableStreamCalculator(printRead,outRead);
        Thread thread = new Thread(runnableStreamCalc);
        thread.start();

        System.out.println("Please give input command: push, pop, add, sub, mult, div, dup, mod");
        String line;
        while( (line = bufRead.readLine() ) != null && !line.equals("quit") ) {
            System.out.println(line + " given \n Give command input: push, pop, add, sub, mult, div, dup, mod");
            printWrite2.println(line);

        }
        printWrite.close();
        outRead.close();
    }
}
