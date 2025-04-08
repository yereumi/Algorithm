/**
 * 시간 2초: 2억번 안에 연산
 * 최대 메모리 512MB: int 기준 대략 512 * 1000 * 1000 / 4 = 128_000_000개 할당 가능
 */
import java.util.*;
import java.io.*;

public class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int max = 200_000;
        int[] time = new int[max + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();
        time[n] = 0;
        dq.offer(n);

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now * 2 <= max && time[now * 2] > time[now]) {
                time[now * 2] = time[now];
                dq.addFirst(now * 2);
            }
            if (now + 1 <= max && time[now + 1] > time[now] + 1) {
                time[now + 1] = time[now] + 1;
                dq.addLast(now + 1);
            }
            if (now - 1 >= 0 && time[now - 1] > time[now] + 1) {
                time[now - 1] = time[now] + 1;
                dq.addLast(now - 1);
            }
        }

        System.out.println(time[k]);
    }
}