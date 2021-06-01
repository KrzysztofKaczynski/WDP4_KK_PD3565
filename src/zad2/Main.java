/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String fname = System.getProperty("user.home") + "/test/daty.txt";
        Pattern datePattern = Pattern.compile("^.*([12][0-9]{3}-\\d{2}-\\d{2}).*$");

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
            // String[] s = zmienna.split("[a-zA-Z ]+");
            for (String x : podzial) {

                // Liczba dni moze byc wieksza niz 2, w tym wypadku trzeba skrocic string do pierwszych 10 znaków.
                if (x.length() > 10) {
                    x = x.substring(0, 9);
                }

                Matcher matcher = datePattern.matcher(x);
                if (matcher.find()) {
                    String match = matcher.group(1);
                    try {
                        LocalDate.parse(match);
                        System.out.print(match + " ");
                    } catch (DateTimeException e) {
                    }
                }
            }
        }

    }
}
