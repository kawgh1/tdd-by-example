package guru.springframework;

import java.util.HashMap;

/**
 * created by kw on 12/2/2020 @ 12:01 PM
 *
 * We want the Bank object to determine the currency exchange rates and not the Expressions or implementations
 */
public class Bank {

    private final HashMap<Pair, Integer> rateMap = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
//        if(source instanceof Money) return (Money) source;
//        Sum sum = (Sum) source;
//        return sum.reduce(toCurrency);

        return source.reduce(this, toCurrency);
    }

    public int rate(String from, String to) {
//        return (from.equals("CHF") && to.equals("USD")) ? 2 : 1;

        // if comparing same currency  (from = to), always 1:1 rate
        if (from.equals(to)){
            return 1;
        }

        return rateMap.get(new Pair(from, to));

    }

    public void addRate(String from, String to, int rate) {
        // Java 8 Autoboxing = takes in an int, boxes to Integer when passed to HashMap<Pair, Integer>
        rateMap.put(new Pair(from, to), rate);
    }
}
