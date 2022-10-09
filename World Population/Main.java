import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String path = "dataset_91069.txt";
        File file = new File(path);

        List<String> years = new ArrayList<>();
        List<Long> population = new ArrayList<>();

        int year = 0;
        long maxDiference = 0;



        try(Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNext()) {
               String[] sFile = scanner.nextLine().split("\t");

               years.add(sFile[0]);
               population.add(Long.parseLong(sFile[1].replaceAll(",", "")));

               if (population.size() > 1) {
                   if (population.get(population.size() - 1) - population.get(population.size() - 2) > maxDiference) {
                       maxDiference = population.get(population.size() - 1) - population.get(population.size() - 2);
                       year = Integer.parseInt(years.get(years.size() - 1));
                   }
               }
            }
        } catch (IOException e) {
            System.out.println("fuck");
        }

        System.out.println(year + " " + maxDiference);
    }
}


