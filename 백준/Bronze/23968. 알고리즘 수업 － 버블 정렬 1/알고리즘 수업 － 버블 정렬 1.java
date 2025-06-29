import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;

        for (int last = n - 1; last >= 1; last--) {
            for (int i = 0; i < last; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    count++;

                    if (count == k) {
                        int min = Math.min(a[i], a[i + 1]);
                        int max = Math.max(a[i], a[i + 1]);
                        System.out.println(min + " " + max);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}