import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();
        int i = 0;
        boolean ok = true;

        while (i < n) {
            if (i + 1 < n && s.charAt(i) == 'p' && s.charAt(i + 1) == 'i') {
                i += 2;
            }
            else if (i + 1 < n && s.charAt(i) == 'k' && s.charAt(i + 1) == 'a') {
                i += 2;
            }
            else if (i + 2 < n && s.charAt(i) == 'c' && s.charAt(i + 1) == 'h' && s.charAt(i + 2) == 'u') {
                i += 3;
            }
            else {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "YES" : "NO");
    }
}