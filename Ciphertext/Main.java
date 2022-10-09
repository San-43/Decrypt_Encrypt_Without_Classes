import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (checkValue(args)) {
            System.out.println("Error: argument without value");
            System.exit(0);
        }

        String mode = "";
        String pathIn = "";
        String pathOut = "";

        List<Character> data = new ArrayList<>();

        int key = 0;
        int dataIndex = -1;
        boolean checkData = false;

        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                checkData = true;
                dataIndex = i;
            } else if ("-out".equals(args[i])) {
                pathOut = args[i + 1];
            } else if ("-in".equals(args[i])) {
                pathIn = args[i + 1];
            }
        }

        formatData(args, pathIn, data, dataIndex, checkData);


        if ("dec".equals(mode)) {
            decrypt(data, key);

            out(pathOut, data);

        } else {
            encrypt(data, key);

            out(pathOut, data);
        }
    }

    private static void formatData(String[] args, String pathIn, List<Character> data, int dataIndex, boolean checkData) {
        if (!checkData && "".equals(pathIn)) {
            System.out.println("Error: no data");
        } else if (checkData) {
            char[] dataCh = args[dataIndex + 1].toCharArray();

            addingData(data, dataCh);
        } else {
            File fileIn = new File(pathIn);
            try(Scanner scanner = new Scanner(fileIn)) {
                while (scanner.hasNext()) {
                    char[] dataCh = scanner.nextLine().toCharArray();

                    addingData(data, dataCh);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void out(String pathOut, List<Character> data) {
        if ("".equals(pathOut)) {
            standardOut(data);
        } else {
            File fileOut = new File(pathOut);
            try(PrintWriter printWriter = new PrintWriter(fileOut)) {
                for (char ch : data) {
                    printWriter.print(ch);
                }

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void standardOut(List<Character> data) {
        for (char ch : data) {
            System.out.print(ch);
        }
    }

    private static void addingData(List<Character> data, char[] dataCh) {
        for (char ch : dataCh) {
            data.add(ch);
        }
    }

    private static boolean checkValue(String[] args) {
        final String[] arguments = {"-mode", "-key", "-data", "-in", "-out"};

        try {
            for (int i = 0; i < args.length; i += 2) {
                for (int j = 0; j < arguments.length; j++) {
                    if (args[i + 1].equals(arguments[j])) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: use the rigth format argument-value");
            System.exit(0);
        }
        return false;
    }

    private static void decrypt(List<Character> input, int key) {
        input.replaceAll(character -> (char) (character - key));
    }

    private static void encrypt(List<Character> input, int key) {
        input.replaceAll(character -> (char) (character + key));
    }
}


