package ss.calculator.myCalculator;

import ss.calculator.StreamCalculator;

import java.io.*;
import java.net.Socket;
// ClientHandler (separate class) should be created to handle the incoming messages.
//The client handler will be very similar to the runnable calculator that you made in week 6.
// Note it's almost exactly the same as MyRunnableCalculator

public class MyClientHandler implements Runnable{

    private final Reader reader;
    private final Writer writer;

    public MyClientHandler(Socket sock) throws IOException {
    this.reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    this.writer = new PrintWriter(sock.getOutputStream()); // System.out zorgt dat de output in de consule komt.

    }


    @Override
    public void run() {
        MyCalculatorFactory MyCalculatorFactory = new MyCalculatorFactory();
        StreamCalculator MyStreamCalculator = MyCalculatorFactory.makeStreamCalculator(MyCalculatorFactory.makeCalculator());

        MyStreamCalculator.process(reader, writer);

    }
}
