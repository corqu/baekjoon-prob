import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long min = Long.parseLong(st.nextToken());
            long max = Long.parseLong(st.nextToken());

            boolean[] check = new boolean[(int) (max - min + 1)];

            int i = 2;
            int maxSqrt = (int) Math.sqrt(max);
            while (i <= maxSqrt) {
                check = markMultiples(check, i, min);
                i++;
            }

            int result = 0;

            for (boolean b : check) {
                if (!b) {
                    result++;
                }
            }

            bw.write(result + "");
            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean[] markMultiples(boolean[] check, long base, long min) {
        long start = min / (base * base);

        long startNode = start * (base * base) - min;
        if (startNode < 0) {
            startNode += base * base;
        }

        while (startNode < check.length) {
            check[(int) startNode] = true;
            startNode += base * base;
        }

        return check;
    }
}
