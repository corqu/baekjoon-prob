import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        List<Long> list = Arrays.stream(bans).map(s -> {
            char[] chars = s.toCharArray();
            long index = 0;
            for (int i = 0; i < chars.length; i++) {
                long cIndex = (long) chars[i] - 96;
                cIndex *= Math.pow(26, chars.length - i - 1);
                index += cIndex;
            }
            return index;
        }).sorted().collect(Collectors.toList());

        for (Long i : list) {
            if (i <= n) {
                n++;
            } else  {
                break;
            }
        }
        
        while (n > 0) {
            n--;
            answer += (char) ((n % 26) + 'a');
            n /= 26;
        }
        
        StringBuilder sb = new StringBuilder(answer);
        answer = sb.reverse().toString();

        return answer;
    }
}