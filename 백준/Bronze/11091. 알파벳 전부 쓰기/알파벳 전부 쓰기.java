import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < N; tc++) {
            String s = br.readLine();
            boolean[] seen = new boolean[26];

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if ('A' <= ch && ch <= 'Z') ch = (char)(ch - 'A' + 'a');
                if ('a' <= ch && ch <= 'z') seen[ch - 'a'] = true;
            }

            boolean pangram = true;
            for (boolean b : seen) if (!b) { pangram = false; break; }

            if (pangram) {
                out.append("pangram\n");
            } else {
                out.append("missing ");
                for (int i = 0; i < 26; i++) if (!seen[i]) out.append((char)('a' + i));
                out.append('\n');
            }
        }

        System.out.print(out.toString());
    }
}