import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 1_000_000_007;
	static int[] nums;
	static long[] tree;
	
	static void init(int node, int nodeLeft, int nodeRight) {
		if (nodeLeft == nodeRight) {
			tree[node] = nums[nodeLeft];
			return;
		}
		
		int mid = (nodeLeft + nodeRight) / 2;
		
		init(node * 2, nodeLeft, mid);
		init(node * 2 + 1, mid + 1, nodeRight);
		
		tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
	}
	
	static void update(int node, int nodeLeft, int nodeRight, int updateIdx, int value) {
		if (nodeRight < updateIdx || updateIdx < nodeLeft) return;
		
		if (nodeLeft == nodeRight) {
			tree[node] = value;
			return;
		}
		
		int mid = (nodeLeft + nodeRight) / 2;
		
		update(node * 2, nodeLeft, mid, updateIdx, value);
		update(node * 2 + 1, mid + 1, nodeRight, updateIdx, value);
		
		tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
	}
	
	static long multiply(int node, int nodeLeft, int nodeRight, int resLeft, int resRight) {
		if (nodeRight < resLeft || resRight < nodeLeft) return 1;
		if (resLeft <= nodeLeft && nodeRight <= resRight) {
			return tree[node];
		}
		
		int mid = (nodeLeft + nodeRight) / 2;

		long leftResult = multiply(node * 2, nodeLeft, mid, resLeft, resRight);
		long rightResult = multiply(node * 2 + 1, mid + 1, nodeRight, resLeft, resRight);
		
		return leftResult * rightResult % MOD;
	}
		
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        tree = new long[N * 4];
        
        for (int i = 1; i <= N; i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        }
        
        init(1, 1, N);
        
        for (int i = 0; i < M + K; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	if (a == 1) {
        		update(1, 1, N, b, c);
        	} else {
        		sb.append(multiply(1, 1, N, b, c)).append("\n");
        	}
        }
        
        System.out.println(sb.toString());
    }
}
