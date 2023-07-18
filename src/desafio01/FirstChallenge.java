package desafio01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FirstChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int novoNumero = scanner.nextInt();
            if(novoNumero % 2== 0) {
                pares.add(novoNumero);
            } else {
                impares.add(novoNumero);
            }
        }

        pares.sort(Comparator.naturalOrder());
        impares.sort(Comparator.reverseOrder());

        imprimirLista(pares);
        imprimirLista(impares);
    }


    private static void imprimirLista(List<Integer> lista) {
        for (Integer numero : lista) {
            System.out.println(numero);
        }
    }
}