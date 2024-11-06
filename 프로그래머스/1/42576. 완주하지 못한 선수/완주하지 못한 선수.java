import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantList = new HashMap<String, Integer>();
        List<String> completionList = new ArrayList<>();
        
        String answer = "";
        for (String person : participant) {
        	int personNum = 0;
        	if (participantList.containsKey(person)) {
        		personNum = participantList.get(person);
        	}
        	participantList.put(person, personNum + 1);
        }
        
        for (String person : completion) {
        	participantList.replace(person, participantList.get(person) - 1);
        }
        
        for (Map.Entry<String, Integer> entry : participantList.entrySet()) {
        	String person = entry.getKey();
        	if (entry.getValue() != 0) {
        		answer = person;
        	}
        }
        return answer;
    }
}