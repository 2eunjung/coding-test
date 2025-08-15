import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            // for문을 돌면서 배열에 나무의 높이를 저장하면서 가장 높은 나무의 높이를 max에 저장
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        while (min < max) {
            // mid = 절단기 높이
            int mid = (min + max) / 2;
            long sum = 0;

            for (int tree : arr){
                /*
                    각 나무의 길이에서 가장 긴 나무의 중간값 길이를 나눈 값을 빼서
                    가져갈 수 있는 나무의 길이를 다 더하는 식으로
                    최대값을 구해야되기 때문에 나무길이를 중간값을 뺀 값이 0 이상이어야 함
                    => 절단기 높이보다 나무가 더 길면 잘린 부분의 길이를 합산
                 */
                if (tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            // 자른 나무길이의 합이 M보다 작으면 높이를 낮춰줘야 함
            if (sum < M) {
                max = mid;
            // 자른 나무길이의 합이 M보다 크면 높이를 높여줘야 함
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}