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
        System.out.println("2) " + tekst.charAt(0) + " " + tekst.substring(tekst.length() - 1)); // piersza i ostatnia litera

        // Tutaj według treści zadania powinno być tekst.substring(3), ale nie pokrywa się to z testami.
        // Treść polecenia powinna brzmieć "Od 5 znaku" albo "Od znaku na pozycji na 4".
        // Sformułowanie w języku polskim "od X znaku" zakłada, że bierzemy ten znak pod uwagę.
        // W szczególności "od 1 znaku" znaczy od samego początku (index 0), a nie od drugiego (index 1).
        System.out.println("3) " + tekst.substring(4)); // od 4 litery do konca

        System.out.println("4) " + tekst.substring(4, tekst.length() - 1)); //od 4 litery do przed ostatniej

        String podTekst = args[1];
        int pozycja = 0;
        int licznik = 0;

        int index = tekst.indexOf(podTekst, pozycja);
        while (index != -1)
        {
            licznik++;
            pozycja = index + 1;
            index = tekst.indexOf(podTekst, pozycja);
        }

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

