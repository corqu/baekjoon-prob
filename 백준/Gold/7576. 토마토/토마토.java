import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] table = new int[N + 2][M + 2];

        Queue<int[]> queue = new LinkedList<>();

        int unripeCount = 0;

        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(table[i], -1);
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());

                if (table[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                } else if (table[i][j] == 0) {
                    unripeCount++;
                }
            }
        }

        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int days = current[2];

            maxDays = days;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (table[nr][nc] == 0) {
                    table[nr][nc] = 1;
                    unripeCount--;
                    queue.offer(new int[]{nr, nc, days + 1});
                }
            }
        }

        if (unripeCount > 0) {
            System.out.println(-1);
        } else {
            System.out.println(maxDays);
        }
    }
}