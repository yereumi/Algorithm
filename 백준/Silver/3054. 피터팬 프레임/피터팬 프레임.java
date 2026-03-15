import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int width = 4 * n + 1;

        char[][] arr = new char[5][width];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            int pos = 2 + 4 * i;
            char frame = ((i + 1) % 3 == 0) ? '*' : '#';

            draw(arr, 0, pos, frame);
            draw(arr, 1, pos - 1, frame);
            draw(arr, 1, pos + 1, frame);
            draw(arr, 2, pos - 2, frame);
            draw(arr, 2, pos + 2, frame);
            draw(arr, 3, pos - 1, frame);
            draw(arr, 3, pos + 1, frame);
            draw(arr, 4, pos, frame);

            arr[2][pos] = s.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.print(sb);
    }

    static void draw(char[][] arr, int r, int c, char frame) {
        if (frame == '*') {
            arr[r][c] = '*'; // 웬디 프레임은 항상 덮어씀
        } else {
            if (arr[r][c] == '.') {
                arr[r][c] = '#'; // 피터팬은 빈칸일 때만
            }
        }
    }
}
