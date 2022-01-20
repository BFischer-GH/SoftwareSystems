package ss.week5;

public class TooFewArgumentsException extends WrongArgumentException{
    public TooFewArgumentsException(String message) {
        super(message);
    }

    public TooFewArgumentsException() {
        super("error: too few command line arguments");
    }
}