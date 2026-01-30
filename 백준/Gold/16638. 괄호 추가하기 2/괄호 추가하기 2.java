import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String expr;
    static long answer = Long.MIN_VALUE;

    static void dfs(int idx, String cur, boolean prevBracket) {
        if (idx >= N) {
            answer = Math.max(answer, evaluate(cur));
            return;
        }

        char c = expr.charAt(idx);
        if (Character.isDigit(c)) {
            dfs(idx + 1, cur + c, false);
            return;
        }

        dfs(idx + 1, cur + c, false);

        if (!prevBracket && idx + 1 < N) {
            char left = cur.charAt(cur.length() - 1);
            char right = expr.charAt(idx + 1);

            String next = cur.substring(0, cur.length() - 1)
            		+ "(" + left + c + right + ")";

            dfs(idx + 2, next, true);
        }
    }

    static long evaluate(String s) {
        Stack<Long> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                nums.push((long)(c - '0'));
            } else if (c == '(') {
                long a = s.charAt(i + 1) - '0';
                char op = s.charAt(i + 2);
                long b = s.charAt(i + 3) - '0';

                nums.push(calc(a, b, op));
                i += 4;
            } else {
                ops.push(c);
            }
        }

        Stack<Long> nums2 = new Stack<>();
        Stack<Character> ops2 = new Stack<>();

        nums2.push(nums.get(0));
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            long b = nums.get(i + 1);

            if (op == '*') {
                nums2.push(nums2.pop() * b);
            } else {
                ops2.push(op);
                nums2.push(b);
            }
        }

        long res = nums2.get(0);
        for (int i = 0; i < ops2.size(); i++) {
            res = calc(res, nums2.get(i + 1), ops2.get(i));
        }
        return res;
    }

    static long calc(long a, long b, char o) {
        if (o == '+') return a + b;
        if (o == '-') return a - b;
        return a * b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expr = br.readLine();

        dfs(0, "", false);
        System.out.println(answer);
        br.close();
    }
}
