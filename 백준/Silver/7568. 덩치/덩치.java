import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // 값이 중복되더라도 순서를 유지하며 접근하기 위해 List 사용
        List<Arr> list = new ArrayList<>();
        int[] rank = new int[num];

        if (2 <= num && num <= 50){
            for (int i = 0; i < num; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int weight = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                list.add(new Arr(weight, height));
                rank[i] = 1;
            }

            for (int i = 0; i < num; i++){
                for (int j = 0; j < num; j++){
                    if (list.get(i).getX() < list.get(j).getX() && list.get(i).getY() < list.get(j).getY()){
                        rank[i]++;
                    }
                }
            }

            for (int r : rank){
                System.out.print(r + " ");
            }
        }
    }
}

// 한번에 두개의 값을 저장하기 위해 새로운 객체 생성
class Arr{
    int x, y;
    public Arr(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}