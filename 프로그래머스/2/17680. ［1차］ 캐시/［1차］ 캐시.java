import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;

        Set<String> inCache = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>(cacheSize);
        int time = 0;

        for (String raw : cities) {
            String city = raw.toLowerCase();

            if (inCache.contains(city)) {
                time += 1;
                dq.remove(city);
                dq.offer(city);
            } else {
                time += 5;
                if (dq.size() == cacheSize) {
                    String old = dq.poll();
                    inCache.remove(old);
                }
                dq.offer(city);
                inCache.add(city);
            }
        }
        return time;
    }
}