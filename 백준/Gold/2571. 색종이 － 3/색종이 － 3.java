import java.io.*;
import java.util.*;

public class Main {

    static int largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = h.length;

        for (int i = 0; i <= n; i++) {
            int cur = (i == n ? 0 : h[i]);
            while (!stack.isEmpty() && cur < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[100][100];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int x = a; x < a + 10; x++) {
                for (int y = b; y < b + 10; y++) {
                    board[x][y] = true;
                }
            }
        }

        int[][] height = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (!board[i][j]) height[i][j] = 0;
                else height[i][j] = (i == 0 ? 1 : height[i - 1][j] + 1);
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            answer = Math.max(answer, largestRectangle(height[i]));
        }

        System.out.println(answer);
    }
}
