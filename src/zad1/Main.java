/**
 *
 *  @author Kaczyński Krzysztof PD3565
 *
 */

package zad1;


import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    String i;
    i = JOptionPane.showInputDialog("Slowo i: ");
    int dl;
    dl = i.length();

    System.out.println("Długośc łancucha: " + dl);
    System.out.println("Pierwszy znak: " + i.charAt(0) + "\nOstatni znak: " + i.charAt(dl-1));

    int x=3;
    System.out.print("Od 3 do konca: ");
    while (x!=dl) {System.out.print(i.charAt(x));	x++; }

    x=3;
    System.out.print("\nOd 3 do przedostatniego: ");
    while (x!=(dl-1)) {System.out.print(i.charAt(x));	x++; }


  }
  }

