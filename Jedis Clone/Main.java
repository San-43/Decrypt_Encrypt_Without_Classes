import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int p = scanner.nextInt();
        int t = scanner.nextInt();

        jedi(x, p, t);
    }

    private static void jedi(int x, int p, int t) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);

        for (int i = 1; i <= t; i++) {
            list.add(list.get(i - 1) * x);
        }

        for (int i = p - 1; i <= t; i++) {
            if (i == t) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }

        System.out.println(list.toString());
    }
}