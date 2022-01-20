package ss.week3.password;

public interface Checker {

    /*@
       requires passWord != null;
    */
    boolean acceptable(String passWord);

    /*@
        ensures acceptable(\result);
    */
    String generatePassword();

}