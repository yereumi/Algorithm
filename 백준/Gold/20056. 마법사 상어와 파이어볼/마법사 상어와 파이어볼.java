import java.io.*;
import java.util.*;

public class Main {
	
	static class Fireball {
		int r;
		int c;
		int m;
		int d;
		int s;
		
		Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int N, M, K;
	static List<Fireball> fireball;
	static Map<Integer, List<Fireball>> result;
	static int[][] delta = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	
	static void simulation() {
		result = new HashMap<>();
		for (Fireball f : fireball) {
			move(f.r, f.c, f.m, f.s, f.d);
		}
		
		fireball = new ArrayList<>();
		merge();
	}
	
	static void move(int r, int c, int m, int s, int d) {
		int[] del = delta[d];
		int nr = r + del[0] * (s % N);
		int nc = c + del[1] * (s % N);
		
		if (nr > N) nr -= N;
		if (nr < 1) nr += N;
		if (nc > N) nc -= N;
		if (nc < 1) nc += N;
		
		int key = (nr - 1) * N + nc - 1;
		result.computeIfAbsent(key, k -> new ArrayList<>())
	      .add(new Fireball(nr, nc, m, s, d));
	}
	
	static void merge() {
		for (Map.Entry<Integer, List<Fireball>> entry : result.entrySet()) {
			int key = entry.getKey();
			List<Fireball> value = entry.getValue();
			
			if (value.size() == 1) {
			    fireball.add(value.get(0));
			    continue;
			}
			
			int r = key / N + 1;
			int c = key % N + 1;
			
			int nextM = 0;
			int nextS = 0;
			int even = 0;
			int odd = 0;
			boolean nextD = true;
			
			for (Fireball f : value) {
				nextM += f.m;
				nextS += f.s;
				if (f.d % 2 == 0) even++;
				else odd++;
			}
			
			nextM /= 5;
			
			if (nextM == 0) continue;
			
			nextS /= value.size();
			if (even != 0 && odd != 0) nextD = false;
			
			if (nextD) {
				for (int i = 0; i < 8; i += 2) {
					fireball.add(new Fireball(r, c, nextM, nextS, i));
				}
			} else {
				for (int i = 1; i < 8; i += 2) {
					fireball.add(new Fireball(r, c, nextM, nextS, i));
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        fireball = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	fireball.add(new Fireball(r, c, m, s, d));
        }
        
        for (int i = 0; i < K; i++) {
        	simulation();
        }
        
        int answer = 0;
        for (Fireball f : fireball) {
        	answer += f.m;
        }
        
        System.out.println(answer);
    }
}
