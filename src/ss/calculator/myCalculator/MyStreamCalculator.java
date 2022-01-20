package ss.calculator.myCalculator;

import ss.calculator.Calculator;
import ss.calculator.StreamCalculator;

import java.io.*;

public class MyStreamCalculator implements StreamCalculator {

    private static Calculator calculator; // create varialbe

    public MyStreamCalculator(Calculator calculator) {
 // Constructor that receives an object that implements the Calculator
        this.calculator = calculator;

    }

    @Override
    public void process(Reader input, Writer output) {

        try (BufferedReader bufRead = new BufferedReader(input);
            BufferedWriter bufWrite = new BufferedWriter(output))
        {

            String line;
            while ((line = bufRead.readLine()) != null) {

                try{
                String[] command = line.split(" ");
                switch (command[0]) {
                    case "push":
                        if (command.length < 2) {
                            bufWrite.write("error: no input value \n");
                            bufWrite.flush();
                        } else {
                            Double commandDouble = Double.parseDouble(command[1]);
                            calculator.push(commandDouble);
                        }
                        break;
                    case "pop":
                        Double answer = calculator.pop();
                        bufWrite.write(Double.toString(answer) + "\n");
                        bufWrite.flush();
                        break;
                    case "add":
                        calculator.add();
                        break;
                    case "sub":
                        calculator.sub();
                        break;
                    case "mult":
                        calculator.mult();
                        break;
                    case "div":
                        calculator.div();
                        break;
                    default:
                        bufWrite.write("error: ");
                        bufWrite.flush();
                        break;
                    }
                } catch (Exception ex) {
                    bufWrite.write(ex.getMessage());
                    bufWrite.flush();
                }
            }

        } catch (IOException ex) {
            return;
        }
    }
}