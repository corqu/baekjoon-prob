import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long l = sc.nextLong();
        long r = sc.nextLong();

        System.out.println(findNumbers(l, r));
    }


    private static int findNumbers(long l, long r) {
        char[] l1 = String.valueOf(l).toCharArray();
        char[] r1 = String.valueOf(r).toCharArray();
        int res = 0;

        if (l1.length != r1.length) {
            return res;
        } else {
            for (int i = 0; i < l1.length; i++) {
                if (l1[i] == r1[i]) {
                    if (l1[i] == '8') {
                        res++;
                    }
                } else {
                    break;
                }
            }
        }

        return res;
    }
}