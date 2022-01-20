package ss.calculator.myCalculator;
// Assignment 7.3

import ss.calculator.CalculatorFactory;
import ss.calculator.CalculatorServer;

import java.io.IOException;
import java.util.Scanner;

public class MyMainServer73 {
    //7.3.1 Create a class with a main method for your server application.
    public static void main(String[] args) throws IOException, InterruptedException {
        //7.3.2 Let your server application ask the user for a port number
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Please enter a port number between 0 and 65536 \n");
        int inputPortInt = scannerInput.nextInt();

        CalculatorFactory calculatorFactory = new MyCalculatorFactory();
        CalculatorServer myCalculatorServer = calculatorFactory.makeCalculatorServer();

        // 7.3.2 Let your server application ask the user for a port number and check that it is a valid number (between 0 and 65536).
        if (inputPortInt >= 0 && inputPortInt <= 65536) {
            // 7.3.2 Let your application start the server on the given port number.
            myCalculatorServer.start(inputPortInt);

            //Let your application use the getPort method to get the actual port of the server in case port number 0 was
            //used, and display the port number to the user.
            if (inputPortInt == 0) {
                myCalculatorServer.getPort();
            }
        } else {
            System.out.println("Invalid port number, restart program");
            System.exit(0);

        }
        // 7.3.2 When the user types “quit”, the server should stop  and the application should terminate.b
        boolean run = true;
        while (run) {
            System.out.println("Server Running...");
            Scanner scanner2 = new Scanner(System.in);
            String inputQuit = scanner2.nextLine();
            if (inputQuit.equals("quit")) {
                System.out.println("Stopping server");
                run = false;
            }
        }

        myCalculatorServer.stop();
    }

}
