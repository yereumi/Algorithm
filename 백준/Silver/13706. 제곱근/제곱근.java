import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger isqrt(BigInteger n) {
        if (n.signum() == 0) return BigInteger.ZERO;
        if (n.equals(BigInteger.ONE)) return BigInteger.ONE;

        BigInteger x = BigInteger.ONE.shiftLeft((n.bitLength() + 1) >>> 1);
        BigInteger y = x.add(n.divide(x)).shiftRight(1);

        while (y.compareTo(x) < 0) {
            x = y;
            y = x.add(n.divide(x)).shiftRight(1);
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine().trim());
        System.out.println(isqrt(N));
    }
}