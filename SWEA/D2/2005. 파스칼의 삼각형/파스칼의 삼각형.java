import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int T, num;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			num = sc.nextInt();
			System.out.println("#" + test_case);
			System.out.println(1);
			for (int i = 1; i < num; i++) {
				System.out.print(1 + " ");
				for (int j = 1; j < i; j++) {
					System.out.print(i + " ");
				}
				System.out.println(1);
			}
		}
	}
}
