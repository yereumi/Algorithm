import java.util.*;
import java.io.*;

public class Main {
	
	public static int l, c;
	public static List<String> list;
	public static String[] array;
	public static StringBuilder sb = new StringBuilder();
	
	public static boolean isVowel(String s) {
		return (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"));
	}
	
	public static void recursive(int depth, int idx, int vowelCnt, int consonantCnt) {
		if (depth == l) {
			if (vowelCnt < 1 || consonantCnt < 2) return;
			for (int i = 0; i < l; i++) {
				sb.append(array[i]);
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i < c; i++) {
			String str = list.get(i);
			array[depth] = str;
			if (isVowel(str)) 
				recursive(depth + 1, i + 1, vowelCnt + 1, consonantCnt);
			else
				recursive(depth + 1, i + 1, vowelCnt, consonantCnt + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			list.add(st.nextToken());
		}
		list.sort((o1, o2) -> o1.compareTo(o2)); // 리스트 정렬
		array = new String[l];
		recursive(0, 0, 0, 0);
		System.out.println(sb);
	}
}
