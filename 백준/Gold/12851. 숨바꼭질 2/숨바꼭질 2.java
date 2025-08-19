import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
        int max = 200_000;
        int[] time = new int[max + 1];
        int[] cnt = new int[max + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();
        time[n] = 0;
        cnt[n] = 1;
        dq.offer(n);

        int answerDist = -1;
        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (answerDist != -1 && time[now] > answerDist) break;

            int[] nexts = {now - 1, now + 1, now * 2};
            for (int nx : nexts) {
                if (nx < 0 || nx > max) continue;

                if (time[nx] == Integer.MAX_VALUE) {
                	time[nx] = time[now] + 1;
                	cnt[nx] = cnt[now];
                    dq.offer(nx);
                } else if (time[nx] == time[now] + 1) {
                	cnt[nx] += cnt[now];
                }
            }
            
            if (now == k) answerDist = time[now];
        }

        System.out.println(time[k] + "\n" + cnt[k]);
    }
}