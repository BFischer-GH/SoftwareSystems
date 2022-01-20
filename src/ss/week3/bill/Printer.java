package ss.week3.bill;

public interface Printer {

    default String format(String text, double price){
        return String.format("%-20s %20.2f%n",text,price); // tabs ipv spaties.
    }

    void printLine(String text, double price);
}