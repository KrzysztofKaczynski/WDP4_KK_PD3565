/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fname = System.getProperty("user.home") + "/test/daty.txt";

        Scanner scan = null;

        try {
            scan = new Scanner(new File(fname));
        } catch (FileNotFoundException exc) {
            System.out.println("***");
            System.exit(0);
        }

        while (scan.hasNextLine()) {
            String zmienna = scan.nextLine();
            String[] podzial = zmienna.split("[^0-9-]+");
            //	String[] s = zmienna.split("[a-zA-Z ]+");

            for (String x : podzial) {

                if (x.matches("^(\\d{4}-?\\d{2}-?\\d{2})$")) {
                    String[] LataMiesaceDni = x.split("-");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar calendar = new GregorianCalendar(Integer.valueOf(LataMiesaceDni[0]), (Integer.valueOf(LataMiesaceDni[1]) - 1), Integer.valueOf(LataMiesaceDni[2]));
                    String sprawdzenie = sdf.format(calendar.getTime());
                    if (sprawdzenie.equals(x)) System.out.print(x + " ");
                }
            }
        }
    }
}
