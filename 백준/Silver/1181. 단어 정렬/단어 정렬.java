import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 중복 제거
        Set<String> arr = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr.add(s);
        }

        // 중복 제거한 값을 list에 옮겨 담음
        List<String> list = new ArrayList<>(arr);
        // 중복 제거한 값을 단어의 길이 순으로 재배열 후, 길이가 같으면 알파벳 순으로 정렬하기
        list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        for (String s : list) {
            System.out.println(s);
        }
    }
}
