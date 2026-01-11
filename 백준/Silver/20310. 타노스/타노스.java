import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	int len = s.length();
    	int zero = 0;
    	int one = 0;
    	
    	for (int i = 0; i < len; i++) {
    		if (s.charAt(i) == '0') zero++;
    		else one++;
    	}
    	
    	zero /= 2;
    	one /= 2;
    	
    	List<Integer> list = new ArrayList<>();
    	int cnt = 0;
    	for (int i = 0; i < len; i++) {
    		if (cnt == one) break;
    		if (s.charAt(i) == '1') {
    			cnt++;
    			list.add(i);
    		}
    	}
    	
    	cnt = 0;
    	for (int i = len - 1; i >= 0; i--) {
    		if (cnt == zero) break;
    		if (s.charAt(i) == '0') {
    			cnt++;
    			list.add(i);
    		}
    	}
    	
    	Collections.sort(list);

    	String newS = "";
    	int idx = 0;
    	for (int i = 0; i < len; i++) {
    		if (idx == list.size()) {
    			newS += s.charAt(i);
    			continue;
    		}
    		
    		if (list.get(idx) == i) {
    			idx++;
    			continue;
    		}
    		
    		newS += s.charAt(i);
    	}
    	
    	System.out.println(newS);
    }
}
