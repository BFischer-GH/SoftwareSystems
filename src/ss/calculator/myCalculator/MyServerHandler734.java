package ss.calculator.myCalculator;

import java.io.*;
import java.net.Socket;

public class MyServerHandler734 implements Runnable {
    private InputStreamReader input;
    private OutputStreamWriter output;
    private boolean run = true;

    // Constructor
    public MyServerHandler734(Socket socket) throws IOException {
        this.input = new InputStreamReader(socket.getInputStream());
        this.output = new OutputStreamWriter(System.out);
    }// End constructor


    @Override
    public void run() {
        BufferedReader br = new BufferedReader(this.input);
        PrintWriter pw = new PrintWriter(this.output, true); // true results in autoFlush

        while (this.run) {
            try {
                String line = br.readLine();
                pw.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void stop() {
        this.run = false;
    }


}
