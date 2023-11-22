package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

/**
 * Klasa generatora Generator dziedzicząca po klasie SequenceGenerator.
 * Reprezentuje abstrakcyjny generator sekwencji liczb, dziedziczący po interfejsie SequenceGenerator.
 * Zawiera implementację podstawowych operacji zdefiniowanych w interfejsie.
 * Klasa jest abstrakcyjna, co oznacza, że nie może być bezpośrednio instancjonowana, a jej metody muszą być zaimplementowane w klasach pochodnych.
 * Składa się z metod do resetowania generatora oraz uzyskiwania konkretnych terminów sekwencji.
 * @author student
 */
abstract class Generator implements SequenceGenerator {

    protected int lastIndex = 0;
    protected BigDecimal current = null, f_1 = null, f_2 = null, f_3 = null;

    /**
     * Resetuje generator do stanu początkowego.
     * Ustawia indeks ostatnio wygenerowanego terminu na 0.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Pobiera wartość konkretnego terminu sekwencji.
     * Jeśli indeks jest mniejszy niż 0, zgłasza błąd.
     * Jeśli indeks jest mniejszy lub równy ostatniemu indeksowi, resetuje generator.
     * Następnie generuje kolejne terminy, aż osiągnie żądany indeks.
     * @param i Indeks terminu sekwencji do pobrania.
     * @return Wartość terminu sekwencji o podanym indeksie.
     * @throws IllegalArgumentException Jeśli indeks jest mniejszy niż 0.
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}
