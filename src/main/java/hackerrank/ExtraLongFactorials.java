package hackerrank;

import java.math.BigInteger;
import java.util.Arrays;

public class ExtraLongFactorials {

    public static void main(String[] args) {
        extraLongFactorials(25);
    }

    public static void extraLongFactorials(int n) {
        BigInteger multiply = BigInteger.ONE;
        while(n >= 1) {
            multiply = multiply.multiply(BigInteger.valueOf(n));
            n--;
        }

        System.out.println(multiply);
    }

}
