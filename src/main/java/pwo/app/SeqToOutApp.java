package pwo.app;

import pwo.utils.SequenceTools;
/**
 * Klasa generatora SeqToOutApp dziedzicząca po klasie SeqToFileApp.
 * Odpowiada za generowanie sekwencji liczb i wyświetlanie ich w konsoli.
 * Dziedziczy po klasie SeqToFileApp, a nadpisuje jej metody w celu dostosowania do wyświetlania w terminalu.
 * @author student
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Pobiera argumenty dla aplikacji SeqToOutApp.
     * Wywołuje metodę getArgs z klasy bazowej (SeqToFileApp), a następnie sprawdza dodatkowe warunki.
     * @param args Tablica argumentów wiersza poleceń.
     * @return true, jeśli argumenty są poprawne; false w przeciwnym razie.
     */
    @Override
    protected boolean getArgs(String[] args) {
        if (super.getArgs(args)) {
            return true;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Generuje sekwencję liczb i wyświetla je w kolumnie w konsoli.
     * Wywołuje metodę getTermsAsColumn z klasy SequenceTools w celu uzyskania sekwencji.
     * Wykorzystuje generator sekwencji, zakres od do, i drukuje wyniki w konsoli.
     * @return true, jeśli operacja zapisu zakończyła się pomyślnie; false w przeciwnym razie.
     */
    @Override
    protected boolean wirteSeq() {
        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));
        return true;
    }

    /**
     * Metoda uruchamiająca aplikację SeqToOutApp.
     * Wyświetla komunikat powitalny, pobiera i analizuje argumenty, a następnie generuje i wyświetla sekwencję w konsoli.
     * @param args Tablica argumentów wiersza poleceń. args
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }
        wirteSeq();
    }
}
