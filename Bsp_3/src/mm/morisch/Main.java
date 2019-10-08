package mm.morisch;

import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Tim", "Adni", "Michael");
        final Mapper<String, Integer> intMapper = String::length;
        System.out.println(intMapper.mapAll(names));

        final Mapper<String, String> stringMapper = str -> ">>" + str.toUpperCase() + "<<";
        final List<String> uppercaseNames = stringMapper.mapAll(names);
        uppercaseNames.stream().forEach(System.out::println);
    }
}
