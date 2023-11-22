package pwo.seq;

import java.math.BigDecimal;
/**
 * Klasa generatora LucasGenerator dziedzicząca po klasie FibonacciGenerator
 * Reprezentuje generator liczb Lucasa, który dziedziczy po generatorze liczb Fibonacciego.
 * @author student
 */
public class LucasGenerator extends FibonacciGenerator {

    /**
     * Konstruktor klasy LucasGenerator.
     * Inicjuje zmienne current i f_2 dla generatora liczb Lucasa.
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Metoda resetująca generator Lucasa do stanu początkowego.
     * Przesłania metodę reset z klasy bazowej (FibonacciGenerator).
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Generuje kolejną liczbę Lucasa w sekwencji.
     * Jeśli indeks ostatnio wygenerowanej liczby wynosi 0, zwraca 2.
     * W przeciwnym razie używa metody nextTerm z klasy bazowej (FibonacciGenerator).
     * @return Kolejna liczba Lucasa w sekwencji jako BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
}
