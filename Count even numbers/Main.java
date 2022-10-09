import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        File file = new File("dataset_91065.txt");

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.printf("%s dolor sit %s", "Lorem", "ipsum", "amet");
        }
    }
}


