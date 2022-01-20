package ss.week3.password;

public class Password {

    private String passWord;
    private Checker checker;
    private String initPass;
//    public static final String INITIAL = "InitialPassword";

    /*@
        requires INITIAL != null;
    */
    public Password() {
        this(new BasicChecker());
    }

    public Password(Checker checker) {
        this.checker = checker;
//        this.initPass = INITIAL;
//        this.passWord = INITIAL;
        this.initPass = checker.generatePassword();
        this.passWord = checker.generatePassword();
    }

    public String getInitPass() {
        return this.initPass;
    }

    public Checker getChecker() {
        return this.checker;
    }

    /*@
        requires suggestion instanceof String;
        ensures suggestion.length() < 6 || suggestion.matches(" ") ==> false;
        ensures suggestion.length() >= 6 && !suggestion.matches(" ") ==> true;
    */
    public boolean acceptable(String suggestion) {
//        if (suggestion.length() >= 6 && !suggestion.contains(" ")) {
//            return true;
//        } else {
//            return false;
//        }
        return checker.acceptable(suggestion);
    }

    /*@
        ensures test.equals(passWord) ==> true;
        ensures !test.equals(passWord) ==> false;
    */
    public boolean testWord(String test) {
        return test.equals(this.passWord);
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