import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[][] map = new int[x][y];

            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                map[x1][y1] = 1;
            }
            int count = 0;
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if (map[j][k] == 1) {
                        count++;
                        deleteLettuce(j, k, map);
                    }
                }
            }
            System.out.println(count);

        }
    }

    public static void deleteLettuce(int x, int y, int[][] map) {
        map[x][y] = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int M = map.length;
        int N = map[0].length;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (map[cx][cy] == 1) {
                    map[cx][cy] = 0;
                    deleteLettuce(cx, cy, map);
                }
            }
        }
    }
}