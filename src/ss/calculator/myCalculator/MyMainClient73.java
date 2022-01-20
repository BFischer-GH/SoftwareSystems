package ss.calculator.myCalculator;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyMainClient73 {

  public static void main(String[] args) throws IOException {
    // 7.3.4 Let your client application ask the user for a server address and for a valid port number.

    Scanner scannerServerAddress = new Scanner(System.in);
    System.out.println("Please enter a valid server address (Localhost)");
    String inputServerAddress = scannerServerAddress.nextLine();
    inputServerAddress = !inputServerAddress.equals("") ? inputServerAddress : "localhost";

    Scanner scannerPort = new Scanner(System.in);
    System.out.println("Please enter a port number between 0 and 65536");
    int inputPort = scannerPort.nextInt();

    // 7.3.4 Then, let your client application make a connection using the constructor of Socket,
    Socket sock = null;
    try {
      InetAddress inetAddress = InetAddress.getByName(inputServerAddress);
      sock = new Socket(inputServerAddress, inputPort);
      //sock.setSoTimeout(800);
      System.out.println("Started connection on port: " + inputPort);
    } catch (UnknownHostException e) {
      e.printStackTrace();
      System.exit(1);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(2);
    }
    // Write an appropriate runnable that reads lines from the InputStream of the Socket until the stream
    // is closed and write all lines to System.out.
    PrintWriter out = new PrintWriter(sock.getOutputStream(),
        true); // the true creates an autoflush!
    MyServerHandler734 serverhandler = new MyServerHandler734(sock);
    Thread thread = new Thread(serverhandler);
    thread.start();

    //  Forward all lines that are not “quit” to the server and if “quit” is used, close the connection and terminate the program.
    boolean run = true;
    while (run) {
      Scanner scanner2 = new Scanner(System.in);
      String inputQuit = scanner2.nextLine();
      if (inputQuit.equals("quit")) {
        System.out.println("Stopping server");
        run = false;
      } else {
        out.println(inputQuit); // Cannot be = as this gives errors
      }

    }

  }
}
