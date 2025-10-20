import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] bulbs = br.readLine().trim().toCharArray();
        int n = bulbs.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (bulbs[i] == 'Y') {
                cnt++;
                for (int j = i; j < n; j += (i + 1)) {
                    bulbs[j] = (bulbs[j] == 'Y') ? 'N' : 'Y';
                }
            }
        }

        for (char c : bulbs) {
            if (c == 'Y') {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(cnt);
    }
}