import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 1_000_000;
	static int[] candy;
	static int[] tree;
	
	static int find(int rank, int node, int start, int end) {
	    if (start == end) {
	        return start;
	    }

	    int mid = (start + end) / 2;

	    if (tree[node * 2] >= rank) {
	        return find(rank, node * 2, start, mid);
	    } else {
	        return find(rank - tree[node * 2], node * 2 + 1, mid + 1, end);
	    }
	}
	
	static void update(int node, int nodeLeft, int nodeRight, int taste, int count) {
		if (nodeRight < taste || taste < nodeLeft) return;
		
		tree[node] += count;
		
		if (nodeLeft != nodeRight) {
	        int mid = (nodeLeft + nodeRight) / 2;
	        update(node * 2, nodeLeft, mid, taste, count);
	        update(node * 2 + 1, mid + 1, nodeRight, taste, count);
	    }
	}
	
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        candy = new int[MAX + 1];
        tree = new int[MAX * 4];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	if (A == 1) {
        		int B = Integer.parseInt(st.nextToken());
        		int result = find(B, 1, 1, MAX);
        		sb.append(result).append("\n");
        		update(1, 1, MAX, result, -1);
        	} else {
        		int B = Integer.parseInt(st.nextToken());
        		int C = Integer.parseInt(st.nextToken());
        		candy[B] += C;
        		update(1, 1, MAX, B, C);
        	}
        }
        
        System.out.println(sb.toString());
    }
}
