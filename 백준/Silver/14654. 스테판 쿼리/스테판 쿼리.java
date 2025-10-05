import java.io.*;
import java.util.*;

public class Main {

    static boolean win(int a, int b) {
        return (a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] teamA = new int[N];
        int[] teamB = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) teamA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) teamB[i] = Integer.parseInt(st.nextToken());
        
        int maxWin = 0;
        int curWin = 0;
        int currentWinner = 0;
        
        for (int i = 0; i < N; i++) {
            int a = teamA[i];
            int b = teamB[i];
            
            int winner = 0;
            if (a == b) {
                winner = (currentWinner == 1) ? 2 : 1;
            } else if (win(a, b)) {
                winner = 1;
            } else {
                winner = 2;
            }
            
            if (winner == currentWinner) {
                curWin++;
            } else {
                currentWinner = winner;
                curWin = 1;
            }
            maxWin = Math.max(maxWin, curWin);
        }
        
        System.out.println(maxWin);
    }
}