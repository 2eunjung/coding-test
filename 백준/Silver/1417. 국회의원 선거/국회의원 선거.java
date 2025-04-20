import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        int count = 0;

        int[] others = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            others[i] = Integer.parseInt(br.readLine());
        }

        while (true){
            int maxIndex = 0;
            int maxVote = 0;

            // 현재 가장 표가 많은 후보 찾기
            for (int i = 0; i < others.length; i++) {
                if (others[i] > maxVote) {
                    maxVote = others[i];
                    maxIndex = i;
                }
            }

            // 다솜이가 1등이면 종료
            if (dasom > maxVote) {
                break;
            }

            // 1등 아니면 표뺏기
            others[maxIndex] -= 1;
            dasom += 1;
            count++;
        }
        System.out.println(count);
    }
}
