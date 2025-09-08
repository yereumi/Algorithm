import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPack = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            minPack = Math.min(minPack, p);
            minSingle = Math.min(minSingle, s);
        }

        int costAllSingles = N * minSingle;
        int packsOnly = ((N + 5) / 6) * minPack;
        int packs = (N / 6) * minPack + (N % 6) * minSingle;
        int ans = Math.min(costAllSingles, Math.min(packsOnly, packs));
        System.out.println(ans);
    }
}