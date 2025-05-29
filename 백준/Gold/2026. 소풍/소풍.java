import java.util.*;
import java.io.*;

public class Main {
	
	static int k, n, f;
	static boolean found;
	static List<Set<Integer>> friend;
	static int[] list;
	
	static void backtracking(int depth, int num) {
		
		if (found) return;
		if (depth == k) {
			StringBuilder sb = new StringBuilder();
			for (int i : list) sb.append(i).append("\n");
			System.out.println(sb);
			found = true;
			return;
		}
		
		for (int i = num; i <= n; i++) {
			
			if (friend.get(i).size() < k - 1) continue;
			
			boolean flag = true;
			for (int j = 0; j < depth; j++) {
				if (!friend.get(list[j]).contains(i)) flag = false;
			}
			
			if (flag) {
				list[depth] = i;
				backtracking(depth + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		friend = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			friend.add(new HashSet<>());
		}
		for (int i = 0; i < f; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend.get(a).add(b);
			friend.get(b).add(a);
		}
		list = new int[k];
		backtracking(0, 1);
		if (!found) System.out.println(-1);
	}
}