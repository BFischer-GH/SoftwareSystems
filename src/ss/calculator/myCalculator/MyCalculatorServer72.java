package ss.calculator.myCalculator;

import ss.calculator.CalculatorServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Assignment 7.2/7.3 server for streaming calculator.
 */

public class MyCalculatorServer72 implements CalculatorServer, Runnable {
    public static int port; // Given Port value

    MyCalculatorFactory CalculatorFactory = new MyCalculatorFactory(); // Create a new Calculator
    private List<MyClientHandler> handlers = new ArrayList<MyClientHandler>();
    private ServerSocket serversocket;
    private Thread thread;
    // private ServerSocket socket = new ServerSocket(Port); // Constructor
    private boolean run = true;

    // Empty constructor
    public MyCalculatorServer72() {

    }

    // 3. Start implementing your CalculatorServer class. First implement start, which should create a
    // new ServerSocket object (given a desired port). Start a thread that accepts new connections.
    // Hint: you can make your CalculatorServer implement the Runnable interface. Make start create
    // and run a new thread that runs the Calculator server.

    /**
     * @param port the desired port (or 0 to take any available TCP port)
     * @throws IOException
     */
    @Override
    public void start(int port) throws IOException {

        //First implement start, which should create a new ServerSocket object (given a desired port).
        // Start a thread that accepts new connections
        try {
            this.serversocket = new ServerSocket(port);
            System.out.println("Started server at port:" + this.serversocket.getLocalPort());

            this.thread = new Thread(this);
            this.thread.start();// The start hier voert de run onderaan uit en heeft niks met de run hierboven te maken
        } catch (Exception e) {
            System.out.println("Couldn't start at port" + this.serversocket.getLocalPort());
            e.printStackTrace();
            return;
        }
    }


    // Get local port, this method is used above
    @Override
    public int getPort() {
        return this.serversocket.getLocalPort();
    }
    // 5. To implement the stop method, you can close the ServerSocket object and then wait for the thread
    //to be done (tip: join). Notice that after closing the ServerSocket, you will see an exception in
    //your run method which needs to be handled appropriately.
    // 6. Ensure that your run method correctly handles the exception when stop closes the socket.

    @Override
    /**
     * To implement the stop method, you can close the ServerSocket object and then wait for the thread
     * to be done (tip: join). Notice that after closing the ServerSocket, you will see an exception in
     * your run method which needs to be handled appropriately
     */
    public void stop() throws IOException, InterruptedException {
        serversocket.close();
        this.thread.join();
        return;
    }

    // 4. The run method of your Runnable should accept connections from the ServerSocket. For every
    // connection, a ClientHandler (separate class) should be created to handle the incoming messages.
    // The client handler will be very similar to the runnable calculator that you made in week 6.
    @Override
    public void run() {
        boolean run = true;
        while (run) {

            // Socket sock = null;
            try {
                Socket sock = serversocket.accept();
                MyClientHandler ch = new MyClientHandler(sock);
                this.handlers.add(ch);
                (new Thread(ch)).start();

            } catch (IOException e) {
                System.out.println("Terminated server at port" + this.serversocket.getLocalPort());
                System.out.println("Oops, something went wrong");
                run = false;
            }
        }


    }
}
