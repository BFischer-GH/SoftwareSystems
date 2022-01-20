package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 *
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) throws IOException {
		passwordMap = new HashMap<>(); // create a first HashMap to be used

		String line;
		BufferedReader bufRead = new BufferedReader(new FileReader(filename));
		while ((line = bufRead.readLine() )!= null){
			String[] split = line.split(": ", 2);
			if( split.length == 2){
				String userName = split[0];
				String passWord = split[1];
				passwordMap.put(userName,passWord);
			} else {
				System.out.println("This does not compute"+line);
			}
		}
		bufRead.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
        try{ // Put within Try to allow errors to slip with catch
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Create byte array to digested MD-5 password
            byte[] array = md.digest(password.getBytes());

            // convert the resulting byte-array to a Hex-encoded string, baeldung.com
            BigInteger bitInt = new BigInteger(1, array);
            // convert message digest array into hex string hash
            String hashText = bitInt.toString(16);

            return hashText;

        } catch (NoSuchAlgorithmException e) {}

        return null;
    }
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
         String passwordHash = getPasswordHash(password); //Transform the given password into the Hashed version
         String key = this.passwordMap.get(user); //Obtains the hex password related to the specified user

		return (passwordHash.equals(key)); //compares them and returns true or false
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) throws IOException {
         BufferedReader bufRead = new BufferedReader(new FileReader(filename)); //Reads a dictionary from file (one line per word)
         hashDictionary = new HashMap<>(); // Creates a new HashMap to store all

         String line;
         String hashline;
         while((line = bufRead.readLine()) != null){
             hashline = getPasswordHash(line);
             hashDictionary.put(line, hashline);
         }
    }

	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() throws IOException {
		// To implement
		addToHashDictionary("./src/ss/week6/dictionaryattack/commonbig.txt"); // this will give hashDictionary map
		readPasswords("./src/ss/week6/dictionaryattack/leakeddata.txt");// this will give passwordMap map

		// From the maps get the keylist

		List<String> passKeyList = new ArrayList<>(passwordMap.keySet());
		List<String> hashKeyList = new ArrayList<>(hashDictionary.keySet());
		int laber =1;
		for	(int userNameInt = 0; userNameInt < passKeyList.size(); userNameInt++){
			for( int passWordInt = 0; passWordInt < hashKeyList.size(); passWordInt++){
				if (checkPassword(passKeyList.get(userNameInt), hashKeyList.get(passWordInt))) {
					// The above is the crusial
					System.out.println(laber+ "; User: " + passKeyList.get(userNameInt) + "; password: " + hashKeyList.get(passWordInt));
					laber++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
