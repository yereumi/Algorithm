import java.util.*;

class Solution {
    
    static int n, m;
    static int[][] users_;
    static int[] emoticons_;
    static int maxNum, maxSales;
    static int[] discounts = new int[] { 10, 20, 30, 40 };

    static void dfs(int depth, int[] rates) {
        if (depth == m) {
            simulate(rates);
            return;
        }
        for (int d : discounts) {
            rates[depth] = d;
            dfs(depth + 1, rates);
        }
    }

    static void simulate(int[] rates) {
        int num = 0, sales = 0;
        
        for (int [] user : users_) {
            int minRate = user[0];
            int limit = user[1];
            int total = 0;
            
            for (int i = 0; i < m; i++) {
                if (rates[i] >= minRate) {
                    total += emoticons_[i] * (100 - rates[i]) / 100;
                }
            }
            
            if (total >= limit) num++;
            else sales += total;
        }
        
        if (num > maxNum || (num == maxNum && sales > maxSales)) {
            maxNum = num;
            maxSales = sales;
        }
    }
    
    public static int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        users_ = users;
        emoticons_ = emoticons;
        maxNum = 0;
        maxSales = 0;
        
        dfs(0, new int[m]);
        
        return new int[] { maxNum, maxSales };
    }
}