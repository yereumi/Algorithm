import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int count = 0;

        for (int c = (N + 2) / 3; c <= (N - 1) / 2; c++) {
            int sum = N - c; // a + b
            int minA = Math.max(1, sum - c);   // b ≤ c 조건 → a ≥ sum - c
            int maxA = Math.min(sum / 2, c);   // a ≤ b, b = sum - a ≥ a
            if (minA <= maxA) {
                count += (maxA - minA + 1);
            }
        }

        System.out.println(count);
    }
}