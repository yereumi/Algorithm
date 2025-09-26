import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        
        // 약관 유효기간 map에 저장
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            String type = st.nextToken();
            String period = st.nextToken();
            
            termMap.put(type, Integer.parseInt(period));
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i <= privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i - 1]);
            String[] date = st.nextToken().split("\\.");
            
            String type = st.nextToken();
            int period = termMap.get(type);
            
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]) + period;
            int day = Integer.parseInt(date[2]) - 1;
            int dateTotal = year * 12 * 28 + month * 28 + day;
            
            String[] todayDate = today.split("\\.");
            int todayY = Integer.parseInt(todayDate[0]);
            int todayM = Integer.parseInt(todayDate[1]);
            int todayD = Integer.parseInt(todayDate[2]);
            
            int todayTotal = todayY * 12 * 28 + todayM * 28 + todayD;
            
            if (dateTotal < todayTotal) answer.add(i);
        }
        
        Collections.sort(answer);
        return answer;
    }
}