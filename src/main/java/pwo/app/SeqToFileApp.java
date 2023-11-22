package pwo.app;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import pwo.seq.SeqType;
import pwo.utils.SequenceTools;

/**
 * Klasa generatora SeqToFileApp.
 * Pozwala na zapis do pliku wybranego rodzaju ciągu o odpowiednim punkcie startowym i końcowym.
 * Klasa ta zawiera metody do obsługi argumentów, zapisu sekwencji do pliku oraz uruchamiania aplikacji.
 * Dziedziczy po niej klasa SeqToOutApp, dostosowując jej funkcje do wyświetlania w terminalu.
 * @author student
 */

class SeqToFileApp {

    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    /**
     * Pobiera i analizuje argumenty dla aplikacji SeqToFileApp.
     * Sprawdza poprawność liczby argumentów, konwertuje je na odpowiednie typy, a także sprawdza poprawność ścieżki do pliku.
     * @param args Tablica argumentów wiersza poleceń.
     * @return true, jeśli argumenty są poprawne; false w przeciwnym razie.
     */
    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            return false;
        }

        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Zapisuje sekwencję liczb do pliku.
     * Wywołuje metodę writeToFile z klasy SequenceTools w celu zapisu sekwencji do pliku.
     * @return true, jeśli operacja zapisu zakończyła się pomyślnie; false w przeciwnym razie. 
     */
    protected boolean wirteSeq() {
        return SequenceTools.writeToFile(
                seqType.getGenerator(),
                from,
                to,
                fileName
        );
    }

    /**
     * Metoda uruchamiająca aplikację SeqToFileApp.
     * Wyświetla komunikat powitalny, pobiera i analizuje argumenty, a następnie zapisuje sekwencję do pliku.
     * Wyświetla stosowne komunikaty w przypadku błędów lub sukcesu operacji zapisu.
     * @param args Tablica argumentów wiersza poleceń.
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        if (!getArgs(args)) {
            System.out.println(
                    "!Illegal arguments\n" + "Legal usage: seqName from to fileName"
            );
            return;
        }

        if (!wirteSeq()) {
            System.out.println("!Write to the file: " + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}
