import java.io.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;

        // 해당하는 값들을 set에 담음 -> 중복되지 않는 고유의 값들이라서 set을 사용함
        Set<String> alphabet = Set.of("dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=", "e", "a", "k");

        int i = 0;
        // input에 해당하는 길이만큼 돌면서 크로아티아 알파벳 갯수 찾음
        while(i < input.length()) {
            boolean matched = false;

            for (String s : alphabet) {
                /*
                    i + s.length() <= input.length()
                    : 검사할 문자열 범위가 input 안에 있는지 확인하는 조건
                        ex) input = "abc"
                            i = 2, s.length() = 2
                                i + s.length() = 4
                                input.length() = 3
                                4 <= 3 -> 거짓
                            즉, substring을 안전하게 호출하기 위한 오류 방지용
                 */
                /*
                    input.substring(i, i + s.length()).equals(s)
                    : 패턴 매칭을 하는 조건
                      => 현재 위치(i)부터, 패턴(s)의 길이만큼 잘라서 문자열(alpabet)과 일치하는지 비교
                      * substring(beginIndex, endIndex)
                        ex) i = 0, s.length() = 3
                            현재 위치 0부터 3만큼 잘라서 "dz="와 문자열이 일치하는지 비교
                 */
                if (i + s.length() <= input.length() && input.substring(i, i + s.length()).equals(s)) {
                    count++;
                    i += s.length();
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                count++;
                i++;
            }
        }

        System.out.println(count);
    }
}
