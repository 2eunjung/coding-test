import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 정수 N 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        int top = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int n : arr) {
            if (n > top){
                // 비교할 숫자가 스택 맨 위에 있는 숫자보다 크면 그만큼 1을 더하면서 스택에 담고, sb에 + 담기
                for (int i = top + 1; i <= n; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                // for문을 통해 다 담으면 맨 상단에 있는 값을 top에 담기
                top = n;
            // 만약 상단에 있는 값이 n이 아니라면 NO 출력
            } else if(stack.peek() != n){
                System.out.println("NO");
                return;
            }

            // 스택에서 해당 값을 pop 하면서 sb에 - 담기
            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }

}