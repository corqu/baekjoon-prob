import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] interval =  new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            interval[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(countInterval(interval, targetNum));
    }

    public static int countInterval(int[] interval, int targetNum) {
        int res = 0;
        int minBorder = 0;
        int maxBorder = 1000;

        for (int i = 0; i < interval.length; i++) {
            if (interval[i] == targetNum) {
                return 0;
            }

            if (targetNum > interval[i] && (targetNum - minBorder) > (targetNum - interval[i])){
                minBorder = interval[i];
            }
            if (interval[i] > targetNum && (maxBorder - targetNum) > (interval[i] - targetNum)){
                maxBorder = interval[i];
            }
        }
        res = (targetNum - minBorder) * (maxBorder - targetNum) - 1;

        return res;
    }
}
