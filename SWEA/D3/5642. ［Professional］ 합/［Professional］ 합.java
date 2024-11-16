import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int T, num, max_sum, result;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			num = sc.nextInt();
			int[] arr = new int[num];
			int[] arr_sum = new int[num+1];
			for (int i = 0; i < num; i++) {
				arr[i] = sc.nextInt();
			}
			max_sum = arr[0];
			result = max_sum;
			for (int i = 0; i < num - 1; i++) {
				max_sum = Math.max(max_sum + arr[i + 1], arr[i + 1]);
				result = Math.max(result, max_sum);
			}
			System.out.println("#" + test_case + " " + result);
        }
	}
}
