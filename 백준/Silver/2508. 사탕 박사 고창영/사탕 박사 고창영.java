import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            // 공백 줄 읽어주기
            /*
                테스트케이스마다 맨 처음에 "빈 줄 하나"를 스킵해줘야 합니다. 
                이게 빠지면 입력 줄이 하나 밀려서 NoSuchElementException이 나는 거예요.
             */
            br.readLine();
            
            // 행열의 갯수 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 이중 배열 입력받기
            char[][] candy = new char[r][c];
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    candy[i][j] = line.charAt(j);
                }
            }

            int result = 0;

            // 가로로 찾기
            for (int i = 0; i < r; i++) {
                for (int j = 2; j < c; j++) {
                    if (candy[i][j] != '<') continue;
                    if (candy[i][j - 2] == '>' && candy[i][j - 1] == 'o') {
                        result++;
                    }
                }
            }

            // 세로로 찾기
            for (int i = 2; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (candy[i][j] != '^') continue;
                    if (candy[i - 2][j] == 'v' && candy[i - 1][j] == 'o') {
                        result++;
                    }
                }
            }

            sb.append(result).append('\n'); // 여러 케이스 저장
        }

        System.out.print(sb); // 최종 결과 한 번에 출력
    }
}
