import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String T = br.readLine().trim();

        int left = 0;
        int right = N - 1;
        long query = 0;

        while (left < right) {
            char a = T.charAt(left);
            char b = T.charAt(right);

            if (a != '?' && b != '?') {
                if (a != b) {
                    System.out.println(0);
                    return;
                }
            } else if (a == '?' && b == '?') {
                query += 26;
            } else {
                query += 1;
            }
            left++;
            right--;
        }

        System.out.println(query);
    }
}