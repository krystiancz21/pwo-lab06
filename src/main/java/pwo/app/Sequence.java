package pwo.app;
/**
 * Klasa generatora Sequence
 * Reprezentuje główną klasę programu do generowania sekwencji liczb.
 * Akceptuje argumenty wiersza poleceń i uruchamia odpowiednią aplikację na podstawie ich liczby.
 * W zależności od liczby argumentów wywołuje aplikację SeqToOutApp lub SeqToFileApp.
 * Jeśli podane są trzy argumenty, uruchamia SeqToOutApp z odpowiednimi parametrami.
 * Jeśli podane są cztery argumenty, uruchamia SeqToFileApp z odpowiednimi parametrami.
 * W przypadku nieprawidłowej liczby argumentów wyświetla komunikat o błędzie.
 * @author student
 */

public class Sequence {

    /**
     * Główna metoda programu Sequence.
     * Akceptuje argumenty wiersza poleceń i uruchamia odpowiednią aplikację na podstawie ich liczby.
     * @param args Tablica argumentów wiersza poleceń.
     */
    public static void main(String[] args) {
        switch (args.length) {
            case 3:
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                (new SeqToFileApp()).run(args);
                break;
            default:
                System.out.println("!Illegal arguments\n"
                        + "Legal usage: seqName from to [fileName]");
        }
    }
}

//package pwo.app;
//public class Sequence {
//
//    public static void main(String[] args) {
//        (new SeqToFileApp()).run(args);
//    }
//}
