import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sum = 0;
        boolean hasZero = false;
        char[] arr = s.toCharArray();

        for (char c : arr) {
            int num = c - '0';
            sum += num;
            if (num == 0) hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr));
        System.out.println(sb.reverse());
    }
}
