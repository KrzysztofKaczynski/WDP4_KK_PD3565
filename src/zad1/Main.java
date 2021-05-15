/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad1;


import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        String tekst = JOptionPane.showInputDialog("Podaj tekst","ala ma kota, ale ala nie ma psa; kota ma ala");
        System.out.println("1) "+tekst.length());  //dlugosc tekstu
        System.out.println("2) "+tekst.subSequence(0, 1)+" "+tekst.substring(tekst.length()-1, tekst.length() )); // piersza i ostatnia litera
        System.out.println("3) "+tekst.substring(3, tekst.length() )); // od 4 litery do konca
        System.out.println("4) "+tekst.substring(3, tekst.length()-1 )); //od 4 litery do przed ostatniej
        String podTekst = JOptionPane.showInputDialog("Podaj szukany tekst","al");
        int pozycja=0;
        int licznik=0;
        do
        {

            if (tekst.indexOf(podTekst, pozycja)!=-1)
            {
                // System.out.println(tekst.indexOf(podTekst, pozycja)); //sprawdzanie gdzie znaleziono podtekst
                licznik++;
                pozycja=tekst.indexOf(podTekst, pozycja)+1;
            }else pozycja=podTekst.length();



        }while (pozycja!=podTekst.length());

        System.out.println("5) "+licznik); //ilosc wystapien podtekstu

        System.out.print("6) ");
        StringTokenizer st = new StringTokenizer(tekst, "[ .,;]");

        ArrayList<String> tablicaArray = new ArrayList<String>();

        while (st.hasMoreTokens())
        {
            String s=st.nextToken();
            tablicaArray.add(s);
            System.out.print(s);
            if (st.hasMoreElements()) System.out.print(" ");
        }
        System.out.println();
        System.out.print("7) "+tablicaArray.get(0).equals(tablicaArray.get(tablicaArray.size()-1)));

    }
}

