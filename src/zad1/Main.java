/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad1;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String tekst = args[0];
        System.out.println("1) " + tekst.length());  //dlugosc tekstu
        System.out.println("2) " + tekst.subSequence(0, 1) + " " + tekst.substring(tekst.length() - 1, tekst.length())); // piersza i ostatnia litera
        System.out.println("3) " + tekst.substring(3)); // od 4 litery do konca
        System.out.println("4) " + tekst.substring(3, tekst.length() - 1)); //od 4 litery do przed ostatniej
        String podTekst = args[1];
        int pozycja = 0;
        int licznik = 0;
        do {
            if (tekst.indexOf(podTekst, pozycja) != -1) {
                // System.out.println(tekst.indexOf(podTekst, pozycja)); //sprawdzanie gdzie znaleziono podtekst
                licznik++;
                pozycja = tekst.indexOf(podTekst, pozycja) + 1;
            } else pozycja = podTekst.length();
        } while (pozycja != podTekst.length());
        System.out.println("5) " + licznik); //ilosc wystapien podtekstu
        System.out.print("6) ");
        StringTokenizer st = new StringTokenizer(tekst, "[ .,;]");
        ArrayList<String> tokensArray = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            tokensArray.add(s);
        }
        System.out.print(tokensArray.stream().collect(Collectors.joining("_")));
        System.out.println();
        System.out.print("7) " + tokensArray.get(0).equals(tokensArray.get(tokensArray.size() - 1)));
    }

}

