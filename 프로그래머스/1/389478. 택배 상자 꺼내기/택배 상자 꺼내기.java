class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n / w;
        if (n % w != 0) h++;
        int[][] boxes = new int[h][w];
        
        int i = 1;
        while (i <= n) {
            int j = 0;
            while (j < w && i <= n) {
                int nh = (i - 1) / w;
                boxes[nh][j] = i;
                j++;
                i++;
            }
            j = w - 1;
            while (j >= 0 && i <= n) {
                int nh = (i - 1) / w;
                boxes[nh][j] = i;
                j--;
                i++;
            }
        }
        
        int bh = 0, bw = 0;
        for (i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(boxes[i][j] + " ");
                if (boxes[i][j] == num) {
                    bh = i;
                    bw = j;
                }
            }
            System.out.println();
        }
        
        System.out.println(bh + " " + bw);
        for (i = bh; i < h; i++) {
            if (boxes[i][bw] == 0) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}