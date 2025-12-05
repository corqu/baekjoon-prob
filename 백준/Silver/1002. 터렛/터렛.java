import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 좌표 구분
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distPow =  (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
            int rSumPow = (r1 + r2) * (r1 + r2);
            int rDiffPow = (r1 - r2) * (r1 - r2);

            // 두 원이 완전히 겹침
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } // 두 원이 안만남
            else if (distPow > rSumPow || distPow < rDiffPow) {
                System.out.println(0);
            } // 외접할 때 or 내접할 때
            else if (distPow == rSumPow || distPow == rDiffPow) {
                System.out.println(1);
            } // 그 외
            else {
                System.out.println(2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}