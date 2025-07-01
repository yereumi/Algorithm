import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = sc.nextInt();
        }

        Arrays.sort(cows);

        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {
            if (cows[left] + cows[right] <= s) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}