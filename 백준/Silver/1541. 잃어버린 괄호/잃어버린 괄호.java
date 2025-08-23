import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 덧셈을 먼저 다 더한 후, 빼면 최솟값이 나옴
        // 그래서 입력값을 먼저 -로 구분함
        String[] st = br.readLine().split("-");

        // - 기준으로 다 나누었으니 첫 그룹 집합은 다 더한 값을 result를 선언하면서 같이 값을 담음
        int result = sum(st[0]);

        for (int i = 1; i < st.length; i++) {
            // 첫 그룹 집합외의 값은 다 빼기
            result -= sum(st[i]);
        }

        System.out.println(result);
    }

    private static int sum(String s) {
        String[] st = s.split("\\+");
        int sum = 0;
        for(String num : st) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}