import java.io.*;
import java.util.*;

public class Main {

    static class Condo {
        int d, c, id;
        boolean badNear = false;
        boolean badCheap = false;
        Condo(int d, int c, int id){
            this.d = d;
            this.c = c;
            this.id = id;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Condo[] arr = new Condo[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Condo(d,c,i);
        }

        Arrays.sort(arr, (a,b) -> a.d - b.d);
        int minCost = Integer.MAX_VALUE;
        for (Condo x : arr) {
            if (x.c >= minCost) x.badNear = true;
            minCost = Math.min(minCost, x.c);
        }

        Arrays.sort(arr, (a,b) -> a.c - b.c);
        int minDist = Integer.MAX_VALUE;
        for (Condo x : arr) {
            if (x.d >= minDist) x.badCheap = true;
            minDist = Math.min(minDist, x.d);
        }

        int count = 0;
        for (Condo x : arr) {
            if (!x.badNear && !x.badCheap)
                count++;
        }

        System.out.println(count);
    }
}
