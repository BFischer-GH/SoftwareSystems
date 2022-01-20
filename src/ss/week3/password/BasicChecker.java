package ss.week3.password;

public class BasicChecker implements Checker{
    protected static String suggestion = "abcdef5";

    public boolean acceptable(String passWord) {
        if (suggestion.length() >= 6 && !suggestion.contains(" ")) {
            return true;
        } else {
            return false;
        }
    }

    public String generatePassword(){
        return suggestion;
    }

}