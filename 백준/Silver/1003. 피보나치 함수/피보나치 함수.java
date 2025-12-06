import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                System.out.println("1 0");
            } else {
                System.out.println(fibonacci(num -1) + " " + fibonacci(num));
            }
        }
    }
    // 결국 0과 1의 개수도 피보나치 수열을 따라감
    // 1은 n+1번째 피보나치, 0은 n번째 피보나치
    // 재귀 형태는 메모리 부족으로 인해 피보나치 일반항으로 대체 -> 행변환시 오차 발생
    // 리스트로 꺼내쓰기
    public static int fibonacci(int i) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int j = 2; j <= 40; j++) {
            list.add(list.get(j-1) + list.get(j-2));
        }
        return list.get(i);
    }
}