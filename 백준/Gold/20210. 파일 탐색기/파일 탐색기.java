import java.io.*;
import java.util.*;

public class Main {
	
	public static int compare(String a, String b) {
		List<String> list1 = split(a);
		List<String> list2 = split(b);
		
		int len = Math.min(list1.size(), list2.size());
		
		for (int i = 0; i < len; i++) {
			String x = list1.get(i);
			String y = list2.get(i);
			
			boolean isNumX = Character.isDigit(x.charAt(0));
            boolean isNumY = Character.isDigit(y.charAt(0));

            // 숫자 vs 문자
            if (isNumX && !isNumY) return -1;
            if (!isNumX && isNumY) return 1;

            // 숫자 vs 숫자
            if (isNumX) {
                int result = compareNumber(x, y);
                if (result != 0) return result;
            }
            // 문자 vs 문자
            else {
            	for (int j = 0; j < Math.min(x.length(), y.length()); j++) {
            		int result = compareChar(x.charAt(j), y.charAt(j));
                    if (result != 0) return result;
            	}
            	
            	if (x.length() != y.length()) return x.length() - y.length();
            }
        }

        return list1.size() - list2.size();
	}
	
	public static List<String> split(String str) {
		List<String> list = new ArrayList<>();		
		int i = 0;

	    while (i < str.length()) {
	        StringBuilder sb = new StringBuilder();

	        if (Character.isDigit(str.charAt(i))) {
	            while (i < str.length() && Character.isDigit(str.charAt(i))) {
	                sb.append(str.charAt(i));
	                i++;
	            }
	        } else {
	            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
	                sb.append(str.charAt(i));
	                i++;
	            }
	        }

	        list.add(sb.toString());
	    }

		
		return list;
	}
	
	static int compareNumber(String a, String b) {
        String x = removeZero(a);
        String y = removeZero(b);
        
        if (x.length() != y.length()) {
            return x.length() - y.length();
        }

        int cmp = x.compareTo(y);
        if (cmp != 0) return cmp;
        
        return a.length() - b.length();
    }

	static String removeZero(String s) {
	    int i = 0;
	    while (i < s.length() && s.charAt(i) == '0') i++;
	    return i == s.length() ? "0" : s.substring(i);
	}

    static int compareChar(char a, char b) {
        char la = Character.toLowerCase(a);
        char lb = Character.toLowerCase(b);

        if (la != lb) return la - lb;

        return a - b;
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, (o1, o2) -> compare(o1, o2));
		
		StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");    
        }
        
        System.out.println(sb.toString());
	}
}
