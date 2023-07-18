package segundo_desafio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static segundo_desafio.CurrencyUtils.createCoinList;
import static segundo_desafio.CurrencyUtils.createNoteList;

public class SecondChallenge {

    public static final String MOEDA = " moeda(s) de R$ ";
    public static final String NOTA = " nota(s) de R$ ";

    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        List<BigDecimal> availableNotes = createNoteList();
        List<BigDecimal> availableCoins = createCoinList();

        BigDecimal valorTotal = scanner.nextBigDecimal();

        printMinimumAmountOfNotesAndCoins(valorTotal, availableNotes, availableCoins);
    }

    private static void printMinimumAmountOfNotesAndCoins(BigDecimal currentAmount,
                                                        List<BigDecimal> availableNotes,
                                                        List<BigDecimal> availableCoins) {
        var remainingAmount = calculateRemaningAndPrintNotes(currentAmount, availableNotes);
        printCoins(remainingAmount, availableCoins);
    }

    private static BigDecimal calculateRemaningAndPrintNotes(BigDecimal currentAmount, List<BigDecimal> availableNotes) {
        System.out.println("NOTAS:");

        availableNotes.sort(Comparator.reverseOrder());
        var remainingAmount = currentAmount;

        remainingAmount = executePrintAndTakeRemaining(availableNotes, remainingAmount, NOTA);
        return remainingAmount;
    }

    private static void printCoins(BigDecimal currentAmount,  List<BigDecimal> availableCoins) {
        System.out.println("MOEDAS:");

        availableCoins.sort(Comparator.reverseOrder());
        var remainingAmount = currentAmount;

        executePrintAndTakeRemaining(availableCoins, remainingAmount, MOEDA);
    }

    private static BigDecimal executePrintAndTakeRemaining(List<BigDecimal> availableNotes, BigDecimal remainingAmount, String lineText) {
        for (BigDecimal noteType: availableNotes) {
            var typeNote = getIsolateMinimumCurrency(remainingAmount, noteType);
            System.out.println(typeNote + lineText + noteType);
            remainingAmount = getRemainderCurrency(remainingAmount, noteType);
        }
        return remainingAmount;
    }

    private static BigDecimal getRemainderCurrency(BigDecimal remainingNotes, BigDecimal noteValue) {
       return remainingNotes.remainder(noteValue);
    }

    private static BigDecimal getIsolateMinimumCurrency(BigDecimal valorTotal, BigDecimal valorNota) {
        return valorTotal.divide(valorNota, 0, RoundingMode.FLOOR);
    }
}
