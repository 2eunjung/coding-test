import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 입력한 값 N만큼 큐에 담기
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        // 마지막 1개가 남을 때까지 반복하기
        while (queue.size() > 1) {
            // 맨 위에 있는 값 버리기
            queue.remove();

            // 그 다음 맨 위에 있는 값을 맨 뒤로 보내기
            Integer poll = queue.poll();
            if (poll != null){
                queue.offer(poll);
            }
        }
        System.out.println(queue.poll());
    }
}
