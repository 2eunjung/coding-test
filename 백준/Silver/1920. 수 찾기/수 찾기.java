import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] Narr = new int[N];
        for (int i = 0; i < N; i++) {
            Narr[i] = Integer.parseInt(st.nextToken());
        }
        // 이진 탐색을 위한 정렬
        Arrays.sort(Narr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            // 이진 탐색 : 존재하면 1, 존재하지 않으면 0
            if (Arrays.binarySearch(Narr, key) >= 0) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }
}