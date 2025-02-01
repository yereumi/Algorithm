import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        int left = 0;
        int right = n - 1;
        int minLeft = 0;
        int minRight = n - 1;

        int minAbsoluteSum;
        if (arr[left] + arr[right] < 0) {
            minAbsoluteSum = - (arr[left] + arr[right]);
        } else {
            minAbsoluteSum = arr[left] + arr[right];
        }

        while (left < right) {
            if (arr[left] + arr[right] < 0) {
                if (-(arr[left] + arr[right]) < minAbsoluteSum) {
                    minAbsoluteSum = -(arr[left] + arr[right]);
                    minLeft = left;
                    minRight = right;
                }
                left++;
            } else {
                if ((arr[left] + arr[right]) < minAbsoluteSum) {
                    minAbsoluteSum = arr[left] + arr[right];
                    minLeft = left;
                    minRight = right;
                }
                right--;
            }
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}