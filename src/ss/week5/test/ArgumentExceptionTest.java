package ss.week5.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week5.ArgumentLengthsDifferException;
import ss.week5.TooFewArgumentsException;
import ss.week5.WrongArgumentException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test program for ArgumentException.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class ArgumentExceptionTest {

    /** Test variable for a <tt>WrongArgumentException</tt> object. */
    private WrongArgumentException wrongArgumentException;

    @BeforeEach
    public void setUp() {
        wrongArgumentException = new WrongArgumentException();
    }

    /**
     * Test <tt>TooFewArgumentsException</tt>
     */
    @Test
    public void testTooFewArgumentsException() {
        TooFewArgumentsException exception = new TooFewArgumentsException();
        assertTrue(exception instanceof WrongArgumentException);
        assertFalse(exception.getMessage().equals(wrongArgumentException.getMessage()));
    }

    /**
     * Test <tt>ArgumentLengthsDifferException</tt>
     */
    @Test
    public void testArgumentLengthsDifferException() {
        ArgumentLengthsDifferException exception = new ArgumentLengthsDifferException(2, 3);
        assertTrue(exception instanceof WrongArgumentException);
        assertFalse(exception.getMessage().equals(wrongArgumentException.getMessage()));
    }
}
