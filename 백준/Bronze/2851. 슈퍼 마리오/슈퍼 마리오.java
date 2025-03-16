import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[10];
        int[] prev = new int[10];

        for (int i = 0 ; i < 10 ; i++){
            int mario = sc.nextInt();
            prev[i] = sum;
            sum += mario;
            arr[i] = sum;
        }

        for (int i = 0 ; i < 10 ; i++){
            if (arr[i] >= 100){
//                System.out.println("arr[" + i+ "] : " + arr[i] + ", prev[" + i +"] : " + prev[i]);
//                System.out.println("arr[" + i+ "] abs: " + Math.abs(arr[i] - 100) + ", prev[" + i +"] abs: " + Math.abs(prev[i] - 100));
                if (Math.abs(arr[i] - 100) <= Math.abs(prev[i] - 100)){
                    System.out.println(arr[i]);
                    break;
                } else if ((Math.abs(arr[i] - 100) > Math.abs(prev[i] - 100))){
                    System.out.println(prev[i]);
                    break;
                }
            }
        }
        if (sum < 100){
            System.out.println(sum);
        }
    }
}