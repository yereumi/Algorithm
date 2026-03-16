import java.io.*;

public class Main {

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();
        String answer = null;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = reverse(s.substring(0, i));
                String b = reverse(s.substring(i, j));
                String c = reverse(s.substring(j));

                String candidate = a + b + c;

                if (answer == null || candidate.compareTo(answer) < 0) {
                    answer = candidate;
                }
            }
        }

        System.out.println(answer);
    }
}
