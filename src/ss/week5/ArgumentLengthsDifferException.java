package ss.week5;

public class ArgumentLengthsDifferException extends WrongArgumentException{
    public ArgumentLengthsDifferException(String message) {
        super(message);
    }

    public ArgumentLengthsDifferException(String s1, String s2) {
        super("error: length of command line arguments "
                + "differ (" + s1.length() + ", " + s2.length() + ")");
    }

    public ArgumentLengthsDifferException(int s1, int s2) {
        super("error: length of command line arguments "
                + "differ (" + s1 + ", " + s2 + ")");
    }

}