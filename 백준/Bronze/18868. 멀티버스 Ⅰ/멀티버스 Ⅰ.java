import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            Map<Integer, Integer> rank = new HashMap<>();
            int r = 0;
            for (int v : sorted) {
                if (!rank.containsKey(v)) {
                    rank.put(v, r++);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int v : arr) {
                sb.append(rank.get(v)).append(',');
            }

            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long answer = 0;
        for (int c : map.values()) {
            if (c >= 2) {
                answer += (long)c * (c - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
