import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 문제에서 N이 40보다 작거나 같은 정수라고 해서 0부터 40까지 저장하기 위해 그보다 하나 더 큰 41로 선언
        // 0과 1 각 2개의 횟수를 구해야되니 2차원 배열로 선언
        // arr[n][0] : 0의 횟수 / arr[n][1] : 1의 횟수
        int[][] arr = new int[41][2];

        // 0이 1번 출력
        arr[0][0] = 1;
        arr[0][1] = 0;

        // 1이 1번 출력
        arr[1][0] = 0;
        arr[1][1] = 1;

        // 위에서 0과 1에 해당하는 값을 직접 구했으므로 2부터 최대값 40까지 해당하는 값을 미리 구하기
        for (int i = 2; i < 41; i++) {
            // 0이 몇개인지 출력하기 위해 n-1에서의 0 갯수와 n-2에서의 0 갯수 구하기
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            // 1이 몇개인지 출력하기 위해 n-1에서의 0 갯수와 n-2에서의 1 갯수 구하기
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }

        // T는 테스트 케이스 수이므로 그만큼 입력을 반복해서 받아야하기 때문에 for문을 통해 테스트 케이스 수만큼 반복
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N][0] + " " + arr[N][1]);
        }
    }
}