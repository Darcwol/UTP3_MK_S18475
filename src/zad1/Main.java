/**
 *
 *  @author Maneichyk Kiril S18475
 *
 */

package zad1;


import java.util.*;

public class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when(destination -> ((String) destination).charAt(0) == 'W' && ((String) destination).charAt(1) == 'A'
                               && ((String) destination).charAt(2) == 'W')
                       .mapEvery((Object destination) -> {
                         double price = Double.parseDouble(((String) destination).split(" ")[2]) * xrate;
                         String in = ((String) destination).split(" ")[1];
                         return "to "+ in +" - price in PLN:	"+(int) price;
                       });
  }

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
