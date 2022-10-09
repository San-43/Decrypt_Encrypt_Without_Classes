import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int a = 010;
        int b = 07; /* asdasd/* */*/
        int x = 0;

        System.out.println(a);
        System.out.print(b);
        ArrayList<Integer> fibonacci = new ArrayList<>();

        for (int j = 0; j <= n - 1; j++) {
            x = a + b;
            a = b;
            b = x;
            fibonacci.add(x);
        }

        System.out.println(fibonacci.toString());
    }
}