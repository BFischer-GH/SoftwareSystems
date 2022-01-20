package ss.week1.EXTRA;

import ss.utils.TextIO;

public class NameAnalysis {


    public static void main(String[] args) {
    String input;
    String firstName;
    String lastName;

    System.out.println("Please enter first name and last name separated by a space:");
    input = TextIO.getlnString();
    String[] inputSplit = input.split(" ");
    firstName = inputSplit[0];
    lastName = inputSplit[1];

    System.out.println("First name is "+ firstName+", which has "+firstName.length()+" characters.");
    System.out.println("Last name is "+ lastName+", which has "+lastName.length()+" characters.");
    System.out.println("Thus the initials are "+ firstName.charAt(0) +lastName.charAt(0));
    }
}
/*
System.out.printf( "Your first name is %s, which has %d characters.%n",
                                   firstName, firstName.length() );
System.out.printf( "Your last name is %s, which has %d characters.%n",
                                   lastName, lastName.length() );
System.out.printf( "Your initials are %s%s%n",
                                   firstName.charAt(0), lastName.charAt(0) );
 */
