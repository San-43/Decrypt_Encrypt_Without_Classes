import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int[] a = {677, 591, 153, 356, 617, 337, 195, 948, 440, 657, 631, 546, 148, 678};

        int x = a[0];

        alive(a, x);

    }

    private static void alive(int[] a, int x) {
        boolean f = false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0 && f == false) {
                x = a[i];
                f = true;
            } else if (a[i] < x && a[i] % 2 == 0) {
                x = a[i];
            }
        }

        if (f == false) {
            System.out.println(0);
        } else {
            System.out.println(x);
        }
    }
}