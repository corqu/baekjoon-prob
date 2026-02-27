import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int[][] timetable = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                timetable[i][0] = Integer.parseInt(st.nextToken());
                timetable[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(timetable, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            int count = 0;
            int endTime = 0;

            for (int i = 0; i < N; i++) {
                if (timetable[i][0] >= endTime) {
                    endTime = timetable[i][1];
                    count++;
                }
            }

            bw.write(count + "");
            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}