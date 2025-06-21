import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 값이 0이 될 때까지 반복
        while(true) {
            String input = br.readLine();

            // 종료 조건
            if (input.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean isTrue = true;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    // 스택이 비어있거나 스택의 가장 위에 있는 게 '('이 아니면 "no" 출력
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isTrue = false;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isTrue = false;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (isTrue && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}