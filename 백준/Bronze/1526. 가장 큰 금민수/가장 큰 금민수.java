import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans = 0;

    static void dfs(long num) {
        if (num > N) return;
        if (num != 0) ans = Math.max(ans, (int) num);

        dfs(num * 10 + 4);
        dfs(num * 10 + 7);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        dfs(0);
        System.out.println(ans);
    }
}