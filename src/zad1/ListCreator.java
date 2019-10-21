package zad1;


import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ListCreator<T> {
    List<T> destinations;
    private static ListCreator creator;

    public static<Ts> ListCreator collectFrom(List<Ts> destinations) {
        if(creator == null){
            creator = new ListCreator();
            creator.destinations = destinations;
        }
        return creator;
    }


    public ListCreator when(Predicate<T> p) {
        List<T> rightDestinations = new ArrayList<>();
        destinations.forEach((T destination)->{
            if(p.test(destination)) rightDestinations.add(destination);
        });
        destinations = rightDestinations;
        return this;
    }

    public List<T> mapEvery(UnaryOperator<T> f) {
        List<T> result = new ArrayList<>();
        destinations.forEach((T destination)->{
            result.add(f.apply(destination));
        });
        return result;
    }
}
