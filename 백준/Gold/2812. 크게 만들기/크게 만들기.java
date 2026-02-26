import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(str.charAt(0) - '0');
        int cnt = 0;
        for (int i = 1; i < N; i++) {
        	int cur = str.charAt(i) - '0';
        	
        	if (cur > dq.peek()) {
        		while (!dq.isEmpty() && dq.peek() < cur && cnt < K) {
        			dq.pop();
        			cnt++;
        		}
        	}
        	dq.push(cur);
        }
        
        while (dq.size() > N - K) {
        	dq.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
        	sb.insert(0, dq.pop());
        }
        System.out.println(sb.toString());
    }
}
