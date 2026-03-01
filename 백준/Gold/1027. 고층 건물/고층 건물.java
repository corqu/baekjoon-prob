import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] height = new long[N];
            for (int i = 0; i < N; i++) {
                height[i] = Long.parseLong(st.nextToken());
            }

            int max = 0;

            if (N != 1){
                for (int i = 0; i < N; i++) {
                    int left = 0;
                    int right = 0;

                    if (i == 0) {
                        right = findRightViewBuildings(height, i);
                    } else if (i == N - 1) {
                        left = findLeftViewBuildings(height, i);
                    } else  {
                        right = findRightViewBuildings(height, i);
                        left = findLeftViewBuildings(height, i);
                    }

                    if (right + left > max) max = right + left;
                }
            }

            System.out.println(max);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int findRightViewBuildings(long[] height, int i) {
        int result = 0;
        double derive = -1_000_000_000.0;
        for (int j = i + 1; j < height.length; j++) {
            double newDerive = derive(height[i], height[j], j - i);
            if (newDerive > derive) {
                derive = newDerive;
                result++;
            }
        }

        return  result;
    }

    public static int findLeftViewBuildings(long[] height, int i) {
        int result = 0;
        double derive = 1_000_000_000.0;
        for (int j = i - 1; j >= 0; j--) {
            double newDerive = derive(height[i], height[j], j - i);
            if (newDerive < derive) {
                derive = newDerive;
                result++;
            }
        }

        return  result;
    }

    public static double derive(long a, long b, int delta) {
        return (double) (b - a) / delta;
    }
}