import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = Integer.parseInt(sc.next());
        int B = Integer.parseInt(sc.next());

        if  (-10000 <= A && A <= 10000 && -10000 <= B && B <= 10000){
            if(A > B){
                System.out.println(">");
            } else if (A < B){
                System.out.println("<");
            } else {
                System.out.println("==");
            }
        }
    }
}