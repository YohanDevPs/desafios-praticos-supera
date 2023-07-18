package desafio04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantityLines = scanner.nextInt();
        scanner.nextLine();

        List<String> linesToFix = new ArrayList<>();

        for (int i = 0; i < quantityLines; i++) {
            linesToFix.add(scanner.nextLine());
        }

        printFixedLines(linesToFix);
    }

    private static void printFixedLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(fixLine(line));
        }
    }

    private static String fixLine(String frase) {
        int averageIndex = frase.length() / 2;
        StringBuilder firstHalf = new StringBuilder(frase.substring(0, averageIndex));
        StringBuilder secondHalf = new StringBuilder(frase.substring(averageIndex));

        return firstHalf.reverse().append(secondHalf.reverse()).toString();
    }
}