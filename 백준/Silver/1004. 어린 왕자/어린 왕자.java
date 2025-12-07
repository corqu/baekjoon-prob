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
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                int c1 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if (countInOut(x1, y1, x2, y2, c1, c2, r)) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    public static boolean countInOut(int x1, int y1, int x2, int y2, int c1, int c2, int r) {
        boolean flag = false;
        boolean start = false;
        boolean end = false;
        // 출발점 인아웃 확인
        if (powDistance(x1, y1, c1, c2) < r * r) {
            start = true;
        }
        //도착점 인아웃 확인
        if (powDistance(x2, y2, c1, c2) < r * r) {
            end = true;
        }

        if (start != end) {
            flag = true;
        }
        return flag;
    }

    public static int powDistance(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }
}