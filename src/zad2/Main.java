/**
 *
 *  @author Maneichyk Kiril S18475
 *
 */

package zad2;


/*<-- niezbędne importy */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

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
    List<String> result = dest.stream().filter(destination -> destination.charAt(0) == 'W' && destination.charAt(1) == 'A'
            && destination.charAt(2) == 'W').map((destination) -> {
      double price = Double.parseDouble(destination.split(" ")[2]) * ratePLNvsEUR;
      String in = destination.split(" ")[1];
      return "to "+ in +" - price in PLN:	"+(int) price;
    }).collect(Collectors.toList());
    /*<-- tu należy dopisać fragment
     * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
     * ani też żadnych własnych interfejsów
     * Podpowiedź: należy użyć strumieni
     */

    for (String r : result) System.out.println(r);
  }
}
