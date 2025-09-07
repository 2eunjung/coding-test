import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값을 대문자만 받기 때문에 trim()으로 좌우 공백을 제거해도 무방
        String s = br.readLine().trim();

        // 영문 대문자는 총 26개이기 때문에 그만큼 선언
        int[] cnt = new int[26];
        /*
            for문을 돌면서 해당 영문 대문자의 갯수 구하기
                AABC -> A 2개, B 1개, C 1개, 나머지 알파벳은 0개
         */
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        /*
            홀수 갯수 판독하기
            * oddIndex를 -1로 초기화하는 이유
                : 팬린드롬 규칙상 홀수 갯수인 문자는 최대 1개만 허용됨
                  입력 문자열마다 홀수 문자가 항상 존재하는 것이 아님
                  하여 "아직 홀수 문자를 발견하지 못했다"라는 특수한 상태값을 나타내기 위해 -1로 초기값으로 둠
         */
        int oddCnt = 0;
        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                oddCnt++;
                oddIndex = i; // 마지막으로 발견된 홀수 문자 인덱스를 저장하여 이후 중앙에 값을 지정할 예정
            }
        }

        // 팬린드롬 규칙상 홀수 갯수가 2개 이상이면, 충족할 수 없으니 불가능 판정
        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int leftCnt = cnt[i] / 2;               // 왼쪽에 들어갈 문자 갯수 구하기
            for (int j = 0; j < leftCnt; j++) {
                /*
                    for (int i=0; i<26; i++)가 알파벳 순으로 돌고 있어서
                    자연스럽게 사전 순으로 정렬되어 있기 때문에 해당 값을 문자로 다시 바꿔서 왼쪽 값을 채움
                 */
                left.append((char) ('A' + i));
            }
        }

        // 왼쪽 + (중앙값) + 오른쪽(뒤집은 왼쪽)을 순차적으로 합치기
        StringBuilder result = new StringBuilder();
        // 출력값에 먼저 구한 왼쪽 값 추가하기
        result.append(left);
        // 중앙 문자가 있다면, 해당 문자를 추가하기
        if (oddCnt == 1) {
            result.append((char) ('A' + oddIndex));
        }
        // 왼쪽 문자열을 뒤집은 것을 붙여 오른쪽 부분 완성
        result.append(left.reverse());

        System.out.println(result.toString());
    }
}