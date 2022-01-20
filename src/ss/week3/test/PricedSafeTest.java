package ss.week3.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.hotel.PricedSafe;

import static org.junit.jupiter.api.Assertions.*;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;


    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item,
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getPrice(), 0,
        		"GetPrice should return the price of the safe.");
    }

    @Test
    public void testGetPrice(){
        assertEquals(this.PRICE,safe.getPrice(),0.0001);
    }

    @Test
    public void testToString(){
        assertEquals("This safe is: 6.36", safe.toString());
    }

    @Test
    public void testIsAcitvated(){
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }
    @Test
    public void testDeactivatedSafe() {
        safe.activate(WRONG_PASSWORD);
        assertFalse(safe.isOpen());
        assertFalse(safe.isActive());
    }

    @Test
    public void testDeactivation() {
        safe.open(CORRECT_PASSWORD);
        assertFalse(safe.isOpen());
        assertFalse(safe.isActive());
    }
    @Test
    public void testSafeStaysClosed(){
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    //    Test that after activating a safe with the correct password it cannot be opened with an incorrect
//    password, but after being opened with the correct password it is activated and open;
    @Test
    public void testSafeOpening() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isOpen());
        safe.open(CORRECT_PASSWORD);
        assertTrue(safe.isOpen());
    }
    //    Test if after activating and opening a safe with the correct password, and closing it, the safe is
//    closed and activated;
    @Test
    public void testAfterActivation(){
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        assertFalse(safe.isOpen());
        assertTrue(safe.isActive());
    }


    //    Test if after closing a deactivated safe, it is closed and deactivated.
    @Test
    public void testAfterClosing(){
        safe.close();
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
}
