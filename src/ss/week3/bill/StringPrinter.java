package ss.week3.bill;

public class StringPrinter implements Printer{
    private String output = "";

    @Override
    public void printLine(String text, double price) {
        output += String.format(format(text,price));
    }

    public String getResult() {
        return this.output;
    }
}