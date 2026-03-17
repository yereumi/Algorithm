import java.io.*;
import java.util.*;

public class Main {

	static long[] nums;
	static long[] tree;
	
	static void init(int node, int nodeLeft, int nodeRight) {
		if (nodeLeft == nodeRight) {
			tree[node] = nums[nodeLeft];
			return;
		}
		
		int mid = (nodeLeft + nodeRight) / 2;
		
		init(node * 2, nodeLeft, mid);
		init(node * 2 + 1, mid + 1, nodeRight);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	static void update(int node, int nodeLeft, int nodeRight, long updateIdx, long value) {
		if (nodeRight < updateIdx || updateIdx < nodeLeft) return;
		
		if (nodeLeft == nodeRight) {
			tree[node] = value;
			return;
		}
		
		int mid = (nodeLeft + nodeRight) / 2;
		
		update(node * 2, nodeLeft, mid, updateIdx, value);
		update(node * 2 + 1, mid + 1, nodeRight, updateIdx, value);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	static long sum(int node, int nodeLeft, int nodeRight, long resLeft, long resRight) {
		if (nodeRight < resLeft || resRight < nodeLeft) return 0;
		if (resLeft <= nodeLeft && nodeRight <= resRight) {
			return tree[node];
		}
		
		int mid = (nodeLeft + nodeRight) / 2;

		long leftResult = sum(node * 2, nodeLeft, mid, resLeft, resRight);
		long rightResult = sum(node * 2 + 1, mid + 1, nodeRight, resLeft, resRight);
		
		return leftResult + rightResult;
	}
		
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nums = new long[N + 1];
        tree = new long[N * 4];
        
        for (int i = 1; i <= N; i++) {
        	nums[i] = Long.parseLong(br.readLine());
        }
        
        init(1, 1, N);
        
        for (int i = 0; i < M + K; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	long b = Long.parseLong(st.nextToken());
        	long c = Long.parseLong(st.nextToken());
        	
        	if (a == 1) {
        		update(1, 1, N, b, c);
        	} else {
        		sb.append(sum(1, 1, N, b, c)).append("\n");
        	}
        }
        
        System.out.println(sb.toString());
    }
}
