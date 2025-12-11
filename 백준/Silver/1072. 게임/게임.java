import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long totalGames = Long.parseLong(st.nextToken());
        long win =  Long.parseLong(st.nextToken());
        System.out.println(changeRatio(win, totalGames));
    }



    public static long changeRatio(long winGames, long totalGames){
        int initialRatio = calRatio(winGames, totalGames);

        if (initialRatio >= 99) {
            return -1;
        }
        long nextRatio = initialRatio + 1;
        
        long numerator = (nextRatio * totalGames) - (100 * winGames);

        long denominator = 100 - nextRatio;
        
        long result = (numerator + denominator - 1) / denominator;

        return result;
    }

    public static int calRatio (long winGames, long totalGames){
        return (int) ((winGames * 100) / totalGames );
    }
}