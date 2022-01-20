package ss.week3.password;

public class StrongChecker extends BasicChecker {

    public boolean acceptable(String suggestion) {
        boolean firstChar = Character.isLetter(suggestion.charAt(0));
        boolean lastChar = Character.isDigit(suggestion.charAt(suggestion.length()-1));
        if (super.acceptable(suggestion) && firstChar && lastChar) {
            return true;
        } else {
            return false;
        }
    }

    public String generatePassword() {
        return suggestion;
    }

}