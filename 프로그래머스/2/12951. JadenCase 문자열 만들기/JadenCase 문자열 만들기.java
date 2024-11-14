class Solution {
    public String solution(String s) {
        String answer = "";
	        int i = 0;
	        if (s.isBlank()) {
	            return s;
	        }
	        while (i < s.length()) {
	        	if (s.charAt(i) == ' ') {
	        		answer += s.charAt(i);
	        		i++;
	        	} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
	        		answer += s.charAt(i);
	        		i++;
	        		while (i < s.length() && s.charAt(i) != ' ') {
	        			answer += Character.toLowerCase(s.charAt(i));
	        			i++;
	        		}
	        	} else {
	        		if (i ==0 || s.charAt(i - 1) == ' ') {
	        			answer += Character.toUpperCase(s.charAt(i));
	        			i++;
	        		}
	        		while (i < s.length() && s.charAt(i) != ' ') {
	        			answer += Character.toLowerCase(s.charAt(i));
	        			i++;
	        		}
	        	}
	        }
	        return answer;
    }
}