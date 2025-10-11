import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        // 우선순위 큐 : 최소 힙(작은 수가 위로 올라옴)
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);

                // 만약 힙의 크기가 N개를 초과하면, 가장 작은 값을 제거
                // for문을 통해 값을 담으면서 제일 큰 값 N개만 queue에 남기는 과정
                if (queue.size() > N) {
                    queue.poll();
                }
            }
        }

        // 남은 queue에서 가장 작은 값을 poll로 꺼냄
        System.out.println(queue.poll());
    }
}