import java.io.*;
import java.util.*;

public class Main {

	static int N, M, answer;
	static int[][] board;
	static List<int[]> cctv = new ArrayList<>();
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	static void simulation(int idx, char[][] state) {
        if (idx >= cctv.size()) {
            answer = Math.min(answer, countZero(state));
            return;
        }

        int r = cctv.get(idx)[0];
        int c = cctv.get(idx)[1];
        int type = board[r][c];

        if (type == 1) {
            for (int d = 0; d < 4; d++) {
                List<int[]> changed = watch(r, c, state, new int[]{d});
                simulation(idx + 1, state);
                rollback(state, changed);
            }
        } else if (type == 2) {
            for (int d = 0; d < 2; d++) {
                List<int[]> changed = watch(r, c, state, new int[]{d, (d+2)%4});
                simulation(idx + 1, state);
                rollback(state, changed);
            }
        } else if (type == 3) {
            for (int d = 0; d < 4; d++) {
                List<int[]> changed = watch(r, c, state, new int[]{d, (d+1)%4});
                simulation(idx + 1, state);
                rollback(state, changed);
            }
        } else if (type == 4) {
            for (int d = 0; d < 4; d++) {
                List<int[]> changed = watch(r, c, state, new int[]{d, (d+1)%4, (d+2)%4});
                simulation(idx + 1, state);
                rollback(state, changed);
            }
        } else if (type == 5) {
            List<int[]> changed = watch(r, c, state, new int[]{0,1,2,3});
            simulation(idx + 1, state);
            rollback(state, changed);
        }
    }

	static List<int[]> watch(int r, int c, char[][] state, int[] dirs) {
		List<int[]> changed = new ArrayList<>();

		for (int d : dirs) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			while (isValid(nr, nc) && state[nr][nc] != '6') {
				if (state[nr][nc] == '0') {
					state[nr][nc] = '#';
					changed.add(new int[] { nr, nc });
				}

				nr += delta[d][0];
				nc += delta[d][1];
			}
		}
		return changed;
	}

	static void rollback(char[][] state, List<int[]> changed) {
		for (int[] pos : changed) {
			state[pos[0]][pos[1]] = '0';
		}
	}

	static int countZero(char[][] state) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (state[i][j] == '0')
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		char[][] state = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				state[i][j] = (char) (board[i][j] + '0');

				if (board[i][j] >= 1 && board[i][j] <= 5) {
					cctv.add(new int[] { i, j });
				}
			}
		}

		answer = Integer.MAX_VALUE;
		simulation(0, state);

		System.out.println(answer);
	}
}
