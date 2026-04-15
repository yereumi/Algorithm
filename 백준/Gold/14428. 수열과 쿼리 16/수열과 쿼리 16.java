import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        long value;
        int idx;

        Node(long value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    static int N;
    static long[] nums;
    static Node[] tree;

    static Node merge(Node a, Node b) {
        if (a.value < b.value) return a;
        if (a.value > b.value) return b;
        return a.idx < b.idx ? a : b;
    }

    static void init(int node, int left, int right) {
        if (left == right) {
            tree[node] = new Node(nums[left], left);
            return;
        }

        int mid = (left + right) / 2;
        init(node * 2, left, mid);
        init(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static void update(int node, int left, int right, int idx, long value) {
        if (idx < left || right < idx) return;

        if (left == right) {
            tree[node] = new Node(value, idx);
            return;
        }

        int mid = (left + right) / 2;
        update(node * 2, left, mid, idx, value);
        update(node * 2 + 1, mid + 1, right, idx, value);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static Node query(int node, int left, int right, int l, int r) {
        if (r < left || right < l) {
            return new Node(Long.MAX_VALUE, Integer.MAX_VALUE);
        }

        if (l <= left && right <= r) {
            return tree[node];
        }

        int mid = (left + right) / 2;
        Node a = query(node * 2, left, mid, l, r);
        Node b = query(node * 2 + 1, mid + 1, right, l, r);

        return merge(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new long[N + 1];
        tree = new Node[4 * N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        init(1, 1, N);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long v = Long.parseLong(st.nextToken());
                update(1, 1, N, idx, v);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, l, r).idx).append("\n");
            }
        }

        System.out.println(sb);
    }
}