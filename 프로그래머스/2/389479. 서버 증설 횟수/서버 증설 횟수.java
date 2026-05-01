class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = players.length;
        int[] servers = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int p = players[i];
            int s = p / m;

            if (servers[i] >= s) continue;
            
            s -= servers[i];
            answer += s;
            
            for (int j = i; j < i + k; j++) {
                if (j > n) break;
                servers[j] += s;
            }
        }
        
        return answer;
    }
}