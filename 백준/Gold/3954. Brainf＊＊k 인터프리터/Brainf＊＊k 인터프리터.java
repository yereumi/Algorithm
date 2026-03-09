import java.util.*;
import java.io.*;

public class Main {
	
	static final int MOD = 256;
    static final int LIMIT = 50_000_000;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[m];
			String code = br.readLine();
			String input = br.readLine();

			int pointer = 0;
            int pc = 0;
			int inputIdx = 0;
			
			int executed = 0;
            int maxPc = 0;

            // 괄호 매칭
            int[] pair = new int[c];
            Stack<Integer> stack = new Stack<>();

            for (int k = 0; k < c; k++) {
                char ch = code.charAt(k);

                if (ch == '[') {
                    stack.push(k);
                } else if (ch == ']') {
                    int open = stack.pop();
                    pair[open] = k;
                    pair[k] = open;
                }
            }

            // 인터프리터 실행
            while (pc < c && executed <= LIMIT * 2) {
            	if (executed >= LIMIT) {
                    maxPc = Math.max(maxPc, pc);
                }
            	
                char cmd = code.charAt(pc);

                switch (cmd) {
                    case '+':
                        arr[pointer] = (arr[pointer] + 1) % MOD;
                        break;

                    case '-':
                    	arr[pointer] = (arr[pointer] + 255) % MOD;
                        break;

                    case '>':
                        pointer = (pointer + 1) % m;
                        break;

                    case '<':
                        pointer = (pointer - 1 + m) % m;
                        break;

                    case '[':
                        if (arr[pointer] == 0) {
                            pc = pair[pc];
                        }
                        break;

                    case ']':
                        if (arr[pointer] != 0) {
                            pc = pair[pc];
                        }
                        break;

                    case ',':
                        if (inputIdx < input.length()) {
                        	arr[pointer] = input.charAt(inputIdx++);
                        } else {
                        	arr[pointer] = 255;
                        }
                        break;

                    case '.':
                        break;
                }

                executed++;
                pc++;
            }

            if (pc >= c) {
                System.out.println("Terminates");
            } else {
                int l = pair[maxPc];
                int r = maxPc;

                if (l > r) {
                    int temp = l;
                    l = r;
                    r = temp;
                }

                System.out.println("Loops " + l + " " + r);
            }
        }
    }
}
