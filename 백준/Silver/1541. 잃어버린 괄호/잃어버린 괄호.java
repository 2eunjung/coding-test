import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        /*
            입력값에 대한 조건을 정규식으로 해석
                [0-9+-]+
                    0부터 9까지의 숫자와 +기호, -기호를 정규식에서 허용한다는 의미
                \\d+([+-]\\d+)*
                    \\d         -> 하나 이상의 숫자로 맨 앞에 숫자가 와야함(기호 불가)
                    ([+-]\\d+)* -> +숫자 혹은 -숫자가 0번 이상 반복됨

         */
        if (st.matches("\\d+([+-]\\d+)*")){
            // 입력값에 +나 -를 기준으로 숫자를 나눠서 배열에 담기
            // split을 사용하면 기호가 버려지기 때문에 compile 사용
            Pattern p = Pattern.compile("\\d+|[+-]");
            Matcher m = p.matcher(st);

            ArrayList<String> list = new ArrayList<>();

            while (m.find()) {
                list.add(m.group());
            }

            int result = 0;
            boolean flag = false;

            for (int i = 0; i < list.size(); i++) {
                String token = list.get(i);

                if (token.equals("-")){
                    flag = true;
                } else if (token.equals("+")){
                    continue;
                } else {
                    int num = Integer.parseInt(token);
                    if (flag){
                        result -= num;
                    } else {
                        result += num;
                    }
                }
            }
            System.out.println(result);
        }
    }
}