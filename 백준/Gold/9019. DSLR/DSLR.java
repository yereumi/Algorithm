import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 10000;
	static boolean[] visited;
	
	static String bfs(String before, String after) {
		Deque<String[]> dq = new ArrayDeque<>();
		dq.offer(new String[] { before, "" });
		visited = new boolean[MAX];
		visited[Integer.parseInt(before)] = true;
		
		while (!dq.isEmpty()) {
			String[] now = dq.poll();
			
			int nowNum = Integer.parseInt(now[0]);
			String nowState = now[1];
			String nowNumStr = String.valueOf(nowNum);
			while (nowNumStr.length() != 4) nowNumStr = "0" + nowNumStr;
			
			if (nowNumStr.equals(after)) return nowState;
			
			int d = operation_d(nowNum);
			int s = operation_s(nowNum);
			int l = operation_l(nowNum);
			int r = operation_r(nowNum);
			
			if (!visited[d]) {
				String D = String.valueOf(d);
				while (D.length() != 4) D = "0" + D;
				dq.offer(new String[] { D, nowState + "D" });
				visited[d] = true;
			}
			if (!visited[s]) {
				String S = String.valueOf(s);
				while (S.length() != 4) S = "0" + S;
				dq.offer(new String[] { S, nowState + "S" });
				visited[s] = true;
			}
			if (!visited[l]) {
				String L = String.valueOf(l);
				while (L.length() != 4) L = "0" + L;
				dq.offer(new String[] { L, nowState + "L" });
				visited[l] = true;
			}
			if (!visited[r]) {
				String R = String.valueOf(r);
				while (R.length() != 4) R = "0" + R;
				dq.offer(new String[] { R, nowState + "R" });
				visited[r] = true;
			}
		}
		return "";
	}
	
	static int operation_d(int num) {
		return (num * 2) % MAX;
	}
	
	static int operation_s(int num) {
		num -= 1;
		if (num == -1) return 9999;
		return num;
	}
	
	static int operation_l(int num) {
		int first = num / 1000;
		return num % 1000 * 10 + first;
	}
	
	static int operation_r(int num) {
		int last = num % 10;
		return num / 10 + last * 1000;
	}
	
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	
    	while (n-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		String a = st.nextToken();
    		String b = st.nextToken();
    		
    		while (a.length() != 4) a = "0" + a;
    		while (b.length() != 4) b = "0" + b;
    		
    		sb.append(bfs(a, b)).append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
}
