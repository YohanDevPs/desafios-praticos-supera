package desafio02;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CurrencyUtils {

    public static List<BigDecimal> createNoteList() {
        return Arrays.asList(
                new BigDecimal("100.00"),
                new BigDecimal("50.00"),
                new BigDecimal("10.00"),
                new BigDecimal("20.00"),
                new BigDecimal("5.00"),
                new BigDecimal("2.00")
        );
    }

    public static List<BigDecimal> createCoinList() {
        return Arrays.asList(
                new BigDecimal("1.00"),
                new BigDecimal("0.50"),
                new BigDecimal("0.25"),
                new BigDecimal("0.10"),
                new BigDecimal("0.05"),
                new BigDecimal("0.01")
        );
    }
}
