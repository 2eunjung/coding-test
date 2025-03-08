import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] doreme = new int[8];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < doreme.length; i++) {
            doreme[i] = sc.nextInt();
        }

        // 배열을 입력받아 하나의 문자열로 변환
        /*
            StringBuilder는 문자열을 조작할 때 성능을 최적화하기 위해 제공되는 가변(mutable) 문자열 클래스
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < doreme.length; i++) {
            sb.append(doreme[i]);
            if (i < doreme.length - 1) {
                sb.append(" ");
            }
        }
        String result = sb.toString();

        switch (result) {
            case "1 2 3 4 5 6 7 8":
                System.out.println("ascending");
                break;
            case "8 7 6 5 4 3 2 1":
                System.out.println("descending");
                break;
            default:
                System.out.println("mixed");
        }
    }
}