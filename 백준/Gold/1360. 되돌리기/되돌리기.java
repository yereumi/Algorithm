import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] time = new long[n + 1];
		String[] text = new String[n + 1];
		text[0] = "";   // 초기 상태
		time[0] = -1;
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			if (func.equals("type")) {
				String ab = st.nextToken();
				int nowTime = Integer.parseInt(st.nextToken());
				time[i] = nowTime;
				text[i] = text[i - 1] + ab;
			} else {
				int t = Integer.parseInt(st.nextToken());
				int nowTime = Integer.parseInt(st.nextToken());
				
				int idx = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (time[j] < nowTime - t) {
						idx = j;
                        break;
                    }
                }
				text[i] = text[idx];
                time[i] = nowTime;
			}
		}
        System.out.println(text[n] == null ? "" : text[n]);
	}
}