class Solution {
        
    public void dfs(int v, boolean[] visited, int n, int[][] computers) {
        visited[v] = true;
        for (int i = 0; i < n; i++) {
            if (i == v) continue;
            if (computers[v][i] == 1 && !visited[i]) {
                dfs(i, visited, n, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, n, computers);
                cnt++;
            } 
        }
        return cnt;
    }
}