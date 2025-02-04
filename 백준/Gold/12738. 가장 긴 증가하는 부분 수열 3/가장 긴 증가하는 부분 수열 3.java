import java.util.*;
import java.io.*;

public class Main {	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	int idx = Collections.binarySearch(list, arr[i]);
        	if (idx < 0) idx = Math.abs(idx) - 1;
        	if (list.isEmpty() || list.get(list.size() - 1) < arr[i]) list.add(arr[i]);
        	else {
        		list.set(idx, arr[i]);
        	}
        }
        System.out.println(list.size());
    }
}
