import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        // 5kg 봉지를 최대로 사용하면서 나머지를 3kg로 채울 수 있는지 확인
        while (N >= 0) {
            if (N % 5 == 0) { // 5로 나누어 떨어지면
                count += N / 5;
                System.out.println(count);
                return;
            }
            // 5kg 봉지 하나 줄이고 3kg로 채우기
            N -= 3;
            count++;
        }

        // 정확히 맞출 수 없는 경우
        System.out.println(-1);
    }
}
