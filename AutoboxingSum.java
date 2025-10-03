import java.util.Scanner;

public class AutoBoxingSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        Integer obj1 = num1;
        Integer obj2 = num2;
        int sum = obj1 + obj2;
        System.out.println("Sum = " + sum);
        sc.close();
    }
}
