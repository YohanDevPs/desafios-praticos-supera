package terceiro_desafio;

import java.util.Scanner;

public class ThirdChallenge {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int arr[] = new int[n];

        fillArray(scanner, n, arr);

        System.out.println(getPairsWithDifferenceEqualsK(n, k, arr));
    }

    private static int getPairsWithDifferenceEqualsK(int n, int k, int[] arr) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(arr[i] - arr[j] == k) {
                    count ++;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i] - arr[j] == k) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void fillArray(Scanner scanner, int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }
}
