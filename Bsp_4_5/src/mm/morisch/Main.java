package mm.morisch;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        //Bsp 4
        final Predicate<Integer> isEven = (x) -> x % 2 == 0;
        final IntPredicate isPositive = (x) -> x > 0;
        final Predicate<String> isShortWord = (x) -> x.length() < 4;
        System.out.println("4 = isEven? => " + isEven.test(4));
        System.out.println("5 = isEven? => " + isEven.test(5));
        System.out.println("4 = isPositive? => " + isPositive.test(4));
        System.out.println("-2 = isPositive? => " + isPositive.test(-2));
        System.out.println("Hallo = isShortWord => " + isShortWord.test("Hallo"));
        System.out.println("foo = isShortWord => " + isShortWord.test("foo"));

        //Bsp 5
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(x -> x % 2 == 1).map(x -> x*x).sum();
        System.out.println(result);

    }

}
