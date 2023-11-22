package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa generatora FibonacciGenerator
 * Ta klasa reprezentuje generator liczb Fibonacciego.
 * @author student
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor klasy FibonacciGenerator.
     * Inicjuje zmienne current, f_1 i f_2.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Metoda resetująca generator do stanu początkowego.
     * Przesłania metodę reset z klasy bazowej.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Generuje kolejną liczbę Fibonacciego w sekwencji.
     * @return Kolejna liczba Fibonacciego w sekwencji jako BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
    }
}
