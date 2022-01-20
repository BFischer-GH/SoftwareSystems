package ss.week5.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

import java.util.Arrays;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";

        System.out.println("The given example of String to Hex, assignment 5.7");
        System.out.println(Hex.encodeHexString(input.getBytes()));

        System.out.println("Requested assignment 5.8:");
        String given = "4d6f64756c652032";
        System.out.println(StringUtils.newStringUsAscii(Hex.decodeHex(given.toCharArray()))); // Hoe moet je dit even uitvinden?


        System.out.println("Take Hello World into Base64, assignment 5.9-1:");
        String input3 = "Hello World";
        System.out.println(Base64.encodeBase64(input3.getBytes()));

        System.out.println("5.9-2 Hex string to byte array to base64");
        String input4 = "010203040506";
        byte[] solution4;
        solution4 = Hex.decodeHex(input4);
        String newinp = Base64.encodeBase64String(solution4);
        System.out.println("Input: " +input4 +" Hex to byte array: " + solution4 +" and check " + newinp);

        System.out.println("5.9.3 Decode given Base64 U29mdHdhcmUgU3lzdGVtcw==");
        byte[] newest = Base64.decodeBase64("U29mdHdhcmUgU3lzdGVtcw==");
        System.out.println(StringUtils.newStringUsAscii(newest));


        System.out.println("5.9.4 The aaaaaaaaaaaallerlaatste opdracht:");

        for (int i = 0; i <= 10; i++) {
            byte[] arrayA = new byte[i];
            Arrays.fill(arrayA, (byte)'a');
            String aNum = Base64.encodeBase64String(arrayA); // I was returning the byte not the string.
            System.out.println(aNum); // Dit is de correcte methode, gechecked met online tool dat er een reperterende eenheid in zit.
        }

    }

}
