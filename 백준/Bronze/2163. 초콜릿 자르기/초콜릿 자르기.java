import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (1 <= n && 1 <= m && n <= 300 && m <= 300){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 수학적 귀납적 관찰
            /*
                초콜릿을 쪼갤 때마다 조각이 1개씩 늘어남
                -----------------------------------
                쪼개기 횟수                  조각수
                -----------------------------------
                0번                          1개
                1번                          2개
                2번                          3개
                ...                         ...
                10번                         11개
                
                이를 통해, 조각 수 = 쪼개기 횟수 + 1 이라는 규칙을 알 수 있음
             */
            
            int result = n * m - 1;
            bw.write(result + "");
            bw.close();
        }
    }
}