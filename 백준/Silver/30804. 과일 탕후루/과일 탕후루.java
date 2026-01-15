import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] fruits = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		fruits[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] cnt = new int[10];
        int kind = 0;
        int l = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (cnt[fruits[i]] == 0) kind++;
            cnt[fruits[i]]++;

            while (kind > 2) {
                cnt[fruits[l]]--;
                if (cnt[fruits[l]] == 0) kind--;
                l++;
            }

            answer = Math.max(answer, i - l + 1);
        }

        System.out.println(answer);
    }
}
