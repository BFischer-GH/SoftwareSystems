package ss.week3.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BillTest {

    public StringPrinter stringPrinter;
    public Bill bill;

    @BeforeEach
    public void setUp(){
        this.stringPrinter  =new StringPrinter();
        this.bill = new Bill(this.stringPrinter);

    }
public  class Item  implements Bill.Item {
        double price;
        String text;

        // Constructor
        public Item(String text, double price) {
            this.price = price;
            this.text = text;
        }

        public double getPrice(){
            return this.price;
        }
        public String toString(){
            return this.text;
        }

} // Begin the testing

    @Test
    public void testBeginState(){
        assertEquals(0.00, bill.getSum(), "Begin bill is empty and no charge");
    }
    @Test
    public void testNewItem(){
        Item apple = new Item("Apple", 3.00);
        Item banana = new Item("Banana", 4.50);
        bill.addItem(apple);

        assertEquals(bill.getSum(), 3.00);
        assertTrue(this.stringPrinter.getResult().contains("Apple"), "String contains the right order");

        bill.addItem(banana);
        bill.close();

        assertTrue(this.stringPrinter.getResult().contains("Banana"));
        assertEquals(7.50, bill.getSum(), 0.001); //Delta value is to avoid problems with round-off errors (1 decimal beyond double?)
    }
}
