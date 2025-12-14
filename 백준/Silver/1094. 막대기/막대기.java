import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int count = 0;

    public static void countX(int x) {
        if (x % 2 == 1) {
            count++;
        }

        if (x > 1) {
            countX(x / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        countX(x);
        System.out.println(count);
    }
}
