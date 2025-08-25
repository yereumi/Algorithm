import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder out = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int g = n / 5; // number of "++++" groups
            int r = n % 5; // remaining '|'

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < g; i++) {
                sb.append("++++");
                if (i < g - 1 || r > 0) sb.append(' ');
            }
            for (int i = 0; i < r; i++) sb.append('|');

            out.append(sb).append('\n');
        }
        System.out.print(out.toString());
    }
}