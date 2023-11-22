package pwo.seq;

import java.math.BigDecimal;
/**
 * Klasa generatora TribonacciGenerator dziedzicząca po klasie FibonacciGenerator
 * Reprezentuje generator liczb Tribonacciego, który dziedziczy po generatorze liczb Fibonacciego.
 * @author student
 */

public class TribonacciGenerator extends FibonacciGenerator {

    /**
     * Konstruktor klasy TribonacciGenerator.
     * Inicjuje zmienną f_3 dla generatora liczb Tribonacciego.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Metoda resetująca generator Tribonacciego do stanu początkowego.
     * Przesłania metodę reset z klasy bazowej (FibonacciGenerator).
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Generuje kolejną liczbę Tribonacciego w sekwencji.
     * Jeśli indeks ostatnio wygenerowanej liczby jest większy niż 2,
     * oblicza kolejną liczbę jako sumę trzech poprzednich (f_1, f_2, f_3).
     * W przeciwnym razie, dla indeksów 0 i 1 generuje 0, a dla indeksu 2 generuje 1.
     * Aktualizuje zmienne f_1, f_2, f_3 i zwraca wygenerowaną liczbę.
     * @return Kolejna liczba Tribonacciego w sekwencji jako BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
