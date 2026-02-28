import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    // 모서리가 총 4개
    // 선이 총 N-2 * 4 + N-1 * 4
    // 면이 총 N-2 * N-2 * 1 + N-2 * N-1 * 4
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            long N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dice = new int[6];
            for (int i = 0; i < 6; i++) {
                dice[i] = Integer.parseInt(st.nextToken());
            }

            int[] minValue = {min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])};
            int[] useValue = Arrays.stream(minValue).sorted().toArray();

            long result = 0;

            switch ((int)N) {
                case 1:
                    int max = dice[0];
                    for (int i = 0; i < 6; i++) {
                        result += dice[i];

                        if (dice[i] > max) {
                            max = dice[i];
                        }
                    }
                    result -= max;
                    break;

                case 2:
                    result =  useValue[0] * 8L + useValue[1] * 8L + useValue[2] * 4L;
                    break;

                default:
                    long top = totalTop(N);
                    long line = totalLine(N);
                    long point = 4;

                    result = useValue[0] * (top + line + point) + useValue[1] * (point + line) + useValue[2] * point;
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long totalLine(long N) {
        return (N - 2) * 4 + (N - 1) * 4;
    }

    private static long totalTop(long N) {
        return (N - 2) * (N - 2) + (N - 2) * (N - 1) * 4;
    }
}