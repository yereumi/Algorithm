import java.io.*;
import java.util.*;

public class Main {
    static String[] code = {
        "000000", "001111", "010011", "011100",
        "100110", "101001", "110101", "111010"
    };
    static char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine().trim();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String part = s.substring(i * 6, (i + 1) * 6);
            char decoded = decode(part);
            if (decoded == '?') {
                System.out.println(i + 1);
                return;
            }
            result.append(decoded);
        }

        System.out.println(result);
    }

    static char decode(String str) {
        for (int i = 0; i < 8; i++) {
            if (distance(str, code[i]) <= 1)
                return letter[i];
        }
        return '?';
    }

    static int distance(String a, String b) {
        int diff = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }
}
