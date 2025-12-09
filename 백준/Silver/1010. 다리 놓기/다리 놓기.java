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
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println(combination(l, r));
        }
    }

    public static long combination(int a, int b){
        long p = 1;
        long q = 1;
        if (a > b / 2) {
            a = b - a;
        }
        for (int i = 0; i < a; i++) {
            p *= b - i;
            q *= i + 1;
        }
        return p / q;
    }
}
