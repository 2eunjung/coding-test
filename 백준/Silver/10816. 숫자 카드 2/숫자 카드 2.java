import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] Narr = br.readLine().split(" ");

        Map<Integer, Integer> map = new HashMap<>();

        for (String n : Narr) {
            int num = Integer.parseInt(n);
            map.put(num, map.getOrDefault(num, 0) + 1);
            /*
                map.getOrDefault(key, defaultValue)
                - Map에서 key가 존재하면 그 값을 반환, 없으면 defaultValue 반환
                map.getOrDefault(num, 0) + 1
                - 해시맵에 값이 존재하든 말든 무조건 카운트를 1씩 증가시키는 패턴
                   ex) num    10
                            map.getOrDefault(10, 0) + 1
                            기존값  없음 => 0 + 1 = 1 => map에 10, 1 저장
                       num    10
                            map.getOrdefault(10, 0) + 1
                            기존값  1   => 1 + 1 = 2 => map에 10, 2 저장
             */
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
        }


        int M = Integer.parseInt(br.readLine());
        String[] Marr = br.readLine().split(" ");

        for (String v : Marr) {
            int value = Integer.parseInt(v);
            System.out.print(map.getOrDefault(value, 0) + " ");
        }
    }
}