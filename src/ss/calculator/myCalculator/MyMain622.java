package ss.calculator.myCalculator;

// 6.22 Implement a class with a main method that starts a separate thread running your calculator.


import java.io.*;

public class MyMain622 {
    public static void main(String[] args) throws IOException {
        MyCalculatorFactory CalculatorFactory = new MyCalculatorFactory(); // Create a new Calculator

        var br1 = new BufferedReader(new InputStreamReader(System.in));
        var or = new OutputStreamWriter(System.out); //Let the thread write directly to System.out, but connect the Reader to a piped stream
        var pr1 = new PipedReader();
        var pw1 = new PipedWriter(pr1);
        var pw = new PrintWriter(pw1);

        Runnable runnableStreamCalculator = CalculatorFactory.makeRunnableStreamCalculator(pr1, or);
        Thread thread = new Thread(runnableStreamCalculator);
        thread.start();

        System.out.println("Give calculator input: push, pop, add, sub, mult, div, dup, mod");
        String line;
        while ((line = br1.readLine()) != null && !line.equals("quit")) {
            System.out.println(line + " Given\nGive calculator input: push, pop, add, sub, mult, div, dup, mod");
            pw.println(line);
        }

        pw.close();
        or.close();


    }
}

