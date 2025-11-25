import java.util.*;

class Solution {
    
    static int n;
    static List<List<String>> candidates;
    static Map<String, Boolean> map;
    static Set<String> set;
    
    static public void dfs(int depth, String str) {
        if (depth == n) {
            String[] arr = str.split("-");
            Arrays.sort(arr);
            String tmp = "";
            for (String s : arr) {
                tmp = tmp + "-" + s;
            }
            
            set.add(tmp);
            
            return;
        }
        
        for (String c : candidates.get(depth)) {
            if (!map.get(c)) {
                map.put(c, true);
                dfs(depth + 1, str + "-" + c);
                map.put(c, false);
            }
        }
    }
    
    static public int solution(String[] user_id, String[] banned_id) {
        n = banned_id.length;
        set = new HashSet<>();
        map = new HashMap<>();
        for (String user : user_id) {
            map.put(user, false);
        }
        
        candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candidates.add(new ArrayList<>());
        }
        
        for (int b = 0; b < n; b++) {            
            String banned = banned_id[b];
            
            for (String user : user_id) {
                if (user.length() != banned.length()) continue;
                
                boolean flag = true;
                for (int i = 0; i < user.length(); i++) {
                    if (banned.charAt(i) == '*') continue;
                    if (banned.charAt(i) != user.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    candidates.get(b).add(user);
                }
            }
        }
        
        dfs(0, "");
        
        return set.size();
    }
}