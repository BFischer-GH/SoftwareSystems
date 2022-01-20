package ss.week3.password;

public class BasicPassword extends Object{

    private static String passWord;
    public static final String INITIAL = "InitialPassword";
    //@ public invariant INITIAL == "InitialPassword";

    /*@
        requires INITIAL != null;
    */
    public BasicPassword() {
        passWord = this.INITIAL;
    }

    /*@
        requires suggestion instanceof String;
        ensures suggestion.length() < 6 || suggestion.matches(" ") ==> false;
        ensures suggestion.length() >= 6 && !suggestion.matches(" ") ==> true;
    */
    public boolean acceptable(String suggestion) {
        if (suggestion.length() >= 6 && !suggestion.contains(" ")) {
            return true;
        } else {
            return false;
        }
    }

    /*@
        ensures test.equals(passWord) ==> true;
        ensures !test.equals(passWord) ==> false;
    */
    public boolean testWord(String test) {
        if (test.equals(this.passWord)) {
            return true;
        } else {
            return false;
        }
    }

    /*@
        ensures testWord(oldpass) && acceptable(newpass) ==> true;
        ensures !testWord(oldpass) || !acceptable(newpass) ==> false;
    */
    public boolean setWord(String oldpass, String newpass) {
        if (testWord(oldpass) && acceptable(newpass)) {
            this.passWord = newpass;
            return true;
        } else {
            return false;
        }
    }

}