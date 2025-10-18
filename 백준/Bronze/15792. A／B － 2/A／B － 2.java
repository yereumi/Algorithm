import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        
        BigDecimal A = new BigDecimal(s[0]);
        BigDecimal B = new BigDecimal(s[1]);
        
        BigDecimal result = A.divide(B, 1001, RoundingMode.DOWN);
        
        String str = result.stripTrailingZeros().toPlainString();
        
        System.out.println(str);
    }
}