import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
        
		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int answer = 1;
            for (int i = 0; i < m; i++) {
                answer *= n;
            }
            System.out.println("#" + num + " " + answer);
        }
	}
}