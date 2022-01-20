package ss.week3.bill;

public class Bill{
    public Printer printer;
    public double total;

    public interface Item {
        double getPrice();
        String toString();
    }

    public Bill(Printer printer){
        this.printer = printer;
    }

    public void addItem(Item item) {
        this.printer.printLine(item.toString(),item.getPrice());
        this.total += item.getPrice();
    }

    public void close() {
        this.printer.printLine("Total",getSum());
    }

    public double getSum() {
        return this.total;
    }

}