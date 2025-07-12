import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
            2 * 1
            2*1타일 하나의 타일로 채울 수 있음
         */
        int a = 1;
        /*
            2 * 2
            2*1 - 2개 / 1*2 - 2개 / 2*2 - 1개
            총 3개의 방법으로 타일을 채울 수 있음
         */
        int b = 3;
        int result = N == 1 ? a : b;

        // N이 1과 2였을 때의 값을 구해서 3부터 시작 => 3 이상인 경우 for문을 돌면서 값 도출
        for (int i = 3; i <= N; i++) {
            /*
                점화식 코드
                dp[n] = dp[n -1] + 2 * dp[n-2]
             */
            result = (b + 2 * a) % 10007;
            a = b;
            b = result;
        }
        System.out.println(result);
    }
}
